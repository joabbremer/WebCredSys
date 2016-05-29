package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity(name="Financiamento")
@Table(name="FINANCIAMENTO")
@NamedQueries({
	@NamedQuery(name="listAllFinan", query="SELECT f FROM Financiamento f"),
	@NamedQuery(name="selectIdFinan", query="SELECT f FROM Financiamento f WHERE f.idFinanciamento = :id_financiamento"),
	@NamedQuery(name="updateFinan", query="UPDATE Financiamento f  SET f.idFinanciamento = :id_financiamento WHERE f.idFinanciamento = :id_financiamento"),
	
	
})
public class Financiamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private static EntityManager em = null;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_financiamento", unique=true, nullable=false)
	private int idFinanciamento;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Parcela> parcelas;

	public Financiamento() {
	}

	public static EntityManager getEntityManager(){
		
		if(em == null){
			em = Persistence.createEntityManagerFactory("CredSys").createEntityManager();
		}
		return em;
	}
	
	public int getIdFinanciamento() {
		return this.idFinanciamento;
	}

	public void setIdFinanciamento(int idFinanciamento) {
		this.idFinanciamento = idFinanciamento;
	}


	public List<Parcela> getParcelas() {
		return this.parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}




}