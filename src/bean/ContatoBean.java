package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.ContatoController;
import dao.Exception.ConnectException;
import model.ContatoModel;

@ManagedBean
@SessionScoped
public class ContatoBean {
	
	
	private ContatoController contatController = null;
	
	public ContatoController getControllerInstance(){
		if(contatController == null){
			contatController = new ContatoController();
		}
		return contatController;
	}
	
	
	public List<ContatoModel> ContatoListAll() throws ConnectException{
		ContatoController contatoController = new ContatoController();
		return contatoController.ContatoListAll();
		
		
	}
	
	public void ContatoSave() throws ConnectException{
		ContatoController clienteController = new ContatoController();
		clienteController.ContatoSave();
	}
	
	public void ContatoUpdate() throws ConnectException{
		ContatoController contatoControl = getControllerInstance();
		contatoControl.ContatoUpdate();
	}
	
	public ContatoModel PrepareTosave(){
		ContatoController contatoController = new ContatoController();
		return contatoController.PrepareTosave();	
	}
	
	public ContatoModel Selected(){
		ContatoController contatoControl = getControllerInstance();
		return contatoControl.Selected();
				
	}
	
	public String PrepareToEdit(ContatoModel contatoModel){
		ContatoController contatoControl = getControllerInstance();
		contatoControl.PrepareToEdit(contatoModel);		
		return "Edit";
		
	}

}

