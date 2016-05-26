package dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	public Contato update(Contato contato) throws ConnectException {
		// TODO Auto-generated method stub
		return null;
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
