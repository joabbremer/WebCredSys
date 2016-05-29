package entities;

import java.io.Serializable;

import javax.persistence.*;

import model.FinanciamentoModel;

import java.math.BigDecimal;
import java.util.List;

@Entity(name="Cliente")
@Table(name="CLIENTE")
@NamedQueries({
	@NamedQuery(name="listAllCliente", query="SELECT c FROM Cliente c"),
	@NamedQuery(name="selectId", query="SELECT c FROM Cliente c WHERE c.idCliente =:id_cliente"),
	@NamedQuery(name="updateCliente", query="UPDATE Cliente c SET c.cpf = :cpf, c.email = :email, c.identidade = :identidade"
			+ ", c.nome = :nome, c.rendaConjuge = :renda_conjuge, c.rendaLiquida = :renda_liquida "
			+ ", c.valorAutomoveis = :valor_automoveis, c.valorImoveis = :valor_imoveis WHERE c.idCliente =:id_cliente"),
	
	
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

	@Column(name="renda_conjuge", precision=19)
	private Double rendaConjuge;

	@Column(name="renda_liquida", precision=19)
	private Double rendaLiquida;

	@Column(name="valor_automoveis", precision=19)
	private Double valorAutomoveis;

	@Column(name="valor_imoveis", precision=19)
	private Double valorImoveis;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Contato> contatos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Endereco> enderecos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Financiamento> financiamentos;

	public Cliente() {
	}
	
	
	public Cliente(String cpf, String email, String identidade, String nome, char genero, Double rendaConjuge, Double rendaLiquida,
			Double valorAutomoveis, Double valorImoveis, List<Contato> contatos) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.genero = genero;
		this.rendaConjuge = rendaConjuge;
		this.rendaLiquida = rendaLiquida;
		this.valorAutomoveis = valorAutomoveis;
		this.valorImoveis = valorImoveis;
		this.contatos = contatos;
		
	}
	
	public Cliente(String cpf, String email, String identidade, String nome, char genero, Double rendaConjuge, Double rendaLiquida,
			Double valorAutomoveis, Double valorImoveis, List<Contato> contatos, List<Endereco> enderecos,
			List<Financiamento> financiamentos) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.genero = genero;
		this.rendaConjuge = rendaConjuge;
		this.rendaLiquida = rendaLiquida;
		this.valorAutomoveis = valorAutomoveis;
		this.valorImoveis = valorImoveis;
		this.contatos = contatos;
		this.enderecos = enderecos;
		this.financiamentos = financiamentos;
	}


	

	public Cliente(int idCliente, String cpf, String email, String identidade, String nome, char genero, Double rendaConjuge,
			Double rendaLiquida, Double valorAutomoveis, Double valorImoveis, List<Contato> contatos,
			List<Endereco> enderecos, List<Financiamento> financiamentos) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.genero = genero;
		this.rendaConjuge = rendaConjuge;
		this.rendaLiquida = rendaLiquida;
		this.valorAutomoveis = valorAutomoveis;
		this.valorImoveis = valorImoveis;
		this.contatos = contatos;
		this.enderecos = enderecos;
		this.financiamentos = financiamentos;
	}



	public Cliente(int idCliente, String cpf, String email, String identidade, String nome, char genero, Double rendaConjuge,
			Double rendaLiquida, Double valorAutomoveis, Double valorImoveis) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.genero = genero;
		this.rendaConjuge = rendaConjuge;
		this.rendaLiquida = rendaLiquida;
		this.valorAutomoveis = valorAutomoveis;
		this.valorImoveis = valorImoveis;
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


	public Double getRendaConjuge() {
		return this.rendaConjuge;
	}

	public void setRendaConjuge(Double rendaConjuge) {
		this.rendaConjuge = rendaConjuge;
	}

	public Double getRendaLiquida() {
		return this.rendaLiquida;
	}

	public void setRendaLiquida(Double rendaLiquida) {
		this.rendaLiquida = rendaLiquida;
	}

	public Double getValorAutomoveis() {
		return this.valorAutomoveis;
	}

	public void setValorAutomoveis(Double valorAutomoveis) {
		this.valorAutomoveis = valorAutomoveis;
	}

	public Double getValorImoveis() {
		return this.valorImoveis;
	}

	public void setValorImoveis(Double valorImoveis) {
		this.valorImoveis = valorImoveis;
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