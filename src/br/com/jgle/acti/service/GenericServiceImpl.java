package br.com.jgle.acti.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jgle.acti.component.FiltroVO;
import br.com.jgle.acti.dao.jpa.JpaGenericDAO;
import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.exception.DAOException;

/**
 * Servico utilizado para acessar as operacoes simples de CRUD sobre entidades.
 * 
 * @author Danilo I. Chaves
 */

@Transactional
@Service
public class GenericServiceImpl<T> implements GenericService {

	/** Logger available to subclasses */

	@Resource
	private JpaGenericDAO jpaGenericDAO;

	private T entity;

	@SuppressWarnings("hiding")
	@Transactional(readOnly = false)
	public final <T> void inserir(T entity) {
		this.jpaGenericDAO.inserir(entity);
	}

	@SuppressWarnings("hiding")
	@Transactional(readOnly = false)
	public final <T> void remover(T entity) {
		this.jpaGenericDAO.remover(entity);
	}

	@SuppressWarnings("hiding")
	@Transactional(readOnly = false)
	public final <T extends AbstractEntity> T atualizar(T entity) {
		entity.setDataAlteracao(Calendar.getInstance().getTime());
		return this.jpaGenericDAO.atualizar(entity);
	}

	@SuppressWarnings("hiding")
	@Transactional(readOnly = true)
	public final <T> T procurarPorId(Class<T> entityClass, Object id) {
		return this.jpaGenericDAO.procurarPorId(entityClass, id);
	}

	@SuppressWarnings("hiding")
	@Transactional(readOnly = true)
	public final <T> List<T> procurarTodos(Class<T> entityClass) {
		try {
			return this.jpaGenericDAO.procurarTodos(entityClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("hiding")
	@Transactional(readOnly = true)
	public final <T> List<T> procurarTodos(Class<T> entityClass, int qtd) {
		try {
			return this.jpaGenericDAO.procurarTodos(entityClass, qtd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Transactional(readOnly = true)
	public final <T> List<T> getAll() {
		return (List<T>) procurarTodos(entity.getClass());
	}

	@SuppressWarnings({ "hiding" })
	@Transactional(readOnly = true)
	public final <T> T executeQuerySingle(String queryString, String name, Object value) {
		try {
			return this.jpaGenericDAO.executeQuerySingle(queryString, name, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "hiding" })
	@Transactional(readOnly = true)
	public final <T> T executeQuerySingle(String queryString, Map<String, Object> map) {
		try {
			return this.jpaGenericDAO.executeQuerySingle(queryString, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "hiding" })
	@Transactional(readOnly = true)
	public final <T> List<T> executeQuery(String queryString, String name, Object value) {
		try {
			return this.jpaGenericDAO.executeQuery(queryString, name, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "hiding" })
	@Transactional(readOnly = true)
	public final <T> List<T> executeQuery(String queryString, Map<String, Object> map) {
		try {
			return this.jpaGenericDAO.executeQuery(queryString, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Transactional(readOnly = true)
	public final <T extends AbstractEntity> List<T> procurarSimples(T entity, String textSearch) {
		return (List<T>) this.jpaGenericDAO.procurarSimples(entity.getClass(), entity.getParametrosSimpleSearch(textSearch));
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Transactional(readOnly = true)
	public final <T extends AbstractEntity> List<T> procurarSimples(T entity, Map<String, ?> mapSearch) {
		return (List<T>) this.jpaGenericDAO.procurarSimples(entity.getClass(), mapSearch);
	}

	@SuppressWarnings("hiding")
	@Transactional(readOnly = true)
	public final <T extends AbstractEntity> List<T> procurarBuscaAvancada(Class<T> entityClass, List<FiltroVO> filtros, int pagina, int qtd, String... camposOrdem) {
		try {
			return (List<T>) this.jpaGenericDAO.procurarBuscaAvancada(entityClass, filtros, pagina, qtd, camposOrdem);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("hiding")
	@Transactional(readOnly = true)
	public final <T> Integer procurarBuscaAvancadaTotal(Class<T> entityClass, List<FiltroVO> filtros) {
		try {
			return this.jpaGenericDAO.procurarBuscaAvancadaTotal(entityClass, filtros);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("hiding")
	@Transactional(readOnly = true)
	public final <T extends AbstractEntity> List<T> procurarPorNomeEParametros(T entity, String textSearch) {
		return this.jpaGenericDAO.procurarPorNomeEParametros("LoginServiceImpl.procurarTodos", entity.getParametrosSimpleSearch(textSearch));
	}

	public JpaGenericDAO getJpaGenericDAO() {
		return jpaGenericDAO;
	}

	public void setJpaGenericDAO(JpaGenericDAO jpaGenericDAO) {
		this.jpaGenericDAO = jpaGenericDAO;
	}

	public final void setEntidadeDAO(JpaGenericDAO entidadeDAO) {
		this.jpaGenericDAO = entidadeDAO;
	}

}
