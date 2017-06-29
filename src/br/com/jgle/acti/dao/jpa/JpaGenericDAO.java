package br.com.jgle.acti.dao.jpa;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import br.com.jgle.acti.component.FiltroVO;
import br.com.jgle.acti.exception.DAOException;

/***
 * @author Danilo I. Chaves
 * 
 */
public interface JpaGenericDAO {

	public <T> void inserir(T entityClass);

	public <T> void remover(T entityClass);

	public <T> T atualizar(T entity);

	public <T> T procurarPorId(Class<T> entityClass, Object id);
	
	public <T> T executeQuerySingle(String queryString, String name, Object value);
	
	public <T> T executeQuerySingle(String queryString, Map<String, Object> map);
	
	public <T> List<T> executeQuery(String queryString, String name, Object value);
		
	public <T> List<T> executeQuery(String queryString, Map<String, Object> map);

	public <T> List<T> procurarTodos(Class<T> entityClass) throws DataAccessException, DAOException;
	
	public <T> List<T> procurarTodos(Class<T> entityClass, int qtd) throws DataAccessException, DAOException;

	public <T> List<T> procurarPorNomeEParametros(String queryName, Map<String, ?> params);

	public <T> List<T> procurarSimples(Class<T> entityClass, Map<String, ?> params);

	public <T> List<T> procurarBuscaAvancada(Class<T> entityClass, List<FiltroVO> filtros, int pagina, int qtd, String... camposOrdem) throws DataAccessException, ParseException, DAOException;

	public <T> Integer procurarBuscaAvancadaTotal(Class<T> entityClass, List<FiltroVO> filtros) throws DataAccessException, ParseException, DAOException;
}
