package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import controller.ParcelaController;
import controller.SimulacaoController;
import model.ParcelaModel;
import model.SimulacaoModel;

@ManagedBean
@SessionScoped
public class FinanciamentoBean {
	
	private DataModel<ParcelaModel> parcDataModel = new  ListDataModel<ParcelaModel>();	
	public void CalcularFinanciamento(){
		SimulacaoController simulacaoController = SimulacaoController.getControllerInstance();
		simulacaoController.Simular();
		
	}
	
	public DataModel<ParcelaModel> ListParcela(){
		SimulacaoController simulacaoController = SimulacaoController.getControllerInstance();
		SimulacaoModel simulacaoModel = simulacaoController.ResultSimule();
		ParcelaModel parcela = ParcelaModel.getInstance();
		
		List<ParcelaModel> parcelaModel = new ArrayList<ParcelaModel>();
		
		for (int i = 0; i < simulacaoModel.getQtParcelas(); i++) {
			
			parcelaModel.add(parcela);
			
		}
		parcDataModel = new  ListDataModel<ParcelaModel>(parcelaModel);
			
		return parcDataModel;
		 
	}
	
	
	
	public DataModel<ParcelaModel> getParcDataModel() {
		return parcDataModel;
	}

	public void setParcDataModel(DataModel<ParcelaModel> parcDataModel) {
		this.parcDataModel = parcDataModel;
	}

	
	

}
