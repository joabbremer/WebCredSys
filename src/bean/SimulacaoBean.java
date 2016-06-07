package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.SimulacaoController;
import model.SimulacaoModel;

@ManagedBean
@SessionScoped
public class SimulacaoBean {
	
	SimulacaoController simulacaoController = new SimulacaoController();
	
	public SimulacaoModel PrepareToSimule(){
		return simulacaoController.PrepareToSimule();
		
	}
	
	public String Simular(){
		simulacaoController.Simular();		
		return "/simulacao_calculada.xhtml";
	}

}
