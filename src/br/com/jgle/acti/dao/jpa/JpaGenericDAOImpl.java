package br.com.jgle.acti.dao.jpa;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import br.com.jgle.acti.component.FiltroVO;
import br.com.jgle.acti.component.FiltroVO.AttributeComparator;
import br.com.jgle.acti.component.FiltroVO.AttributeOperator;
import br.com.jgle.acti.exception.DAOException;
import br.com.jgle.acti.util.DateUtil;

/**
 * Classe que deve ser extendida pelos DAO's em JPA. Facilita operações de CRUD.
 * 
 * @author Danilo I. Chaves
 */
@SuppressWarnings({ "unchecked", "deprecation" })
@Repository(value = "jpaGenericDAO")
public class JpaGenericDAOImpl extends JpaDaoSupport implements JpaGenericDAO {

	@PersistenceContext
	protected EntityManager em;

	@Autowired
	@Required
	public void setJpaEntityManagerFactory(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		super.setEntityManagerFactory(entityManagerFactory);
	}

	public <T> void inserir(T entity) throws DataAccessException {
		getJpaTemplate().persist(entity);
	}

	public <T> void remover(T entity) throws DataAccessException {
		if (!getJpaTemplate().contains(entity)) {
			entity = getJpaTemplate().merge(entity);
		}
		getJpaTemplate().remove(entity);
	}

	public final <T> T atualizar(T entity) throws DataAccessException {
		return getJpaTemplate().merge(entity);
	}

	public final <T> T procurarPorId(Class<T> entityClass, Object id)
			throws DataAccessException {
		assertEntidade(entityClass);
		return getJpaTemplate().find(entityClass, id);
	}
	
	public final <T> List<T> procurarTodos(Class<T> entityClass)
		throws DataAccessException, DAOException {
		return procurarTodos(entityClass, 0);
	}
	

	public final <T> List<T> procurarTodos(Class<T> entityClass, int qtd)
			throws DataAccessException, DAOException {
		assertEntidade(entityClass);
		// return getJpaTemplate().find("from " + entityClass.getName());
		List<T> lista = getLista(entityClass, null, 0, 0, "");

		return lista;
	}

	public final <T> List<T> procurarPorNomeEParametros(String queryName,
			Map<String, ?> params) throws DataAccessException {

		return getJpaTemplate().findByNamedQueryAndNamedParams(queryName,
				params);
	}

	// Procurar por Select
	// Query
	public final <T> T executeQuerySingle(String queryString, String name,
			Object value) throws DataAccessException {
		Query query = em.createQuery(queryString);
		query.setParameter(name, value);
		T result = (T) query.getSingleResult();

		return result;
	}

	public final <T> T executeQuerySingle(String queryString,
			Map<String, Object> map) throws DataAccessException {
		Query query = em.createQuery(queryString);
		if (null != map && !map.isEmpty()) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		T result = (T) query.getSingleResult();

		return result;
	}

	public final <T> List<T> executeQuery(String queryString, String name,
			Object value) throws DataAccessException {
		Query query = em.createQuery(queryString);
		query.setParameter(name, value);
		List<T> resultList = query.getResultList();

		return resultList;
	}

	public final <T> List<T> executeQuery(String queryString,
			Map<String, Object> map) throws DataAccessException {
		Query query = em.createQuery(queryString);

		if (null != map && !map.isEmpty()) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		List<T> resultList = query.getResultList();

		return resultList;
	}

	// JPA 2 consulta por CriteriaBuild e CriteriaQuery
	@SuppressWarnings("rawtypes")
	public final <T> List<T> procurarSimples(Class<T> entityClass,
			Map<String, ?> params) throws DataAccessException {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> root = cq.from(entityClass);

		Predicate restrictions = null;
		for (final Map.Entry<String, ? extends Object> param : params
				.entrySet()) {
			Path field = getField(cq, root, param.getKey());
			Predicate predicate = cb.like(cb.upper(field),
					(String) param.getValue());
			if (restrictions == null) {
				restrictions = predicate;
			} else {
				restrictions = cb.or(restrictions, predicate);
			}
		}

		cq.select(root).where(restrictions);

		return em.createQuery(cq).getResultList();
	}

