package ttps.spring.DAOS;

import java.util.List;
import java.io.Serializable;

public interface GenericDAO<T> {

	public T actualizar(T entity);

	public void borrar(T entity);

	public void borrarPorId(Serializable id);

	public boolean existe(Serializable id);

	public T persistir(T entity);

	public T recuperar(Serializable id);

	public void borrarTodos();

	public List<T> listar();

	public List<T> recuperarTodos(String columnOrder);

	public List<T> recuperarTodosOrdenados(String columnOrder);

	public T encontrarPorId(long id);


}
