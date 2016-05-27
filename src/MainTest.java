import java.util.ArrayList;
import java.util.List;

import controller.ClienteController;
import dao.Exception.ConnectException;
import entities.Cliente;
import entities.Contato;

public class MainTest {

	public static void main(String[] args) {

		ClienteController clienteController = new ClienteController();
		
		List<Contato> contatos = new ArrayList<Contato>();
		contatos.add(new Contato(0, "96447503", "Celular"));
		
		
		
		Cliente clin = new Cliente(123, "teste",
				"test",
				"test",
				100.00, 100.00, 100.00, 100.00,
				contatos);
		
		
		
		try {
			clienteController.ClienteSave(clin);
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
