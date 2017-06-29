package br.com.jgle.acti.service;

import java.util.List;
import java.util.Map;

import br.com.jgle.acti.component.FiltroVO;
import br.com.jgle.acti.entity.AbstractEntity;

/***
 * @author Danilo I. Chaves
 * 
 */
public interface GenericService {

	public <T> void inserir(T entity);

	public <T> void remover(T entity);

	public <T extends AbstractEntity> T atualizar(T entity);

	public <T> T procurarPorId(Class<T> entityClass, Object id);

	public <T> List<T> procurarTodos(Class<T> entityClass);
	
	public <T> List<T> procurarTodos(Class<T> entityClass, int qtd);
	
	public <T> List<T> getAll();
	
	public <T> T executeQuerySingle(String queryString, String name, Object value);
	
	public <T> T executeQuerySingle(String queryString, Map<String, Object> map);
	
	public <T> List<T> executeQuery(String queryString, String name, Object value);
		
	public <T> List<T> executeQuery(String queryString, Map<String, Object> map);
	
	public <T extends AbstractEntity> List<T> procurarSimples(T entity, Map<String, ?> mapSearch);

	public <T extends AbstractEntity> List<T> procurarSimples(T entity, String textSearch);
	
	public <T extends AbstractEntity> List<T> procurarPorNomeEParametros(T entityClass, String textSearch);
	
	public <T extends AbstractEntity> List<T> procurarBuscaAvancada(Class<T> entityClass, List<FiltroVO> filtros, int pagina, int qtd, String... camposOrdem);
	
	public <T> Integer procurarBuscaAvancadaTotal(Class<T> entityClass, List<FiltroVO> filtros);
}
