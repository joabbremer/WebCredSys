package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import controller.ParcelaController;
import dao.Exception.ConnectException;
import model.ParcelaModel;

@ManagedBean
@SessionScoped
public class ParcelaBean {
	
	private Double valor = 1.0;
	
	
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	private DataModel<ParcelaModel> parcDataModel = new  ListDataModel<ParcelaModel>();
	
	public ParcelaModel PrepareToSimule(){
		ParcelaController parcelaController = new ParcelaController();
		return parcelaController.PrepareToSimule();
	}
	
	public void PrepareToPay(ParcelaModel parcelaModel) throws ConnectException{		
		ParcelaController parcelaController = ParcelaController.getControllerInstance();
		parcelaModel.setValorPago(getValor());
		parcelaController.update(parcelaModel);
		ListParcela();
				
	}
	
	public DataModel<ParcelaModel> ListParcela(){
		ParcelaController parcelaController = ParcelaController.getControllerInstance();
		List<ParcelaModel> parcela =	 parcelaController.SelectParcela();	
		for (ParcelaModel parcelaModel : parcela) {
			System.out.println(parcelaModel.getIdParcela());
		}
		parcDataModel = new  ListDataModel<ParcelaModel>(parcela);		
		return parcDataModel;
		 
	}

	public DataModel<ParcelaModel> getParcDataModel() {
		return parcDataModel;
	}

	public void setParcDataModel(DataModel<ParcelaModel> parcDataModel) {
		this.parcDataModel = parcDataModel;
	}
	
	

}
