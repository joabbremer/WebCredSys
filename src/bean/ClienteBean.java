package bean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.ClienteController;
import dao.Exception.ConnectException;
import model.ClienteModel;


@ManagedBean
@SessionScoped
public class ClienteBean {
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	public List<ClienteModel> ClienteListAll() throws ConnectException{
		ClienteController clienteController = new ClienteController();
		return clienteController.ClienteListAll();
			
	}
	public void ShareByCpf() throws ConnectException{
		SelectClienteByCpf();
		
	}
	
	public ClienteModel SelectClienteByCpf() throws ConnectException{
		
		ClienteController clienteController = ClienteController.getControllerInstance();
		return clienteController.SelectByCpf(getCpf());
		
	}
	
	
	public void ClienteSave() throws ConnectException{
		ClienteController clienteController = ClienteController.getControllerInstance();
		clienteController.ClienteSave();
	}
	
	public void ClienteUpdate() throws ConnectException{
		ClienteController clientControl = ClienteController.getControllerInstance();
		clientControl.ClienteUpdate();
	}
	
	public ClienteModel PrepareTosave(){
		ClienteController clienteController = new ClienteController();
		return clienteController.PrepareTosave();	
	}
	
	public ClienteModel Selected(){
		ClienteController clientControl = ClienteController.getControllerInstance();
		return clientControl.Selected();
				
	}
	
	public String PrepareToEdit(ClienteModel clienteModel){
		ClienteController clientControl = ClienteController.getControllerInstance();
		clientControl.PrepareToEdit(clienteModel);		
		return "Edit";
		
	}

}
