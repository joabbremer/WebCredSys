package dao;

import java.util.List;

import dao.Exception.ConnectException;

public interface CrudInterfaceDao<T> {
	public List<T> listAll() throws ConnectException;
	public List<T> select(int id) throws ConnectException;
	public void update(T obj) throws ConnectException;
	public T save(T obj) throws ConnectException;
	public void delete(T obj) throws ConnectException;

}
