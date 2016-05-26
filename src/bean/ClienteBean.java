package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.ClienteController;
import dao.Exception.ConnectException;
import entities.Cliente;
import model.ClienteModel;

@ManagedBean
@SessionScoped
public class ClienteBean {
	
	
	private ClienteController clienteController = null;
	
	public ClienteController getControllerInstance(){
		if(clienteController == null){
			clienteController = new ClienteController();
		}
		return clienteController;
	}
	
	
	public List<ClienteModel> ClienteListAll() throws ConnectException{
		ClienteController clienteController = new ClienteController();
		return clienteController.ClienteListAll();
		
		
	}
	
	public void ClienteSave() throws ConnectException{
		ClienteController clienteController = getControllerInstance();
		clienteController.ClienteSave();
	}
	
	public void ClienteUpdate() throws ConnectException{
		ClienteController clientControl = getControllerInstance();
		clientControl.ClienteUpdate();
	}
	
	public ClienteModel PrepareTosave(){
		ClienteController clienteController = new ClienteController();
		return clienteController.PrepareTosave();	
	}
	
	public ClienteModel Selected(){
		ClienteController clientControl = getControllerInstance();
		return clientControl.Selected();
				
	}
	
	public String PrepareToEdit(ClienteModel clienteModel){
		ClienteController clientControl = getControllerInstance();
		clientControl.PrepareToEdit(clienteModel);		
		return "Edit";
		
	}

}
