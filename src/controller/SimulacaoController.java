package controller;


import model.ParcelaModel;
import model.SimulacaoModel;

public class SimulacaoController {
	
	private static SimulacaoController simulacaoController = null;
	private SimulacaoModel simulacao = new SimulacaoModel();
	
	public static SimulacaoController getControllerInstance(){
		if(simulacaoController == null){
			simulacaoController = new SimulacaoController();
		}
		return simulacaoController;
	}
	
	public SimulacaoModel PrepareToSimule(){
		return SimulacaoModel.getInstance();
	}
	
	public SimulacaoModel Simule(){
		
		return simulacao;
	}
	
	public SimulacaoModel ResultSimule(){
		return SimulacaoModel.getInstance();
		
	}
	
	public void Simular(){
		SimulacaoModel simulacaoModel = SimulacaoModel.getInstance();	
		ParcelaModel parcela = ParcelaModel.getInstance();
		Double juros = CalcularJuros(simulacaoModel.getValor());		
		Double valorCJuros = juros + simulacaoModel.getValor();		
		simulacaoModel.setValorCjuros(valorCJuros);		
		simulacaoModel.setJuros(juros);
		parcela.setValor(valorCJuros/simulacaoModel.getQtParcelas());
		limparCampos(simulacaoModel);
		
	}
	public Double CalcularJuros(Double valor){
		return valor-(valor*0.918);
		
	}
	public void limparCampos(SimulacaoModel simulacaoModel){
		simulacao.setValor(simulacaoModel.getValor());
		simulacao.setQtParcelas(simulacaoModel.getQtParcelas());
		simulacao.setPrimeiraParcela(simulacaoModel.getPrimeiraParcela());
		simulacao.setJuros(simulacaoModel.getJuros());
		simulacao.setValorCjuros(simulacaoModel.getValorCjuros());
		simulacaoModel.setValor(0);
		simulacaoModel.setQtParcelas(0);
		simulacaoModel.setPrimeiraParcela(null);
	}

	


}
