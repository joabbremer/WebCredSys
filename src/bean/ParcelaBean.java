package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import controller.ParcelaController;
import entities.Parcela;
import model.ParcelaModel;

@ManagedBean
@SessionScoped
public class ParcelaBean {
	
	public ParcelaModel PrepareToSimule(){
		ParcelaController parcelaController = new ParcelaController();
		return parcelaController.PrepareToSimule();
	}
	
	public String PrepareToPay(ParcelaModel parcelaModel){		
		
		return "Pagina_pagamento";		
	}
	
	public DataModel<ParcelaModel> ListParcela(){
		ParcelaController parcelaController = ParcelaController.getControllerInstance();
		List<ParcelaModel> parcela =	 parcelaController.SelectParcela();		
		DataModel<ParcelaModel> parcDataModel = new  ListDataModel<ParcelaModel>(parcela);		
		return parcDataModel;
		 
	}

}
