package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="Parcela")
@Table(name="PARCELA")
@NamedQueries({
	@NamedQuery(name="listAllParcela", query="SELECT p FROM Parcela p"),
	@NamedQuery(name="selectIdParcela", query="SELECT p FROM Parcela p WHERE p.idParcela = :id_parcela"),
	@NamedQuery(name="updateParcela", query="UPDATE Parcela p SET p.dataPagamento = :data_pagamento, p.dataVencimento = :data_vencimento,"
			+ " p.valor = :valor, p.valorDesconto = :valor_desconto, p.valorJuro = :valor_juro, p.valorTotal = :valor_total, p.valorPago = :valor_pago  WHERE p.idParcela = :id_parcela "),
	
	
})
public class Parcela implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static EntityManager em = null;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_parcela", unique=true, nullable=false)
	private int idParcela;

	@Column(name="data_pagamento", precision=19)
	private Double dataPagamento;

	@Column(name="data_vencimento", precision=19)
	private Double dataVencimento;

	@Column(name="VALOR", precision=19)
	private Double valor;

	@Column(name="valor_desconto", precision=19)
	private Double valorDesconto;

	@Column(name="valor_juro", precision=19)
	private Double valorJuro;

	@Column(name="valor_total", precision=19)
	private Double valorTotal;
	
	@Column(name="valor_pago", precision=19)
	private Double valorPago;


	public Parcela() {
	}
	
		

	public Parcela(int idParcela, Double dataPagamento, Double dataVencimento, Double valor, Double valorDesconto,
			Double valorJuro, Double valorTotal, Double valorPago) {
		super();
		this.idParcela = idParcela;
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
		this.valorDesconto = valorDesconto;
		this.valorJuro = valorJuro;
		this.valorTotal = valorTotal;
		this.valorPago = valorPago;
	}



	public static EntityManager getEntityManager(){
		
		if(em == null){
			em = Persistence.createEntityManagerFactory("CredSys").createEntityManager();
		}
		return em;
	}
	public int getIdParcela() {
		return this.idParcela;
	}

	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}

	public Double getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Double dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Double dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorJuro() {
		return this.valorJuro;
	}

	public void setValorJuro(Double valorJuro) {
		this.valorJuro = valorJuro;
	}

	public Double getValorTotal() {
		return this.valorTotal;
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
	
	
	


}