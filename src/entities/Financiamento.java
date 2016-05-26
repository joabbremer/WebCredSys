package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="FINANCIAMENTO")
public class Financiamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_financiamento", unique=true, nullable=false)
	private int idFinanciamento;

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Parcela> parcelas;

	public Financiamento() {
	}

	public int getIdFinanciamento() {
		return this.idFinanciamento;
	}

	public void setIdFinanciamento(int idFinanciamento) {
		this.idFinanciamento = idFinanciamento;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Parcela> getParcelas() {
		return this.parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public Parcela addParcela(Parcela parcela) {
		getParcelas().add(parcela);
		parcela.setFinanciamento(this);

		return parcela;
	}

	public Parcela removeParcela(Parcela parcela) {
		getParcelas().remove(parcela);
		parcela.setFinanciamento(null);

		return parcela;
	}

}