package model;

import java.util.List;
import entities.Contato;
import entities.Endereco;
import entities.Financiamento;

public class ClienteModel {

	private static ClienteModel instance = null;
	private int idCliente;
	private int cpf;
	private String email;
	private String identidade;
	private String nome;
	private Double rendaConjuge;
	private Double rendaLiquida ;
	private Double valorAutomoveis;
	private Double valorImoveis;
	private List<Contato> contatos;
	private List<Endereco> enderecos;
	private List<Financiamento> financiamentos;

	
	public static ClienteModel getInstance(){
		if(instance == null){
			instance = new ClienteModel();
		}
		return instance;
	}
	
	public ClienteModel() {
	}

	
	
	public ClienteModel(int cpf, String email, String identidade, String nome, Double rendaConjuge,
			Double rendaLiquida, Double valorAutomoveis, Double valorImoveis, List<Contato> contatos,
			List<Endereco> enderecos, List<Financiamento> financiamentos) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.rendaConjuge = rendaConjuge;
		this.rendaLiquida = rendaLiquida;
		this.valorAutomoveis = valorAutomoveis;
		this.valorImoveis = valorImoveis;
		this.contatos = contatos;
		this.enderecos = enderecos;
		this.financiamentos = financiamentos;
	}

	


	public ClienteModel(int idCliente, int cpf, String email, String identidade, String nome, Double rendaConjuge,
			Double rendaLiquida, Double valorAutomoveis, Double valorImoveis, List<Contato> contatos,
			List<Endereco> enderecos, List<Financiamento> financiamentos) {
		super();
		this.idCliente = idCliente;
		this.cpf = cpf;
		this.email = email;
		this.identidade = identidade;
		this.nome = nome;
		this.rendaConjuge = rendaConjuge;
		this.rendaLiquida = rendaLiquida;
		this.valorAutomoveis = valorAutomoveis;
		this.valorImoveis = valorImoveis;
		this.contatos = contatos;
		this.enderecos = enderecos;
		this.financiamentos = financiamentos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
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

	public Double getRendaConjuge() {
		return rendaConjuge;
	}

	public void setRendaConjuge(Double rendaConjuge) {
		this.rendaConjuge = rendaConjuge;
	}

	public Double getRendaLiquida() {
		return rendaLiquida;
	}

	public void setRendaLiquida(Double rendaLiquida) {
		this.rendaLiquida = rendaLiquida;
	}

	public Double getValorAutomoveis() {
		return valorAutomoveis;
	}

	public void setValorAutomoveis(Double valorAutomoveis) {
		this.valorAutomoveis = valorAutomoveis;
	}

	public Double getValorImoveis() {
		return valorImoveis;
	}

	public void setValorImoveis(Double valorImoveis) {
		this.valorImoveis = valorImoveis;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contatos == null) ? 0 : contatos.hashCode());
		result = prime * result + cpf;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((financiamentos == null) ? 0 : financiamentos.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((identidade == null) ? 0 : identidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rendaConjuge == null) ? 0 : rendaConjuge.hashCode());
		result = prime * result + ((rendaLiquida == null) ? 0 : rendaLiquida.hashCode());
		result = prime * result + ((valorAutomoveis == null) ? 0 : valorAutomoveis.hashCode());
		result = prime * result + ((valorImoveis == null) ? 0 : valorImoveis.hashCode());
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
		if (cpf != other.cpf)
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
		if (rendaConjuge == null) {
			if (other.rendaConjuge != null)
				return false;
		} else if (!rendaConjuge.equals(other.rendaConjuge))
			return false;
		if (rendaLiquida == null) {
			if (other.rendaLiquida != null)
				return false;
		} else if (!rendaLiquida.equals(other.rendaLiquida))
			return false;
		if (valorAutomoveis == null) {
			if (other.valorAutomoveis != null)
				return false;
		} else if (!valorAutomoveis.equals(other.valorAutomoveis))
			return false;
		if (valorImoveis == null) {
			if (other.valorImoveis != null)
				return false;
		} else if (!valorImoveis.equals(other.valorImoveis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteModel [idCliente=" + idCliente + ", cpf=" + cpf + ", email=" + email + ", identidade="
				+ identidade + ", nome=" + nome + ", rendaConjuge=" + rendaConjuge + ", rendaLiquida=" + rendaLiquida
				+ ", valorAutomoveis=" + valorAutomoveis + ", valorImoveis=" + valorImoveis + ", contatos=" + contatos
				+ ", enderecos=" + enderecos + ", financiamentos=" + financiamentos + "]";
	}

	
	

}
