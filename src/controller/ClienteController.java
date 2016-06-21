package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.Exception.ConnectException;
import entities.Cliente;
import entities.Contato;
import model.ClienteModel;
import model.ContatoModel;
import model.EnderecoModel;
import model.FinanciamentoModel;
import model.ParcelaModel;

public class ClienteController {
	
	private ClienteModel clienteModelSelected = null;
	private static ClienteController clienteController = null;
	
	public static ClienteController getControllerInstance(){
		if(clienteController == null){
			clienteController = new ClienteController();
		}
		return clienteController;
	}

	public ClienteController() {
		
	}
	
	public List<ClienteModel> ClienteListAll() throws ConnectException{
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente>	clientedao =  clienteDao.listAll();
		return ConvertEntitieToModelList(clientedao);		
	}
	
	public void SelectByCpf(String cpf) throws ConnectException{
		ClienteDao clienteDao = new ClienteDao();
		ParcelaController parcelaController = ParcelaController.getControllerInstance();
		
		
		parcelaController.SelectParcelaForCliente(ConvertEntitieToModelList(clienteDao.selectByCpf(cpf)));
		clienteModelSelected = ConvertListToOneModel(ConvertEntitieToModelList(clienteDao.selectByCpf(cpf)));
		
		
	}
	
	
	public void  ClienteSave() throws ConnectException {		
		ClienteDao clienteDao = new ClienteDao();
		ClienteModel clienteModel = ClienteModel.getInstance();		
		ContatoModel contatoModel = ContatoModel.getInstance();
		EnderecoModel enderecoModel = EnderecoModel.getInstance();
			
		List<ContatoModel> contListModel = new ArrayList<ContatoModel>();
		contListModel.add(contatoModel);
		
		List<EnderecoModel> endListModel = new ArrayList<EnderecoModel>();
		endListModel.add(enderecoModel);
		
		clienteModel.setEnderecos(endListModel);		
		clienteModel.setContatos(contListModel);
		
		Cliente cliente = ConvertModelToEntitie(clienteModel);
		clienteDao.save(cliente);
		LimparCliente();
		
	}
	
	public void LimparCliente() {
		ClienteModel clienteModel = ClienteModel.getInstance();
		EnderecoController endControll = EnderecoController.getInstance();
		ContatoController contatoController = ContatoController.getInstance();
		FinanciamentoController FinanControll = FinanciamentoController.getControllerInstance();
		clienteModel.setNome(null);
		clienteModel.setGenero('n');
		clienteModel.setCpf(null);
		clienteModel.setIdentidade(null);
		clienteModel.setEmail(null);
		clienteModel.setRendimentos(null);
		clienteModel.setGarantias(null);
		endControll.LimparEndereco();
		contatoController.LimparContato();
		FinanControll.LimparFinanciamento();
		PrepareToEdit(clienteModel);
		
		
		
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
		
		ClienteModel clienteModel = Selected();
		FinanciamentoController finanControll = FinanciamentoController.getControllerInstance();
		
		List<FinanciamentoModel>  financiamentoModel = new ArrayList<FinanciamentoModel>();
		
		financiamentoModel.add(new FinanciamentoModel(0, finanControll.getParcelas()));
		clienteModel.setFinanciamentos(financiamentoModel);		
		clienteDao.update(ConvertModelToEntitie(clienteModel));
		LimparCliente();
		
	}
	
	public List<ClienteModel> ConvertEntitieToModelList(List<Cliente> clientedao){
		ContatoController contatoController = new ContatoController();
		EnderecoController enderecoController = new EnderecoController();
		FinanciamentoController financiamentoController = new FinanciamentoController();
		
		List<ClienteModel> clienteModel = new ArrayList<ClienteModel>();		
		for (Cliente cliente : clientedao) {
			
			clienteModel.add(new ClienteModel(cliente.getIdCliente(),
					cliente.getCpf(),
					cliente.getEmail(),
					cliente.getIdentidade(),
					cliente.getNome(),
					cliente.getGenero(),
					cliente.getRendimentos(),
					cliente.getGarantias(),
					contatoController.ConvertEntitieToModelList(cliente.getContatos()),
					enderecoController.ConvertEntitieToModelList(cliente.getEnderecos()),
					financiamentoController.ConvertEntitieToModelList(cliente.getFinanciamentos())
					)); 
			}
		return clienteModel;
		
	}
	public ClienteModel ConvertListToOneModel(List<ClienteModel> clienteModel){
		
		
		ClienteModel clienteM = new ClienteModel();
		for (ClienteModel clienteModels : clienteModel) {
			clienteM =	new ClienteModel(clienteModels.getIdCliente(),
					clienteModels.getCpf(),
					clienteModels.getEmail(),
					clienteModels.getIdentidade(),
					clienteModels.getNome(),
					clienteModels.getGenero(),
					clienteModels.getRendimentos(),
					clienteModels.getGarantias(),
					clienteModels.getContatos(),
					clienteModels.getEnderecos(),
					clienteModels.getFinanciamentos()
					);
		}
		
		
		return clienteM;
	}
	
	public ClienteModel ConvertEntitieToModel(Cliente clientedao){
		ContatoController contatoController = new ContatoController();
		
		
		
		return new ClienteModel(clientedao.getIdCliente(),
					clientedao.getCpf(),
					clientedao.getEmail(),
					clientedao.getIdentidade(),
					clientedao.getNome(),
					clientedao.getGenero(),
					clientedao.getRendimentos(),
					clientedao.getGarantias(),
					contatoController.ConvertEntitieToModelList(clientedao.getContatos())); 
		
	}
	
	public Cliente ConvertModelToEntitie(ClienteModel clienteModel){
		ContatoController contatoController = new ContatoController();
		EnderecoController enderecoController = new EnderecoController();
		FinanciamentoController finanControll = new FinanciamentoController();
		
		Cliente cliente = new Cliente();
		if(clienteModel != null){
			cliente =	new Cliente(clienteModel.getIdCliente(),
					clienteModel.getCpf(),
					clienteModel.getEmail(),
					clienteModel.getIdentidade(),
					clienteModel.getNome(),
					clienteModel.getGenero(),
					clienteModel.getRendimentos(),
					clienteModel.getGarantias(),
					contatoController.ConvertModelToEntitieList(clienteModel.getContatos()),
					enderecoController.ConvertModelToEntitieList(clienteModel.getEnderecos()),					
					finanControll.ConvertModelToEntitieList(clienteModel.getFinanciamentos())
					);
		}
		return cliente;
	}

	public ClienteModel PrepareToShare() {
		return ClienteModel.getInstance();
	}
	
}
