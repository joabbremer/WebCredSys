package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.Exception.ConnectException;
import entities.Cliente;
import entities.Contato;
import model.ContatoModel;

public class ContatoDao implements CrudInterfaceDao<Contato> {

	@Override
	public List<Contato> listAll() throws ConnectException {
		EntityManager em = Contato.getEntityManager();
		return em.createNamedQuery("listAllContato").getResultList();	
	}

	@Override
	public List<Contato> select(int id) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Contato contato) throws ConnectException {
		EntityManager em = Cliente.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updateContato");
		query.setParameter("contato", contato.getContato());
		query.setParameter("tipo", contato.getTipo());	
		query.setParameter("id_contato", contato.getIdContato());
		query.executeUpdate();
		em.getTransaction().commit();
		
	}

	@Override
	public Contato save(Contato contato) throws ConnectException {
		EntityManager em = Contato.getEntityManager();
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Contato contato) throws ConnectException {
		// TODO Auto-generated method stub
		
	}




}
