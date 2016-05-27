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
	
	
	public void  ClienteSave(Cliente cliente) throws ConnectException {		
		ClienteDao clienteDao = new ClienteDao();
		/*ClienteModel clienteModel = ClienteModel.getInstance();
		ContatoModel contatoModel = ContatoModel.getInstance();
		
		Cliente clin = ConvertModelToEntitie(clienteModel);
		
		ContatoController contatoController = ContatoController.getInstance();	
		
		
		
		List<ContatoModel> contatosListModel = new ArrayList<ContatoModel>();
		contatosListModel.add(contatoModel);		
		
		List<Contato> cont = contatoController.ConvertModelToEntitieList(contatosListModel);
		
		for (Contato contato : cont) {
			contato.setCliente(clin);
			
		}
		clin.setContatos(cont);*/
		
		clienteDao.save(cliente);
		
		;
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
		ContatoController contatoController = new ContatoController();
		
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
					contatoController.ConvertEntitieToModelList(cliente.getContatos()))); 
			}
		return clienteModel;
		
	}
	
	public ClienteModel ConvertEntitieToModel(Cliente clientedao){
		ContatoController contatoController = new ContatoController();
		
		
		return new ClienteModel(clientedao.getIdCliente(),
					clientedao.getCpf(),
					clientedao.getEmail(),
					clientedao.getIdentidade(),
					clientedao.getNome(),
					clientedao.getRendaConjuge(),
					clientedao.getRendaLiquida(),
					clientedao.getValorAutomoveis(),
					clientedao.getValorImoveis(),
					contatoController.ConvertEntitieToModelList(clientedao.getContatos())); 
		
	}
	
	public Cliente ConvertModelToEntitie(ClienteModel clienteModel){
		
		Cliente cliente = new Cliente();
		if(clienteModel != null){
			cliente =	new Cliente(clienteModel.getIdCliente(),
					clienteModel.getCpf(),
					clienteModel.getEmail(),
					clienteModel.getIdentidade(),
					clienteModel.getNome(),
					clienteModel.getRendaConjuge(),
					clienteModel.getRendaLiquida(),
					clienteModel.getValorAutomoveis(),
					clienteModel.getValorImoveis());
		}
		return cliente;
	}
	
}
