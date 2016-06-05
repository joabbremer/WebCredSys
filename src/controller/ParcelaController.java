package controller;

import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import entities.Financiamento;
import entities.Parcela;
import model.ClienteModel;
import model.FinanciamentoModel;
import model.ParcelaModel;

public class ParcelaController {
	
	private static ParcelaController parcelaController = null;
	private List<ParcelaModel> selectParcelaForCliente = null;
	
	public ParcelaModel PrepareToSimule(){
		return ParcelaModel.getInstance();
	}
	
	
	
	public static ParcelaController getControllerInstance(){
		if(parcelaController == null){
			parcelaController = new ParcelaController();
		}
		return parcelaController;
	}
	
	public List<ParcelaModel> SelectParcelaForCliente(List<ClienteModel> ClienteModelList){
		List<FinanciamentoModel> financiamento =  new ArrayList<FinanciamentoModel>();
		for (ClienteModel clienteModel : ClienteModelList) {
			financiamento = clienteModel.getFinanciamentos();
			
		}
		 selectParcelaForCliente = new ArrayList<ParcelaModel>();
		
				 
		for (FinanciamentoModel finan : financiamento) {
			selectParcelaForCliente = finan.getParcelas();					
			
		}				
		return selectParcelaForCliente;
			
	}


	public List<ParcelaModel> SelectParcela() {		
		if(selectParcelaForCliente == null){
			selectParcelaForCliente = new ArrayList<ParcelaModel>();
		}
		return selectParcelaForCliente;
	}
	
	public List<ParcelaModel> ConvertEntitieToModelList(List<Parcela> parcelaList){
				
		List<ParcelaModel> parcelaModel = new ArrayList<ParcelaModel>();
		for (Parcela parcela : parcelaList) {
			parcelaModel.add(new ParcelaModel(parcela.getDataPagamento(),
					parcela.getDataVencimento(),
					parcela.getValor(),
					parcela.getValorDesconto(),
					parcela.getValorJuro(),
					parcela.getValorTotal()));
			
		}		
		return parcelaModel;
		
	}

}
