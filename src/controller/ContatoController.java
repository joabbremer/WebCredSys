package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.ContatoDao;
import dao.Exception.ConnectException;
import entities.Cliente;
import entities.Contato;
import model.ClienteModel;
import model.ContatoModel;

public class ContatoController {
	
	private ContatoModel contatoModelSelected = null;
	private static ContatoController instance = null;

	public ContatoController() {
		
	}
	
	public static ContatoController getInstance(){
		if(instance == null){
			instance = new ContatoController();
		}
		return instance;
	}
	
	public List<ContatoModel> ContatoListAll() throws ConnectException{
		ContatoDao contatoDao = new ContatoDao();
		List<Contato>	contatodao =  contatoDao.listAll();
		return ConvertEntitieToModelList(contatodao);		
	}
	
	
	public void  ContatoSave() throws ConnectException {		
		ContatoDao contatoDao = new ContatoDao();
		ContatoModel contatoModel = ContatoModel.getInstance();
		contatoDao.save(ConvertModelToEntitie(contatoModel));
	}
	
	public ContatoModel PrepareTosave(){
		
		return ContatoModel.getInstance();
	}
	
	public ContatoModel Selected(){				
		return contatoModelSelected;
	}

	public  void PrepareToEdit(ContatoModel contatoModel){
		this.contatoModelSelected = contatoModel; 
	}
	
	public void ContatoUpdate() throws ConnectException{
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.update(ConvertModelToEntitie(Selected()));
	}
	
	public List<ContatoModel> ConvertEntitieToModelList(List<Contato> contatodao){
		List<ContatoModel> contatoModel = new ArrayList<ContatoModel>();
		
		for (Contato contato : contatodao) {
			contatoModel.add(new ContatoModel(contato.getIdContato(),
					contato.getContato(),
					contato.getTipo()));
			
			
		}
		return contatoModel;
		
	}
	public List<Contato> ConvertModelToEntitieList(List<ContatoModel> contato){
		
		
		List<Contato> contatoEntities = new ArrayList<Contato>();
		for (ContatoModel contatoModels : contato) {
			contatoEntities.add(new Contato(contatoModels.getIdContato(),
					contatoModels.getContato(),
					contatoModels.getTipo()));
			
			
		}
		
		
		return contatoEntities;
		
	}
	
	public Contato ConvertModelToEntitie(ContatoModel contatoModel){
		ClienteController clienteController = new ClienteController();
		
		
		return new Contato(contatoModel.getIdContato(),
				contatoModel.getContato(),
				contatoModel.getTipo(),
				clienteController.ConvertModelToEntitie(contatoModel.getCliente()));
			
	}
	
}

