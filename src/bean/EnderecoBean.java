package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.EnderecoController;
import dao.Exception.ConnectException;
import model.EnderecoModel;

@ManagedBean
@SessionScoped
public class EnderecoBean {
	
private EnderecoController contatController = null;
	
	public EnderecoController getControllerInstance(){
		if(contatController == null){
			contatController = new EnderecoController();
		}
		return contatController;
	}
	
	
	public List<EnderecoModel> EnderecoListAll() throws ConnectException{
		EnderecoController enderecoController = new EnderecoController();
		return enderecoController.EnderecoListAll();
		
		
	}
	
	public void EnderecoSave() throws ConnectException{
		EnderecoController clienteController = new EnderecoController();
		clienteController.EnderecoSave();
	}
	
	public void EnderecoUpdate() throws ConnectException{
		EnderecoController enderecoControl = getControllerInstance();
		enderecoControl.EnderecoUpdate();
	}
	
	public EnderecoModel PrepareTosave(){
		EnderecoController enderecoController = new EnderecoController();
		return enderecoController.PrepareTosave();	
	}
	
	public EnderecoModel Selected(){
		EnderecoController enderecoControl = getControllerInstance();
		return enderecoControl.Selected();
				
	}
	
	public String PrepareToEdit(EnderecoModel enderecoModel){
		EnderecoController enderecoControl = getControllerInstance();
		enderecoControl.PrepareToEdit(enderecoModel);		
		return "Edit";
		
	}

}
