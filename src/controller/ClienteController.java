package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.Exception.ConnectException;
import entities.Cliente;
import entities.Contato;
import model.ClienteModel;
import model.ContatoModel;

public class ClienteController {
	
	private ClienteModel clienteModelSelected = null;

	public ClienteController() {
		
	}
	
	public List<ClienteModel> ClienteListAll() throws ConnectException{
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente>	clientedao =  clienteDao.listAll();
		return ConvertEntitieToModelList(clientedao);		
	}
	
	
	public void  ClienteSave() throws ConnectException {		
		ClienteDao clienteDao = new ClienteDao();
		ClienteModel clienteModel = ClienteModel.getInstance();
		
		List<ContatoModel> contatos = new ArrayList<ContatoModel>();
		
		
		
		contatos.add(new ContatoModel("96447503", "Celular", clienteModel));
		clienteModel.setContatos(contatos);
		
		
		clienteDao.save(ConvertModelToEntitie(clienteModel));
	}
	
	public ClienteModel PrepareTosave(){
		return ClienteModel.getInstance();
	}
	
	public ClienteModel Selected(){				
		return clienteModelSelected;
	}

	public  void PrepareToEdit(ClienteModel clienteModel){
		this.clienteModelSelected = clienteModel; 
	}
	
	public void ClienteUpdate() throws ConnectException{
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.update(ConvertModelToEntitie(Selected()));
	}
	
	public List<ClienteModel> ConvertEntitieToModelList(List<Cliente> clientedao){
		List<ClienteModel> clienteModel = new ArrayList<ClienteModel>();		
		for (Cliente cliente : clientedao) {
			
			clienteModel.add(new ClienteModel(cliente.getIdCliente(),
					cliente.getCpf(),
					cliente.getEmail(),
					cliente.getIdentidade(),
					cliente.getNome(),
					cliente.getRendaConjuge(),
					cliente.getRendaLiquida(),
					cliente.getValorAutomoveis(),
					cliente.getValorImoveis(),
					cliente.getContatos(),
					cliente.getEnderecos(),
					cliente.getFinanciamentos())); 
			}
		return clienteModel;
		
	}
	
	public ClienteModel ConvertEntitieToModel(Cliente clientedao){
		return new ClienteModel(clientedao.getIdCliente(),
					clientedao.getCpf(),
					clientedao.getEmail(),
					clientedao.getIdentidade(),
					clientedao.getNome(),
					clientedao.getRendaConjuge(),
					clientedao.getRendaLiquida(),
					clientedao.getValorAutomoveis(),
					clientedao.getValorImoveis(),
					clientedao.getContatos(),
					clientedao.getEnderecos(),
					clientedao.getFinanciamentos()); 
		
	}
	
	public Cliente ConvertModelToEntitie(ClienteModel clienteModel){
		ContatoController contatoController = new ContatoController();
		//contatoController.ConvertModelToEntitieList(clienteModel.getContatos());
		
		
			return	new Cliente(clienteModel.getIdCliente(),
						clienteModel.getCpf(),
						clienteModel.getEmail(),
						clienteModel.getIdentidade(),
						clienteModel.getNome(),
						clienteModel.getRendaConjuge(),
						clienteModel.getRendaLiquida(),
						clienteModel.getValorAutomoveis(),
						clienteModel.getValorImoveis(),
						contatoController.ConvertModelToEntitieList(clienteModel.getContatos()));	
			
			
	}
	
}
