package model;

import java.util.List;
import entities.Contato;
import entities.Endereco;
import entities.Financiamento;

public class ClienteModel {

	private static ClienteModel instance = null;
	private int idCliente;
	private String cpf;
	private String email;
	private String identidade;
	private String nome;
	private char genero;
	private Double rendimentos;
	private Double garantias;
	private List<ContatoModel> contatos;
	private List<EnderecoModel> enderecos;
	private List<FinanciamentoModel> financiamentos;

	public ClienteModel() {
		super();
	}
	
	
	public ClienteModel(int idCliente, String cpf, String email, String identidade, String nome, char genero,
			Double rendimentos, Double garantias, List<ContatoModel> contatos, List<EnderecoModel> enderecos,
			List<FinanciamentoModel> financiamentos) {
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

	public ClienteModel(int idCliente, String cpf, String email, String identidade, String nome, char genero,
			Double rendimentos, Double garantias, List<ContatoModel> contatos) {
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
	}




	public static ClienteModel getInstance(){
		if(instance == null){
			instance = new ClienteModel();
		}
		return instance;
	}	

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getNome() {
		return nome;
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

	public List<ContatoModel> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoModel> contatos) {
		this.contatos = contatos;
	}

	public List<EnderecoModel> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoModel> enderecos) {
		this.enderecos = enderecos;
	}

	public List<FinanciamentoModel> getFinanciamentos() {
		return financiamentos;
	}

	public void setFinanciamentos(List<FinanciamentoModel> financiamentos) {
		this.financiamentos = financiamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contatos == null) ? 0 : contatos.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((financiamentos == null) ? 0 : financiamentos.hashCode());
		result = prime * result + ((garantias == null) ? 0 : garantias.hashCode());
		result = prime * result + genero;
		result = prime * result + idCliente;
		result = prime * result + ((identidade == null) ? 0 : identidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rendimentos == null) ? 0 : rendimentos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		if (contatos == null) {
			if (other.contatos != null)
				return false;
		} else if (!contatos.equals(other.contatos))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (financiamentos == null) {
			if (other.financiamentos != null)
				return false;
		} else if (!financiamentos.equals(other.financiamentos))
			return false;
		if (garantias == null) {
			if (other.garantias != null)
				return false;
		} else if (!garantias.equals(other.garantias))
			return false;
		if (genero != other.genero)
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (identidade == null) {
			if (other.identidade != null)
				return false;
		} else if (!identidade.equals(other.identidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rendimentos == null) {
			if (other.rendimentos != null)
				return false;
		} else if (!rendimentos.equals(other.rendimentos))
			return false;
		return true;
	}



	

	
	

}
