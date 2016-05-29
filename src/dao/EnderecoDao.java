package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import dao.Exception.ConnectException;
import entities.Endereco;


public class EnderecoDao implements CrudInterfaceDao<Endereco> {

	@Override
	public List<Endereco> listAll() throws ConnectException {
		EntityManager em = Endereco.getEntityManager();
		return em.createNamedQuery("listAllEndereco").getResultList();	
	}

	@Override
	public List<Endereco> select(int id) throws ConnectException {
		EntityManager em = Endereco.getEntityManager();	
		Query query = em.createNamedQuery("selectIdEndereco");		
		query.setParameter("id_endereco",id);
		return query.getResultList();
	}

	@Override
	public void update(Endereco endereco) throws ConnectException {
		EntityManager em = Endereco.getEntityManager();	
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updateEndereco");
		query.setParameter("numero", endereco.getNumero());
		query.setParameter("bairro", endereco.getBairro());
		query.setParameter("cep", endereco.getCep());
		query.setParameter("cidade", endereco.getCidade());
		query.setParameter("endereco", endereco.getEndereco());
		query.setParameter("estado", endereco.getEstado());
		query.setParameter("id_endereco", endereco.getIdEndereco());		
		query.executeUpdate();
		em.getTransaction().commit();
	
	}

	@Override
	public Endereco save(Endereco endereco) throws ConnectException {
		EntityManager em = Endereco.getEntityManager();	
		em.getTransaction().begin();
		em.persist(endereco);
		em.getTransaction().commit();
		return endereco;
	}

	@Override
	public void delete(Endereco endereco) throws ConnectException {
		// TODO Auto-generated method stub
		
	}

}
