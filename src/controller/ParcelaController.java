package controller;

import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import entities.Financiamento;
import entities.Parcela;
import model.ParcelaModel;

public class ParcelaController {
	
	public ParcelaModel PrepareToSimule(){
		return ParcelaModel.getInstance();
	}
	
	public List<Parcela> SelectParcelaForCliente(){
		
		Cliente cliente = Cliente.getInstance();
		
		
		List<Financiamento> finan =  cliente.getFinanciamentos();
		List<Parcela> parc = new ArrayList<Parcela>();
				
		for (Financiamento financiamento : finan) {
			parc = financiamento.getParcelas();
			
		}
		
		
	
		
		
		return parc;
		
		
		
		
	}

}
