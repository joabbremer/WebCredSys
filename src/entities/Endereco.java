package entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity(name="Endereco")
@Table(name="ENDERECO")
@NamedQueries({
	@NamedQuery(name="listAllEndereco", query="SELECT e FROM Endereco e"),
	@NamedQuery(name="selectIdEndereco", query="SELECT e FROM Endereco e WHERE e.idEndereco = :id_endereco"),
	@NamedQuery(name="updateEndereco", query="UPDATE Endereco e SET e.numero= :numero, e.bairro = :bairro, e.cep = :cep, e.cidade = :cidade, e.endereco = :endereco, e.estado = :estado WHERE e.idEndereco = :id_endereco "),
	
	
})
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static EntityManager em = null;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_endereco", unique=true, nullable=false)
	private int idEndereco;

	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="BAIRRO", length=15)
	private String bairro;

	@Column(name="CEP")
	private String cep;

	@Column(name="CIDADE", length=15)
	private String cidade;

	@Column(name="ENDERECO", length=50)
	private String endereco;

	@Column(name="ESTADO", length=2)
	private String estado;

	
	public Endereco() {
	}

	public Endereco(int numero, String bairro, String cep, String cidade, String endereco, String estado) {
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.endereco = endereco;
		this.estado = estado;
	}
	
	public static EntityManager getEntityManager(){
		
		if(em == null){
			em = Persistence.createEntityManagerFactory("CredSys").createEntityManager();
		}
		return em;
	}
	
	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}