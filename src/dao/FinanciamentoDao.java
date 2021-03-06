package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.Exception.ConnectException;

import entities.Financiamento;
import model.FinanciamentoModel;

public class FinanciamentoDao implements CrudInterfaceDao<Financiamento> {

	@Override
	public List<Financiamento> listAll() throws ConnectException {
		EntityManager em = Financiamento.getEntityManager();
		return em.createNamedQuery("listAllFinan").getResultList();
	}

	@Override
	public List<Financiamento> select(int id) throws ConnectException {
		EntityManager em = Financiamento.getEntityManager();
		Query query = em.createNamedQuery("selectIdFinan");		
		query.setParameter("id_financiamento",id);
		return query.getResultList();
	}

	@Override
	public void update(Financiamento financiamento) throws ConnectException {
		EntityManager em = Financiamento.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updateFinan");
		query.setParameter("id_financiamento", financiamento.getIdFinanciamento());
		query.setParameter("id_financiamento", financiamento.getIdFinanciamento());
		query.executeUpdate();
		em.getTransaction().commit();
		
	}

	@Override
	public Financiamento save(Financiamento financiamento) throws ConnectException {
		EntityManager em = Financiamento.getEntityManager();
		em.getTransaction().begin();
		em.persist(financiamento);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Financiamento financiamento) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

}
