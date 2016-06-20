package entities;

import java.io.Serializable;

import javax.persistence.*;

import model.ContatoModel;
import model.EnderecoModel;
import model.FinanciamentoModel;

import java.util.List;

@Entity(name="Cliente")
@Table(name="CLIENTE")
@NamedQueries({
	@NamedQuery(name="listAllCliente", query="SELECT c FROM Cliente c"),
	@NamedQuery(name="selectByCpf", query="SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
	@NamedQuery(name="selectIdCliente", query="SELECT c FROM Cliente c WHERE c.idCliente =:id_cliente"),
	@NamedQuery(name="updateCliente", query="UPDATE Cliente c SET c.cpf = :cpf, c.email = :email, c.identidade = :identidade"
			+ ", c.nome = :nome, c.rendimentos = :rendimentos, c.garantias = :garantias WHERE c.idCliente =:id_cliente"),
	
	
})

	
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static Cliente instance = null;

	private static EntityManager em = null;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente", unique=true, nullable=false)
	private int idCliente;

	@Column(name="CPF")
	private String cpf;

	@Column(name="EMAIL", length=50)
	private String email;

	@Column(name="IDENTIDADE", length=15)
	private String identidade;

	@Column(name="NOME", length=50)
	private String nome;
	
	@Column(name="GENERO")
	private char genero;

	@Column(name="RENDIMENTOS", precision=19)
	private Double rendimentos;

	@Column(name="GARANTIAS", precision=19)
	private Double garantias;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Contato> contatos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Endereco> enderecos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Financiamento> financiamentos;

	public Cliente() {
	}
	
	

	public Cliente(int idCliente, String cpf, String email, String identidade, String nome, char genero,
			Double rendimentos, Double garantias, List<Contato> contatos, List<Endereco> enderecos,
			List<Financiamento> financiamentos) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.genero = genero;
		this.rendimentos = rendimentos;
		this.garantias = garantias;
		this.contatos = contatos;
		this.enderecos = enderecos;
		this.financiamentos = financiamentos;
	}
	
	public Cliente(int idCliente, String cpf, String email, String identidade, String nome, char genero,
			Double rendimentos, Double garantias) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.genero = genero;
		this.rendimentos = rendimentos;
		this.garantias = garantias;
	}








	public static EntityManager getEntityManager(){
		
		if(em == null){
			em = Persistence.createEntityManagerFactory("CredSys").createEntityManager();
		}
		return em;
	}
	
public static Cliente getInstance(){
		
		if(instance == null){
			instance = new Cliente();
		}
		return instance;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentidade() {
		return this.identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	
	public Double getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(Double rendimentos) {
		this.rendimentos = rendimentos;
	}

	public Double getGarantias() {
		return garantias;
	}

	public void setGarantias(Double garantias) {
		this.garantias = garantias;
	}

	public List<Contato> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Financiamento> getFinanciamentos() {
		return financiamentos;
	}

	public void setFinanciamentos(List<Financiamento> financiamentos) {
		this.financiamentos = financiamentos;
	}



}