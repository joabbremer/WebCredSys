package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.ClienteController;
import controller.ParcelaController;
import dao.Exception.ConnectException;
import entities.Cliente;
import entities.Financiamento;
import entities.Parcela;
import model.ClienteModel;
import model.ParcelaModel;

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
	
	public ClienteModel SelectClienteByCpf() throws ConnectException{
		
		ClienteController clienteController = getControllerInstance();
		return clienteController.SelectByCpf(getCpf());
		
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
