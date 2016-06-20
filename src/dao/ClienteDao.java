package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.Exception.ConnectException;
import entities.Cliente;


public class ClienteDao implements CrudInterfaceDao<Cliente> {

	
	@Override
	public List<Cliente> listAll() throws ConnectException {
		EntityManager em = Cliente.getEntityManager();
		return em.createNamedQuery("listAllCliente").getResultList();		
	}

	
	@Override
	public List<Cliente> select(int id) throws ConnectException {
		EntityManager em = Cliente.getEntityManager();	
		Query query = em.createNamedQuery("selectIdCliente");		
		query.setParameter("id_cliente",id);
		return query.getResultList();
		 
	}
	
	public List<Cliente> selectByCpf(String cpf) throws ConnectException {
		EntityManager em = Cliente.getEntityManager();	
		Query query = em.createNamedQuery("selectByCpf");		
		query.setParameter("cpf",cpf);
		return query.getResultList();
		 
	}

	@Override
	public void update(Cliente cliente) throws ConnectException {
		EntityManager em = Cliente.getEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		
		
	}

	@Override
	public Cliente save(Cliente cliente) throws ConnectException {
		EntityManager em = Cliente.getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Cliente cliente) throws ConnectException {
		
		
	}



}
