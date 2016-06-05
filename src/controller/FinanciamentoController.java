package controller;

import java.util.ArrayList;
import java.util.List;

import entities.Financiamento;
import model.FinanciamentoModel;


public class FinanciamentoController {
	
	
	
	
	public List<FinanciamentoModel> ConvertEntitieToModelList(List<Financiamento> financiamento){
		
		ParcelaController parcelaController = new ParcelaController();
		
		
		List<FinanciamentoModel> finanModels = new ArrayList<FinanciamentoModel>();
		
		for (Financiamento finan : financiamento) {
			finanModels.add(new FinanciamentoModel(finan.getIdFinanciamento(),
					parcelaController.ConvertEntitieToModelList(finan.getParcelas())));			
		}
		
		
		
		return finanModels;
		
	}

}
