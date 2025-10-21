package DAO;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO <T, ID extends Serializable> {
	
	public void SaveOrUpdate(T entity);

	public void delete(Integer id);

	public void delete(T entity);

	public List<T> findAll();

	public T get(ID id);

}
