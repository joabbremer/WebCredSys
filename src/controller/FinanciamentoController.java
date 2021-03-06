package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.FinanciamentoDao;
import dao.Exception.ConnectException;
import entities.Endereco;
import entities.Financiamento;
import model.ClienteModel;
import model.FinanciamentoModel;
import model.ParcelaModel;
import model.SimulacaoModel;


public class FinanciamentoController {
	
	List<ParcelaModel> parcela = null;
	private static FinanciamentoController financiamentoController = null;
	Date dataD = null;
	
	public static FinanciamentoController getControllerInstance(){
		if(financiamentoController == null){
			financiamentoController = new FinanciamentoController();
		}
		return financiamentoController;
	}
	
	public List<ParcelaModel> getParcelas() {
		return parcela;
	}

	public void setParcelas(List<ParcelaModel> parcela) {
		this.parcela = parcela;
	}
	
	public void LimparFinanciamento(){
		FinanciamentoModel finanModel = FinanciamentoModel.getInstance();
		finanModel.setIdFinanciamento(0);
		ParcelaController parcelaController = ParcelaController.getControllerInstance();
		parcelaController.LimparParcela();
		
		SimulacaoController simulacaoController = SimulacaoController.getControllerInstance();
		simulacaoController.LimparSimulacao();
	
		
			
		
	}
	
	public void FinanaciamentoSave() throws ConnectException{
		FinanciamentoDao finanDao = new FinanciamentoDao();
		ClienteModel clienteModel = ClienteModel.getInstance();
		clienteModel.getIdCliente();
		FinanciamentoModel  financiamentoModel = new FinanciamentoModel();
		financiamentoModel.setParcelas(getParcelas());		
		finanDao.save(ConvertModelToEntite(financiamentoModel));
		
	}

	private Financiamento ConvertModelToEntite(FinanciamentoModel financiamentoModel) {
		ParcelaController parcelaController = new ParcelaController();
		
		Financiamento financiamento = new Financiamento();
		if(financiamentoModel != null){
			financiamento = new Financiamento(financiamentoModel.getIdFinanciamento(),
					parcelaController.convertModelToEntitie(financiamentoModel.getParcelas()));
			
		}
		
		
		return financiamento;
		
	}



	public List<FinanciamentoModel> ConvertEntitieToModelList(List<Financiamento> financiamento){
		ParcelaController parcelaController = new ParcelaController();
		List<FinanciamentoModel> finanModels = new ArrayList<FinanciamentoModel>();
		for (Financiamento finan : financiamento) {
			finanModels.add(new FinanciamentoModel(finan.getIdFinanciamento(),
					parcelaController.ConvertEntitieToModelList(finan.getParcelas())));			
		}
		return finanModels;
		
	}
	
	public List<ParcelaModel> ListParcelas(){
		SimulacaoController simulacaoController = SimulacaoController.getControllerInstance();
		SimulacaoModel simulacaoModel = simulacaoController.Simule();
		ParcelaModel parcelaModel = ParcelaModel.getInstance();	
		parcela = new ArrayList<ParcelaModel>();
		for (int i = 1; i <= simulacaoModel.getQtParcelas(); i++) {
			parcela.add(new ParcelaModel(parcelaModel.getIdParcela(),
					i, 
					parcelaModel.getDataPagamento(),
					SomarDate(parcelaModel.getDataVencimento(), i),
					parcelaModel.getValor(),
					parcelaModel.getValorDesconto(),
					parcelaModel.getValorJuro(),
					parcelaModel.getValorTotal(),
					parcelaModel.getValorPago()));
			
		}
		
		
		return parcela;
		
	}
	
	public Date SomarDate(Date data, int index){
		
		if(index == 1 ){
			dataD = data;
		}
		
		if(index > 1){
			Calendar c = Calendar.getInstance();
			c.setTime(dataD);
			c.add(Calendar.DATE, +30);
			dataD = c.getTime();	
			
		}
			
		return dataD;
		
	}

	public List<Financiamento> ConvertModelToEntitieList(List<FinanciamentoModel> financiamentos) {
		ParcelaController parcelaController = new ParcelaController();
		List<Financiamento> finanEntite = new ArrayList<Financiamento>();
		if(financiamentos != null){
					
			for (FinanciamentoModel finanModel : financiamentos) {
				finanEntite.add(new Financiamento(finanModel.getIdFinanciamento(),
						parcelaController.convertModelToEntitie(finanModel.getParcelas())));
							
			}
			
		}
		
		
		return finanEntite;
	}

}
