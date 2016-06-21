package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.Exception.ConnectException;
import entities.Contato;
import entities.Parcela;
import model.ParcelaModel;

public class ParcelaDao implements CrudInterfaceDao<Parcela> {

	@Override
	public List<Parcela> listAll() throws ConnectException {
		EntityManager em = Parcela.getEntityManager();
		return em.createNamedQuery("listAllParcela").getResultList();
	}

	@Override
	public List<Parcela> select(int id) throws ConnectException {
		EntityManager em = Parcela.getEntityManager();	
		Query query = em.createNamedQuery("selectIdParcela");		
		query.setParameter("id_parcela",id);
		return query.getResultList();
	}

	@Override
	public void update(Parcela parcela) throws ConnectException {
		EntityManager em = Parcela.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updateParcela");
		query.setParameter("numero_parcela", parcela.getNumeroParcela());
		query.setParameter("data_pagamento", parcela.getDataPagamento());
		query.setParameter("data_vencimento", parcela.getDataVencimento());
		query.setParameter("valor", parcela.getValor());
		query.setParameter("valor_desconto", parcela.getValorDesconto());
		query.setParameter("valor_juro", parcela.getValorJuro());
		query.setParameter("valor_total", parcela.getValorTotal());
		query.setParameter("valor_pago", parcela.getValorPago());
		query.setParameter("id_parcela", parcela.getIdParcela());		
		query.executeUpdate();
		em.getTransaction().commit();
		
	}

	@Override
	public Parcela save(Parcela parcela) throws ConnectException {
		EntityManager em = Contato.getEntityManager();
		em.getTransaction().begin();
		em.persist(parcela);
		em.getTransaction().commit();
		return parcela;
	}

	@Override
	public void delete(Parcela parcela) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

	

}
