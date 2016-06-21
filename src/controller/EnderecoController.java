package controller;

import java.util.ArrayList;
import java.util.List;

import dao.EnderecoDao;
import dao.Exception.ConnectException;
import entities.Endereco;
import model.EnderecoModel;

public class EnderecoController {
	

	private static EnderecoController instance = null;
	private EnderecoModel enderecoModelSelected = null;

	public static EnderecoController getInstance(){
		
		if(instance == null){
			instance = new EnderecoController();
		}
		return instance;
	}
	
	public List<EnderecoModel> EnderecoListAll() throws ConnectException{
		EnderecoDao enderecoDao = new EnderecoDao();
		List<Endereco>	enderecodao =  enderecoDao.listAll();
		return ConvertEntitieToModelList(enderecodao);		
	}
	
	
	public void  EnderecoSave() throws ConnectException {		
		EnderecoDao enderecoDao = new EnderecoDao();
		EnderecoModel enderecoModel = EnderecoModel.getInstance();
		enderecoDao.save(ConvertModelToEntitie(enderecoModel));
	}
	
	public EnderecoModel PrepareTosave(){
		
		return EnderecoModel.getInstance();
	}
	
	public EnderecoModel Selected(){				
		return enderecoModelSelected;
	}

	public  void PrepareToEdit(EnderecoModel enderecoModel){
		this.enderecoModelSelected = enderecoModel; 
	}
	
	public void LimparEndereco(){
		EnderecoModel enderecoModel = EnderecoModel.getInstance();
		enderecoModel.setEndereco(null);
		enderecoModel.setBairro(null);
		enderecoModel.setCep(null);
		enderecoModel.setCidade(null);
		
	}
	
	public void EnderecoUpdate() throws ConnectException{
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.update(ConvertModelToEntitie(Selected()));
	}
	
	public List<EnderecoModel> ConvertEntitieToModelList(List<Endereco> enderecodao){
		List<EnderecoModel> enderecoModel = new ArrayList<EnderecoModel>();
		
		for (Endereco endereco : enderecodao) {
			enderecoModel.add(new EnderecoModel(endereco.getNumero(),
					endereco.getBairro(),
					endereco.getCep(),
					endereco.getCidade(),
					endereco.getEndereco(),
					endereco.getEstado()));
			
			
		}
		return enderecoModel;
		
	}
	public List<Endereco> ConvertModelToEntitieList(List<EnderecoModel> endereco){
		
		
		List<Endereco> enderecoEntities = new ArrayList<Endereco>();
		for (EnderecoModel enderecoModels : endereco) {
			enderecoEntities.add(new Endereco(enderecoModels.getNumero(),
					enderecoModels.getBairro(),
					enderecoModels.getCep(),
					enderecoModels.getCidade(),
					enderecoModels.getEndereco(),
					enderecoModels.getEstado()));
			
			
		}
		
		
		return enderecoEntities;
		
	}
	
	public Endereco ConvertModelToEntitie(EnderecoModel enderecoModel){
		return new Endereco(enderecoModel.getNumero(),
				enderecoModel.getBairro(),
				enderecoModel.getCep(),
				enderecoModel.getCidade(),
				enderecoModel.getEndereco(),
				enderecoModel.getEstado());
			
	}

}
