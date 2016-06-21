package controller;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public void Simular() throws ParseException{
		SimulacaoModel simulacaoModel = SimulacaoModel.getInstance();	
		ParcelaModel parcela = ParcelaModel.getInstance();
		Double imposto = CalcularImposto(simulacaoModel.getValor());
		
		simulacaoModel.setImposto(imposto);
		simulacaoModel.setValorFinanciado(simulacaoModel.getValor()+imposto);
		simulacaoModel.setValorParcela(CalcularMontante()/simulacaoModel.getQtParcelas());
		simulacaoModel.setValorTotal(CalcularMontante());
		simulacaoModel.setPrimeiraParcela(SimpleData(simulacaoModel.getPrimeiraParcela()));		
		
		parcela.setValor(simulacaoModel.getValorParcela());		
		parcela.setValorDesconto(0.0);
		parcela.setDataVencimento(SimpleData(simulacaoModel.getPrimeiraParcela()));
		parcela.setValorDesconto(0.0);
		
		
		limparCampos(simulacaoModel);
		
	}
	
	private java.util.Date SimpleData(Date date) throws ParseException{
//		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
//		String dataStr =  f.format(date);
//		
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        Date data = df.parse(dataStr);
        
        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        String d = df1.format(date);
        Date d2 = df1.parse(d);
        
		
		
		return d2;
		
	}
	
	private Double CalcularImposto(Double valor) {
		return valor*0.03;
	}

	public Double CalcularJuros(Double valor){
		return valor-(valor*0.918);
		
	}
	public Double CalcularMontante(){
		SimulacaoModel simulacaoModel = SimulacaoModel.getInstance();
		Double imposto = CalcularImposto(simulacaoModel.getValor());	
		
		
		return (simulacaoModel.getValor() + imposto)*(Math.pow((1+0.0918), simulacaoModel.getQtParcelas()));
		
	}
	public void limparCampos(SimulacaoModel simulacaoModel){
		simulacao.setValor(simulacaoModel.getValor());
		simulacao.setQtParcelas(simulacaoModel.getQtParcelas());
		simulacao.setImposto(simulacaoModel.getImposto());
		simulacao.setValorFinanciado(simulacaoModel.getValorFinanciado());
		simulacao.setValorParcela(simulacaoModel.getValorParcela());
		simulacao.setPrimeiraParcela(simulacaoModel.getPrimeiraParcela());
		simulacao.setJuros(simulacaoModel.getJuros());
		simulacao.setValorCjuros(simulacaoModel.getValorCjuros());
		simulacao.setValorTotal(simulacaoModel.getValorTotal());
		simulacaoModel.setValor(0);
		simulacaoModel.setQtParcelas(0);
		simulacaoModel.setPrimeiraParcela(null);
		simulacaoModel.setImposto(0);
		simulacaoModel.setValorFinanciado(0);
		simulacaoModel.setValorParcela(0);
	}

	public void LimparSimulacao() {
		simulacao.setQtParcelas(0);
		
	}

	


}
