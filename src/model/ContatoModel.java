package model;


public class ContatoModel {
	
	private static ContatoModel instance = null;
	private int idContato;
	private String contato;
	private String tipo;
	private ClienteModel cliente;

	public ContatoModel() {
	}
	
	

	public ContatoModel(String contato, String tipo, ClienteModel cliente) {
		super();
		this.contato = contato;
		this.tipo = tipo;
		this.cliente = cliente;
	}



	public ContatoModel(int idContato, String contato, String tipo) {
		super();
		this.idContato = idContato;
		this.contato = contato;
		this.tipo = tipo;
	}

	public static ContatoModel getInstance(){
		if(instance == null){
			instance = new ContatoModel();
		}
		return instance;
	}


	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + idContato;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		ContatoModel other = (ContatoModel) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (idContato != other.idContato)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ContatoModel [idContato=" + idContato + ", contato=" + contato + ", tipo=" + tipo + ", cliente="
				+ cliente + "]";
	}

	
	
}
