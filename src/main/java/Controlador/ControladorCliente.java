package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TblCliente;
import Dao.TblClienteImp;

/**
 * Servlet implementation class ControladorCliente
 */
public class ControladorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCliente() {
        super();
        // TODO Auto-generated constructor stub
    } // Fin del cosntructor

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TblCliente cliente=new TblCliente();
		TblClienteImp crud = new TblClienteImp();
		
		List<TblCliente> listadocliente=crud.ListarCliente();
		
		//Asignamos el listado de clientes recuperados en la BD
		
		request.setAttribute("listadoclientes", listadocliente);

		//response.getWriter().append("Controlador Cliente: ").append(request.getContextPath());
		request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
		
		
	} // Fin del metodo doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// Recuperamos los datos del formulario
		
		String Nombre = request.getParameter("nombre");
		String Apellido = request.getParameter("apellido");
		String DNI = request.getParameter("dni");
		String Email = request.getParameter("email");
		String Telefono = request.getParameter("telefono");
		String Sexo = request.getParameter("sexo");
		String Nacionalidad = request.getParameter("nacionalidad");
		
		//instanciamos las respectivas clases...
		
		TblCliente cliente = new TblCliente();
		TblClienteImp crud=new TblClienteImp();
		//Asignamos valores
		
		cliente.setNombre(Nombre);
		cliente.setApellido(Apellido);
		cliente.setDni(DNI);
		cliente.setEmail(Email);
		cliente.setTelf(Telefono);
		cliente.setSexo(Sexo);
		cliente.setNacionalidad(Nacionalidad);
		
		//Invocamos al metodo registrar cliente en la bd
		
		crud.RegistrarCliente(cliente);
		
		//Actualizar el listado
		List<TblCliente> listadocliente=crud.ListarCliente();
		//Asignamos el listado de clientes recuperados en la BD
		request.setAttribute("listadoclientes", listadocliente);
		
		//Redireccionaremos hacia el listado de clientes
		request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
		
	} // Fin del metodo doPost
 
}
