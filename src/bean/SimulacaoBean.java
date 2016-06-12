package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

import controller.SimulacaoController;
import model.SimulacaoModel;

@ManagedBean
@ViewScoped
public class SimulacaoBean {
	
	SimulacaoController simulacaoController = new SimulacaoController();
	
	
	public SimulacaoModel PrepareToSimule(){
		return simulacaoController.PrepareToSimule();
		
	}
	
	public SimulacaoModel Simule(){
		return simulacaoController.Simule();
		
	}
	
	public String Simular(){
		simulacaoController.Simular();		
		return "/simulacao_calculada.xhtml";
	}

}
