package bean;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.sun.faces.taglib.html_basic.DataTableTag;

import controller.ClienteController;
import controller.FinanciamentoController;
import controller.SimulacaoController;
import dao.Exception.ConnectException;
import model.ClienteModel;
import model.ParcelaModel;


@ManagedBean
@SessionScoped
public class FinanciamentoBean {
	
	private DataModel<ParcelaModel> parcDataModel = new  ListDataModel<ParcelaModel>();
	
	public void CalcularFianciamento() throws ParseException{
		SimulacaoController simulacaoController = SimulacaoController.getControllerInstance();
		simulacaoController.Simular();
	}
	
	public DataModel<ParcelaModel> ListParcela(){
		FinanciamentoController finanController = FinanciamentoController.getControllerInstance();
		parcDataModel = new  ListDataModel<ParcelaModel>(finanController.ListParcelas());		
		
		return parcDataModel;
		 
	}

	public DataModel<ParcelaModel> getParcDataModel() {
		return parcDataModel;
	}

	public void setParcDataModel(DataModel<ParcelaModel> parcDataModel) {
		this.parcDataModel = parcDataModel;
	}
	
	public void Financiar() throws ConnectException{
			ClienteController clienteController = ClienteController.getControllerInstance();
			clienteController.ClienteUpdate();
			clienteController.LimparCliente();
			ListParcela();
						
	}
	
	public ClienteModel ClienteSelected(){
		ClienteController clientControl = ClienteController.getControllerInstance();
		return clientControl.Selected();
	}
	

}
