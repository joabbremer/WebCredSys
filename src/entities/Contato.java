package entities;

import java.io.Serializable;
import javax.persistence.*;



@Entity(name="Contato")
@Table(name="CONTATO")
@NamedQueries({
	@NamedQuery(name="listAllContato", query="SELECT co FROM Contato co"),
	@NamedQuery(name="selectIdContato", query="SELECT co FROM Contato co WHERE co.idContato = :id_contato"),
	@NamedQuery(name="updateContato", query="UPDATE Contato co SET co.contato = :contato ,co.tipo = :tipo WHERE co.idContato = :id_contato"),
	
	
})
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static EntityManager em = null;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contato", unique=true, nullable=false)
	private int idContato;

	@Column(name="CONTATO", length=15)
	private String contato;

	@Column(name="TIPO", length=10)
	private String tipo;

	
	public Contato(int idContato, String contato, String tipo) {
		super();
		this.idContato = idContato;
		this.contato = contato;
		this.tipo = tipo;
	}
	
	
	public Contato(String contato, String tipo) {
		super();
		this.contato = contato;
		this.tipo = tipo;

	}



	public static EntityManager getEntityManager(){
		
		if(em == null){
			em = Persistence.createEntityManagerFactory("CredSys").createEntityManager();
		}
		return em;
	}
	

	public Contato() {
	}

	public int getIdContato() {
		return this.idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}