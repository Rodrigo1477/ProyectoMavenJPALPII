package Test;



import java.util.List;

import Dao.TblClienteImp;
import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		// Instanciamos la entidad tblcliente
		
		TblCliente cliente=new TblCliente();
		TblClienteImp crud=new TblClienteImp();
		
		//Asignamos datos
		
	/*	cliente.setNombre("Carla");
		cliente.setApellido("Mona Simba");
		cliente.setDni("1445545");
		cliente.setEmail("Carla@gmail.com");
		cliente.setTelf("988778897");
		cliente.setSexo("F");
		cliente.setNacionalidad("Boliviana");
		
		//Invocamos el metodo registrar datos en BD
		crud.RegistrarCliente(cliente); */
		
		
		//*********************Testeamos el  actualizar
		
	/*	cliente.setIdcliente(2);
		cliente.setNombre("Roberto Alexis");
		cliente.setApellido("Rivera Gomez");
		cliente.setDni("76819668");
		cliente.setEmail("RobertoW@gmail.com");
		cliente.setTelf("956544787");
		cliente.setSexo("F");
		cliente.setNacionalidad("Argentino");
		
		//Invocamos el metodo actualizar datos
		
		crud.ActualizarCliente(cliente);
		
	*/	
		//************Testeamos el eliminar..
		
		/* cliente.setIdcliente(5);
		
		//invocamos el metodo eliminar datos
		
		crud.EliminarCliente(cliente); */
		
	/*	//**********Testeamos el metodo buscar
		cliente.setIdcliente(4);
		//invocamos el metodo bucar
		TblCliente bus=crud.BuscarCliente(cliente);
		//Imprimimos en pantalla el registro buscado
		System.out.println("codigo" + bus.getIdcliente() + " nombre "+bus.getNombre() + 
				" apellido: " +bus.getApellido() + 
				" dni: " +bus.getDni() + 
				" email: " + bus.getDni() + 
				" telf: " + bus.getTelf() +
				" sexo: " + bus.getSexo() + 
				" nacionalidad: " + bus.getNacionalidad()); */
		
		//Testeamos el metodo listado de clientes registrados en la base de datos
		
		List<TblCliente> listado=crud.ListarCliente();
		
		for(TblCliente lis:listado) {
			//imprimimos en pantalla los datos recuperados
			System.out.println("codigo" + lis.getIdcliente() + " nombre "+lis.getNombre() + 
					" apellido: " +lis.getApellido() + 
					" dni: " +lis.getDni() + 
					" email: " + lis.getDni() + 
					" telf: " + lis.getTelf() +
					" sexo: " + lis.getSexo() + 
					" nacionalidad: " + lis.getNacionalidad());
		}
		
		
		
	

	}

}

