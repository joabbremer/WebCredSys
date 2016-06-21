package model;

import java.util.Date;

public class SimulacaoModel {
	
	private static SimulacaoModel instance = null;
	private double valor;
	private double imposto;
	private double valorFinanciado;
	private double valorParcela;
	private double valorTotal;
	private double juros;
	private double valorCjuros;
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
	
	
	
	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getValorCjuros() {
		return valorCjuros;
	}

	public void setValorCjuros(double valorCjuros) {
		this.valorCjuros = valorCjuros;
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

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public double getValorFinanciado() {
		return valorFinanciado;
	}

	public void setValorFinanciado(double valorFinanciado) {
		this.valorFinanciado = valorFinanciado;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "SimulacaoModel [valor=" + valor + ", imposto=" + imposto + ", valorFinanciado=" + valorFinanciado
				+ ", valorParcela=" + valorParcela + ", juros=" + juros + ", valorCjuros=" + valorCjuros
				+ ", qtParcelas=" + qtParcelas + ", primeiraParcela=" + primeiraParcela + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imposto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(juros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((primeiraParcela == null) ? 0 : primeiraParcela.hashCode());
		result = prime * result + qtParcelas;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorCjuros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorFinanciado);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorParcela);
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
		if (Double.doubleToLongBits(imposto) != Double.doubleToLongBits(other.imposto))
			return false;
		if (Double.doubleToLongBits(juros) != Double.doubleToLongBits(other.juros))
			return false;
		if (primeiraParcela == null) {
			if (other.primeiraParcela != null)
				return false;
		} else if (!primeiraParcela.equals(other.primeiraParcela))
			return false;
		if (qtParcelas != other.qtParcelas)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		if (Double.doubleToLongBits(valorCjuros) != Double.doubleToLongBits(other.valorCjuros))
			return false;
		if (Double.doubleToLongBits(valorFinanciado) != Double.doubleToLongBits(other.valorFinanciado))
			return false;
		if (Double.doubleToLongBits(valorParcela) != Double.doubleToLongBits(other.valorParcela))
			return false;
		return true;
	}

	
	
	

}
