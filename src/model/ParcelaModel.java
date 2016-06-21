package model;

import java.util.Date;

public class ParcelaModel {
	
	private static ParcelaModel instance = null;
	private int idParcela;
	private int numeroParcela;
	private Double dataPagamento;
	private Date dataVencimento;
	private Double valor;
	private Double valorDesconto;
	private Double valorJuro;
	private Double valorTotal;
	private Double valorPago;
	
	public ParcelaModel() {
	
	}


	public ParcelaModel(int idParcela, int numeroParcela, Double dataPagamento, Date dataVencimento, Double valor,
			Double valorDesconto, Double valorJuro, Double valorTotal, Double valorPago) {
		super();
		this.idParcela = idParcela;
		this.numeroParcela = numeroParcela;
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.valorDesconto = valorDesconto;
		this.valorJuro = valorJuro;
		this.valorTotal = valorTotal;
		this.valorPago = valorPago;
	}






	public static ParcelaModel getInstance(){
		if(instance == null){
			instance = new ParcelaModel();
		}
		return instance;
	}
	
	public int getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}

	public Double getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Double dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double d) {
		this.valor = d;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorJuro() {
		return valorJuro;
	}

	public void setValorJuro(Double valorJuro) {
		this.valorJuro = valorJuro;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	
	public int getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + idParcela;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((valorDesconto == null) ? 0 : valorDesconto.hashCode());
		result = prime * result + ((valorJuro == null) ? 0 : valorJuro.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		ParcelaModel other = (ParcelaModel) obj;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (idParcela != other.idParcela)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (valorDesconto == null) {
			if (other.valorDesconto != null)
				return false;
		} else if (!valorDesconto.equals(other.valorDesconto))
			return false;
		if (valorJuro == null) {
			if (other.valorJuro != null)
				return false;
		} else if (!valorJuro.equals(other.valorJuro))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParcelaModel [idParcela=" + idParcela + ", dataPagamento=" + dataPagamento + ", dataVencimento="
				+ dataVencimento + ", valor=" + valor + ", valorDesconto=" + valorDesconto + ", valorJuro=" + valorJuro
				+ ", valorTotal=" + valorTotal + " ]";
	}
	
	

}