	public <T> Integer getTotal(Class<T> entityClass, List<FiltroVO> filtros)
			throws DAOException {

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Long> cq = cb.createQuery(Long.class);

			Root<T> root = cq.from(entityClass);
			cq.select(cb.count(root));

			Predicate restricoes = getRestricoes(entityClass, filtros);
			cq.where(restricoes);

			int maxResults = em.createQuery(cq).getSingleResult().intValue();

			return maxResults;

		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public <T> List<T> getLista(Class<T> entityClass, List<FiltroVO> filtros,
			int pagina, int qtd, String... camposOrdem) throws DAOException {
		try {

			TypedQuery<T> query = getTypedQuery(entityClass, filtros, pagina,
					qtd, camposOrdem);

			List<T> resultList = query.getResultList();

			return resultList;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return em.getCriteriaBuilder();
	}

	protected <T> CriteriaQuery<T> getCriteriaQuery(Class<T> entityClass) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(entityClass);

		return q;
	}

	@SuppressWarnings({ "rawtypes" })
	protected <T, Y extends Comparable<? super Y>> TypedQuery getTypedQuery(
			Class<T> entityClass, List<FiltroVO> filtros, int pagina, int qtd,
			String... camposOrdem) throws DAOException, ParseException {

		CriteriaBuilder cb = getCriteriaBuilder();

		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> root = cq.from(entityClass);

		cq.select(root);

		TypedQuery<T> createQuery = em.createQuery(cq);

		int inicio = pagina * qtd;
		createQuery.setFirstResult(inicio);
		if (qtd > 0) {
			createQuery.setMaxResults(qtd);
		}

		if (camposOrdem != null && camposOrdem.length > 0) {
			setupOrdem(cb, cq, root, camposOrdem);
		}

		Predicate resticoes = getRestricoes(entityClass, filtros);

		cq.where(resticoes);

		return createQuery;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	protected <T, Y extends Comparable<? super Y>> Predicate getRestricoes(
			Class<T> entityClass, List<FiltroVO> filtros) throws ParseException {

		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> root = cq.from(entityClass);

		List<Predicate> criteria = new ArrayList<Predicate>();
		if (filtros != null && filtros.size() > 0) {
			Predicate disjunction = cb.disjunction();
			Predicate conjunction = cb.conjunction();

			for (FiltroVO filtro : filtros) {
				if (!filtro.isValido())
					continue;

				Path field = getField(cq, root, filtro.getAttributeCampo());

				Y attrValueObject = filtro.getAttributeValueObject();

				Predicate junction = null;
				if (filtro.getAttributeOperator() != null
						&& filtro.getAttributeOperator().equals(
								AttributeOperator.OU)) {
					junction = disjunction;
				} else {
					junction = conjunction;
				}

				if (filtro.getAttributeComparator().equals(
						AttributeComparator.EQUALS)) {

					if (attrValueObject instanceof Date) {
						if (((Date) attrValueObject).getHours() == 0
								&& ((Date) attrValueObject).getMinutes() == 0) {
							criteria.add(cb.between(
									field,
									DateUtil.lowDateTime((Date) attrValueObject),
									DateUtil.highDateTime((Date) attrValueObject)));
						} else {
							criteria.add(cb.between(
									field,
									(Date) attrValueObject,
									DateUtil.addMinuteDateTime((Date) attrValueObject)));
						}
					} else {
						criteria.add(cb.equal(field, attrValueObject));
					}
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.LIKE)) {
					criteria.add(cb.like(cb.upper(field), ("%"
							+ attrValueObject + "%").toUpperCase()));
				} else if (filtro.getAttributeComparator().equals("!=")) {
					criteria.add(cb.notEqual(field, attrValueObject));
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.MORE)) {
					criteria.add(cb.greaterThan(field, attrValueObject));
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.LESS)) {
					criteria.add(cb.lessThan(field, attrValueObject));
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.EQUALS_MORE)) {
					criteria.add(cb
							.greaterThanOrEqualTo(field, attrValueObject));
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.EQUAL_LESS)) {
					criteria.add(cb.lessThanOrEqualTo(field, attrValueObject));
				} else if (filtro.getAttributeComparator().equals("not empty")) {
					criteria.add(cb.isNotEmpty(field));
				} else if (filtro.getAttributeComparator().equals("empty")) {
					criteria.add(cb.isEmpty(field));
				}
			}
		}

		Predicate resticoes = cb.and(criteria.toArray(new Predicate[0]));

		return resticoes;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	protected <T> Path getField(CriteriaQuery<T> cq, Root<T> root,
			String attrCampo) {
		String[] campos = attrCampo.split("\\.");
		if (campos.length == 2) {

			Metamodel model = em.getMetamodel();
			Path<T> path = root.get(campos[0]);
			ManagedType managedType = model.managedType(path.getJavaType());
			// Attribute attr = managedType.getAttribute(campos[1]);
			Join join = root.join(campos[0]);
			join.alias(campos[0]);

			path = join.get(campos[1]);

			return path;

		} else if (campos.length > 2) {
			Path<Object> path = root.get(campos[0]);
			Selection<? extends T> alias2 = (Selection<? extends T>) path
					.alias(campos[0]);
			cq.select(alias2);
			for (int i = 1; i < campos.length; i++) {
				path = path.get(campos[i]);
				alias2 = (Selection<? extends T>) path.alias(campos[i]);
				cq.select(alias2);
			}
			return path;
		} else {
			return root.get(attrCampo);
		}
	}

	protected <T> void setupOrdem(CriteriaBuilder cb, CriteriaQuery<T> cq,
			Root<T> root, String... camposOrdem) {
		if (camposOrdem != null && camposOrdem.length > 1) {
			String ordem = camposOrdem[0];

			for (int i = 1; i < camposOrdem.length; i++) {
				if (camposOrdem[i] != null) {
					String[] campos = camposOrdem[i].split("\\.");
					if (ordem != null && ordem.equals("desc")) {

						if (campos.length > 1) {
							for (int ii = 0; ii < (campos.length - 1); ii++) {
								// critQuery =
								// critQuery.createCriteria(campos[ii]);
							}
						}
						cq.orderBy(cb.desc(root
								.get(campos[(campos.length - 1)])));
					} else {
						if (campos.length > 1) {
							for (int ii = 0; ii < (campos.length - 1); ii++) {
								// critQuery =
								// critQuery.createCriteria(campos[ii]);
							}
						}
						cq.orderBy(cb.asc(root.get(campos[(campos.length - 1)])));
					}
				}
			}
		}
	}

	// Pesquisa Usando Criteria do Hibernate

	public Session getSession() {

		return (Session) em.getDelegate();
	}

	public <T> Integer procurarBuscaAvancadaTotal(Class<T> entityClass,
			List<FiltroVO> filtros) throws DataAccessException, ParseException,
			DAOException {

		/*
		 * Criteria crit = getCriteria(entityClass, filtros, 0,
		 * 0).setProjection(Projections.rowCount());
		 * crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); return
		 * ((Number) crit.uniqueResult()).intValue();
		 */
		Integer total = getTotal(entityClass, filtros);

		return total;

	}

	public <T> List<T> procurarBuscaAvancada(Class<T> entityClass,
			List<FiltroVO> filtros, int pagina, int qtd, String... camposOrdem)
			throws DataAccessException, ParseException, DAOException {

		Criteria crit = getCriteria(entityClass, filtros, pagina, qtd,
				camposOrdem);

		return crit.list();

		// List<T> lista = getLista(entityClass, filtros, pagina, qtd,
		// camposOrdem);

		// return lista;
	}

	protected <T> Criteria getCriteria(Class<T> entityClass,
			List<FiltroVO> filtros, int pagina, int qtd, String... camposOrdem)
			throws DataAccessException, ParseException {
		Criteria criteria = getSession().createCriteria(entityClass);

		int inicio = pagina * qtd;

		criteria.setFirstResult(inicio);
		if (qtd > 0) {
			criteria.setMaxResults(qtd);
		}

		if (camposOrdem != null && camposOrdem.length > 0) {
			setupOrdem(criteria, camposOrdem);
		}

		if (filtros != null && filtros.size() > 0) {
			Conjunction conjunction = Restrictions.conjunction();
			Disjunction disjunction = Restrictions.disjunction();
			String alias = "";

			for (FiltroVO filtro : filtros) {
				if (!filtro.isValido())
					continue;
				String campo = "";
				String[] campos = filtro.getAttributeCampo().split("\\.");
				if (campos.length == 2 && !campos[1].matches("id[A-Z]\\w+")
						&& !campos[1].equals("id")) {
					if (!alias.equals(campos[0] + "0")) {
						alias = campos[0] + "0";
						criteria = criteria.createAlias(campos[0], alias);
					}
					campo = alias + "." + campos[1];
				} else if (campos.length > 2) {
					for (int i = 0; i < (campos.length - 1); i++) {
						criteria = criteria.createCriteria(campos[i]);
					}
					campo = campos[(campos.length - 1)];
				} else {
					campo = filtro.getAttributeCampo();
				}

				Junction junction = null;
				if (filtro.getAttributeOperator() == null || filtro.getAttributeOperator().equals(AttributeOperator.OU)) {
					junction = disjunction;
				} else {
					junction = conjunction;
				}

				Criterion crit = null;
				if (filtro.getAttributeComparator().equals(
						AttributeComparator.LIKE)
						&& filtro.getAttributeValue() != null
						&& !filtro.getAttributeValue().equals("")) {
					String val = (String) filtro.getAttributeValue();
					if (val.length() > 1) {
						val = "%" + val;
					}
					crit = Restrictions.ilike(campo, (val + "%"));
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.EQUALS)) {
					crit = filtro.getAttributeValue() != null ? Expression.eq(
							campo, filtro.getAttributeValue()) : Expression
							.isNull(filtro.getAttributeCampo());
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.LIKE)) {
					crit = filtro.getAttributeValue() != null ? Expression
							.ilike(campo,
									filtro.getAttributeValue().toString(),
									MatchMode.ANYWHERE) : Expression
							.isNull(filtro.getAttributeCampo());
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.NOT_LIKE)) {
					crit = filtro.getAttributeValue() != null ? Expression
							.not(Expression.ilike(campo, filtro
									.getAttributeValue().toString(),
									MatchMode.ANYWHERE)) : Expression
							.isNull(filtro.getAttributeCampo());
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.MORE)) {
					crit = Expression.gt(campo, filtro.getAttributeValue());
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.LESS)) {
					crit = Expression.lt(campo, filtro.getAttributeValue());
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.EQUALS_MORE)) {
					crit = Expression.ge(campo, filtro.getAttributeValue());
				} else if (filtro.getAttributeComparator().equals(
						AttributeComparator.EQUAL_LESS)) {
					crit = Expression.le(campo, filtro.getAttributeValue());
				} else if (filtro.getAttributeComparator().equals("not empty")) {
					crit = Expression.isNotEmpty(campo);
				} else if (filtro.getAttributeComparator().equals("empty")) {
					crit = Expression.isEmpty(campo);
				}
				if (crit != null) {
					junction.add(crit);
				}
			}
			criteria.add(conjunction);
			criteria.add(disjunction);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		}
		return criteria;
	}

	protected void setupOrdem(Criteria crit, String... camposOrdem) {
		if (camposOrdem != null && camposOrdem.length > 1) {
			String ordem = camposOrdem[0];

			for (int i = 1; i < camposOrdem.length; i++) {
				if (camposOrdem[i] != null) {
					String[] campos = camposOrdem[i].split("\\.");
					if (ordem != null && ordem.equals("desc")) {

						if (campos.length > 1) {
							for (int ii = 0; ii < (campos.length - 1); ii++) {
								crit = crit.createCriteria(campos[ii]);
							}
						}
						crit.addOrder(Property
								.forName(campos[(campos.length - 1)]).desc()
								.ignoreCase());
					} else {
						if (campos.length > 1) {
							for (int ii = 0; ii < (campos.length - 1); ii++) {
								crit = crit.createCriteria(campos[ii]);
							}
						}
						crit.addOrder(Property
								.forName(campos[(campos.length - 1)]).asc()
								.ignoreCase());
					}
				}
			}
		}
	}

	private final <T> void assertEntidade(Class<T> entityClass) {
		Assert.notNull(entityClass, "A entidade não pode ser nula");
	}

	/**
	 * Metodo para executar consultas com limites de resultados
	 * 
	 * @param queryString
	 * @param initialLimit
	 * @param finalLimit
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("rawtypes")
	public List find(final String queryString, final int initialLimit,
			final int finalLimit, final Object... values)
			throws DataAccessException {

		return getJpaTemplate().executeFind(new JpaCallback() {
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query queryObject = em.createQuery(queryString);
				queryObject.setFirstResult(initialLimit);
				queryObject.setMaxResults(finalLimit);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i + 1, values[i]);
					}
				}
				return queryObject.getResultList();
			}
		});
	}
}
