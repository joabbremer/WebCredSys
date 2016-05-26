package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
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
		Query query = em.createNamedQuery("selectId");		
		query.setParameter("id_cliente",id);
		return query.getResultList();
		 
	}

	@Override
	public Cliente update(Cliente cliente) throws ConnectException {
		EntityManager em = Cliente.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("update");
		query.setParameter("cpf", cliente.getCpf());
		query.setParameter("email", cliente.getEmail());
		query.setParameter("identidade", cliente.getIdentidade());
		query.setParameter("nome", cliente.getNome());
		query.setParameter("renda_conjuge", cliente.getRendaConjuge());
		query.setParameter("renda_liquida", cliente.getRendaLiquida());
		query.setParameter("valor_automoveis", cliente.getValorAutomoveis());
		query.setParameter("valor_imoveis", cliente.getValorImoveis());
		query.setParameter("id_cliente", cliente.getIdCliente());
		query.executeUpdate();
		em.getTransaction().commit();
		return null;
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
