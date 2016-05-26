package model;

import java.util.List;



public class FinanciamentoModel {
	
	private int idFinanciamento;
	private ClienteModel cliente;
	private List<ParcelaModel> parcelas;
	
	
	public FinanciamentoModel() {
		
	}

	public FinanciamentoModel(ClienteModel cliente, List<ParcelaModel> parcelas) {
		super();
		this.cliente = cliente;
		this.parcelas = parcelas;
	}

	public int getIdFinanciamento() {
		return idFinanciamento;
	}

	public void setIdFinanciamento(int idFinanciamento) {
		this.idFinanciamento = idFinanciamento;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public List<ParcelaModel> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaModel> parcelas) {
		this.parcelas = parcelas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + idFinanciamento;
		result = prime * result + ((parcelas == null) ? 0 : parcelas.hashCode());
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
		FinanciamentoModel other = (FinanciamentoModel) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (idFinanciamento != other.idFinanciamento)
			return false;
		if (parcelas == null) {
			if (other.parcelas != null)
				return false;
		} else if (!parcelas.equals(other.parcelas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FinanciamentoModel [idFinanciamento=" + idFinanciamento + ", cliente=" + cliente + ", parcelas="
				+ parcelas + "]";
	}
	
	

}
