package model;

import java.util.List;



public class FinanciamentoModel {
	
	private static FinanciamentoModel instance;
	private int idFinanciamento;
	private List<ParcelaModel> parcelas;
	
	
	public FinanciamentoModel() {
		
	}



	public FinanciamentoModel(int idFinanciamento, List<ParcelaModel> parcelas) {
		super();
		this.idFinanciamento = idFinanciamento;
		this.parcelas = parcelas;
	}

	public static FinanciamentoModel getInstance(){
		if(instance == null){
			instance = new FinanciamentoModel();
		}
		return instance;
	}


	public int getIdFinanciamento() {
		return idFinanciamento;
	}

	public void setIdFinanciamento(int idFinanciamento) {
		this.idFinanciamento = idFinanciamento;
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
		return "FinanciamentoModel [idFinanciamento=" + idFinanciamento +  ", parcelas="
				+ parcelas + "]";
	}
	
	

}
