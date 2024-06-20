package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.ICliente;

import model.TblCliente;
public class TblClienteImp implements ICliente{

	@Override
	public void RegistrarCliente(TblCliente cliente) {
		
		// Establecer la conexion con la unidad de persistencia		
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenJPALPII");
		// Gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		// iniciamos la transacción
		emanager.getTransaction().begin();
		//registramos a la base de datos
		emanager.persist(cliente);
		//emitimos mensaje por pantalla
		System.out.println("Cliente registrado en la base de dato");
		//confirmamos la transaccion
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}

	@Override
	public void ActualizarCliente(TblCliente cliente) {
		// establecemos conexion con la unidad de persitencia
		
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenJPALPII");
		//Gestionar las entidades
		
		EntityManager emanager=em.createEntityManager();
		//Iniciamos la transaccion
		
		emanager.getTransaction().begin();
		//Actualizamos 
		emanager.merge(cliente);
		//Emitir mensaje por consola
		System.out.println("Cliente actualizado en la BD");
		//Confirmamos
		
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	}

	@Override
	public void EliminarCliente(TblCliente cliente) {
		// Establecemos la conexion con la unidad de persitencia
		
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenJPALPII");
		
		//Gestionar las Entidades
		
		EntityManager emanager=em.createEntityManager();
		
		//Iniciamos la transacción
		
		emanager.getTransaction().begin();
		//Recuperamos el codigo a eliminar
		
		TblCliente elim=emanager.merge(cliente);
		//Procedemos a eliminar el registro
		
		emanager.remove(elim);
		//Emitir mensaje por consola
		System.out.println("Cliente eliminado de la base de datos");
		
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}

	@Override
	public TblCliente BuscarCliente(TblCliente cliente) {
		
	//Establecemos la conexion con la unidad de persistencia
	EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenJPALPII");
	//Gestionar las Entidades
	
	EntityManager emanager=em.createEntityManager();
	//Iniciamos la transacción
	
	emanager.getTransaction().begin();
	
	//Recuperamos el codigo buscar
	
	TblCliente buscliente=emanager.find(TblCliente.class,cliente.getIdcliente());
	
	//Confirmamos
	emanager.getTransaction().commit();
	
	//cerrramos
	emanager.close();
	

		return buscliente;
	}

	@Override
	public List<TblCliente> ListarCliente() {
	// Establecemos la conexion con la unidad de persitencia
		
	EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoMavenJPALPII");
	
	//Gestionar las Entidades
	
	EntityManager emanager=em.createEntityManager();
	
	//Iniciamos la transacción
	
	emanager.getTransaction().begin();
	
	//Recuperamos los clientes
	//Create createquery sirve para la creacion de consultas dinamicas
	
	List<TblCliente> listadoclientes=emanager.createQuery("select c from TblCliente c", TblCliente.class).getResultList();
	//Confirmamos
	emanager.getTransaction().commit();
		
	//cerrramos
	emanager.close();
		return listadoclientes;
	}
	
	
}
	