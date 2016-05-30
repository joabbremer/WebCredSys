package model;

import java.util.Date;

public class SimulacaoModel {
	
	private static SimulacaoModel instance = null;
	private double valor;
	private int qtParcelas;
	private Date primeiraParcela;
	
	public SimulacaoModel() {
		super();
	}

	public SimulacaoModel(double valor, int qtParcelas, Date primeiraParcela) {
		super();
		this.valor = valor;
		this.qtParcelas = qtParcelas;
		this.primeiraParcela = primeiraParcela;
	}
	
	public static SimulacaoModel getInstance(){
		if(instance == null){
			instance = new SimulacaoModel();
		}
		return instance;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQtParcelas() {
		return qtParcelas;
	}
	public void setQtParcelas(int qtParcelas) {
		this.qtParcelas = qtParcelas;
	}
	public Date getPrimeiraParcela() {
		return primeiraParcela;
	}
	public void setPrimeiraParcela(Date primeiraParcela) {
		this.primeiraParcela = primeiraParcela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((primeiraParcela == null) ? 0 : primeiraParcela.hashCode());
		result = prime * result + qtParcelas;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SimulacaoModel other = (SimulacaoModel) obj;
		if (primeiraParcela == null) {
			if (other.primeiraParcela != null)
				return false;
		} else if (!primeiraParcela.equals(other.primeiraParcela))
			return false;
		if (qtParcelas != other.qtParcelas)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimulacaoModel [valor=" + valor + ", qtParcelas=" + qtParcelas + ", primeiraParcela=" + primeiraParcela
				+ "]";
	}
	
	

}
