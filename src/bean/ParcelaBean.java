package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.ParcelaController;
import entities.Parcela;
import model.ParcelaModel;

@ManagedBean
@SessionScoped
public class ParcelaBean {
	
	public ParcelaModel PrepareToSimule(){
		ParcelaController parcelaController = new ParcelaController();
		return parcelaController.PrepareToSimule();
	}
	
	public List<Parcela> ListParcela(){
		ParcelaController parcelaController = new ParcelaController();
		return parcelaController.SelectParcelaForCliente();
		 
	}

}
