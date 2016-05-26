package entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="ENDERECO")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_endereco", unique=true, nullable=false)
	private int idEndereco;

	@Column(name="BAIRRO", length=15)
	private String bairro;

	@Column(name="CEP")
	private int cep;

	@Column(name="CIDADE", length=15)
	private String cidade;

	@Column(name="ENDERECO", length=50)
	private String endereco;

	@Column(name="ESTADO", length=2)
	private String estado;

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Endereco() {
	}

	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return this.cep;
	}

	public void setCep(int cep) {
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}