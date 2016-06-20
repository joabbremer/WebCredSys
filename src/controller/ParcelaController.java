package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ParcelaDao;
import dao.Exception.ConnectException;
import entities.Cliente;
import entities.Financiamento;
import entities.Parcela;
import model.ClienteModel;
import model.FinanciamentoModel;
import model.ParcelaModel;
import model.SimulacaoModel;

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
			parcelaModel.add(new ParcelaModel(parcela.getIdParcela(),
					parcela.getDataPagamento(),
					parcela.getDataVencimento(),
					parcela.getValor(),
					parcela.getValorDesconto(),
					parcela.getValorJuro(),
					parcela.getValorTotal(),
					parcela.getValorPago()));
			
		}		
		return parcelaModel;
		
	}



	public List<Parcela> convertModelToEntitie(List<ParcelaModel> parcelas) {
		List<Parcela> parcelaEntitie = new ArrayList<Parcela>();
		for (ParcelaModel parcelaModel : parcelas) {
			parcelaEntitie.add(new Parcela(parcelaModel.getIdParcela(),
					parcelaModel.getDataPagamento(),
					parcelaModel.getDataVencimento(),
					parcelaModel.getValor(),
					parcelaModel.getValorDesconto(),
					parcelaModel.getValorJuro(),
					parcelaModel.getValorTotal(),
					parcelaModel.getValorPago()));
			
		}
		
		return parcelaEntitie;
	}



	public void LimparParcela() {
		
		ParcelaModel parcelaModel = ParcelaModel.getInstance();
		parcelaModel.setDataPagamento(null);
		parcelaModel.setDataVencimento(null);
		parcelaModel.setValor(null);
		parcelaModel.setValorDesconto(null);
		parcelaModel.setValorJuro(null);
		parcelaModel.setValorTotal(null);
		SimulacaoModel simulacaoModel = SimulacaoModel.getInstance();
		simulacaoModel.setQtParcelas(0);
		
		
		
	}



	public void update(ParcelaModel parcelaModel) throws ConnectException {
		ParcelaDao parcelaDao = new ParcelaDao();
		parcelaDao.update(convertModelToEntitie(parcelaModel));
		
	}



	private Parcela convertModelToEntitie(ParcelaModel parcelaModel) {
				
		return new Parcela(parcelaModel.getIdParcela(),
				parcelaModel.getDataPagamento(),
				parcelaModel.getDataVencimento(),
				parcelaModel.getValor(),
				parcelaModel.getValorDesconto(),
				parcelaModel.getValorJuro(),
				parcelaModel.getValorTotal(),
				parcelaModel.getValorPago());
		
	}

}
