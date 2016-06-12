package controller;


import model.ParcelaModel;
import model.SimulacaoModel;

public class SimulacaoController {
	
	private static SimulacaoController simulacaoController = null;
	
	public static SimulacaoController getControllerInstance(){
		if(simulacaoController == null){
			simulacaoController = new SimulacaoController();
		}
		return simulacaoController;
	}
	
	
	public SimulacaoModel PrepareToSimule(){
		return SimulacaoModel.getInstance();
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
				
			
	}
	public Double CalcularJuros(Double valor){
		return valor-(valor*0.918);
		
	}
	


}
