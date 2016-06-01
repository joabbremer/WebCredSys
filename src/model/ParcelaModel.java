package model;

import java.math.BigDecimal;


public class ParcelaModel {
	
	private static ParcelaModel instance = null;
	private int idParcela;
	private BigDecimal dataPagamento;
	private BigDecimal dataVencimento;
	private Double valor;
	private BigDecimal valorDesconto;
	private BigDecimal valorJuro;
	private BigDecimal valorTotal;
	private FinanciamentoModel financiamento;
	
	public ParcelaModel() {
	
	}

	public ParcelaModel(BigDecimal dataPagamento, BigDecimal dataVencimento, Double valor, BigDecimal valorDesconto,
			BigDecimal valorJuro, BigDecimal valorTotal, FinanciamentoModel financiamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.valorDesconto = valorDesconto;
		this.valorJuro = valorJuro;
		this.valorTotal = valorTotal;
		this.financiamento = financiamento;
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

	public BigDecimal getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(BigDecimal dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(BigDecimal dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double d) {
		this.valor = d;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorJuro() {
		return valorJuro;
	}

	public void setValorJuro(BigDecimal valorJuro) {
		this.valorJuro = valorJuro;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public FinanciamentoModel getFinanciamento() {
		return financiamento;
	}

	public void setFinanciamento(FinanciamentoModel financiamento) {
		this.financiamento = financiamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((financiamento == null) ? 0 : financiamento.hashCode());
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
		if (financiamento == null) {
			if (other.financiamento != null)
				return false;
		} else if (!financiamento.equals(other.financiamento))
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
				+ ", valorTotal=" + valorTotal + ", financiamento=" + financiamento + "]";
	}
	
	

}
