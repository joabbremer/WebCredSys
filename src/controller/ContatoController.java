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

	public ContatoController() {
		
	}
	
	public List<ContatoModel> ContatoListAll() throws ConnectException{
		ContatoDao contatoDao = new ContatoDao();
		List<Contato>	contatodao =  contatoDao.listAll();
		return ConvertEntitieToModelList(contatodao);		
	}
	
	
	public void  ContatoSave() throws ConnectException {		
		ContatoDao contatoDao = new ContatoDao();
		ContatoModel contatoModel = new ContatoModel();
		contatoDao.save(ConvertModelToEntitie(contatoModel));
	}
	
	public ContatoModel PrepareTosave(){
		return new ContatoModel();
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
		ClienteController contatoController = new ClienteController();
		
		for (Contato contato : contatodao) {
			contatoModel.add(new ContatoModel(contato.getContato(),
					contato.getTipo(),
					contatoController.ConvertEntitieToModel(contato.getCliente())));
			
			
		}
		return contatoModel;
		
	}
	
	public Contato ConvertModelToEntitie(ContatoModel contatoModel){
		Cliente contato = null;
		if(contatoModel.getCliente() != null){
			ClienteController contatoController = new ClienteController();
			contato = contatoController.ConvertModelToEntitie(contatoModel.getCliente());
			
		}
		
				
		return new Contato(contatoModel.getIdContato(),
				contatoModel.getContato(),
				contatoModel.getTipo(),
				contato);
			
	}
	
}

