package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="PARCELA")
public class Parcela implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_parcela", unique=true, nullable=false)
	private int idParcela;

	@Column(name="data_pagamento", precision=19)
	private BigDecimal dataPagamento;

	@Column(name="data_vencimento", precision=19)
	private BigDecimal dataVencimento;

	@Column(name="VALOR", precision=19)
	private BigDecimal valor;

	@Column(name="valor_desconto", precision=19)
	private BigDecimal valorDesconto;

	@Column(name="valor_juro", precision=19)
	private BigDecimal valorJuro;

	@Column(name="valor_total", precision=19)
	private BigDecimal valorTotal;


	public Parcela() {
	}

	public int getIdParcela() {
		return this.idParcela;
	}

	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}

	public BigDecimal getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(BigDecimal dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(BigDecimal dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorJuro() {
		return this.valorJuro;
	}

	public void setValorJuro(BigDecimal valorJuro) {
		this.valorJuro = valorJuro;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


}