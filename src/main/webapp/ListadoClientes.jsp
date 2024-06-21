<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.*" %>
<%@page import="model.TblCliente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Clientes</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Listado de Clientes</h1>

<h2>
<a href="RegistrarCliente.jsp">Registrar Cliente</a>
</h2>

<table>
    <tr>
        <th>Codigo</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Dni</th>
        <th>Email</th>
        <th>Telefono</th>
        <th>Sexo</th>
        <th>Nacionalidad</th>
    </tr>
    <%
        List<TblCliente> listadocliente = (List<TblCliente>) request.getAttribute("listadoclientes");
        if (listadocliente != null) {
            for (TblCliente lis : listadocliente) {
    %>
    <tr>
        <td><%= lis.getIdcliente() %></td>
        <td><%= lis.getNombre() %></td>
        <td><%= lis.getApellido() %></td>
        <td><%= lis.getDni() %></td>
        <td><%= lis.getEmail() %></td>
        <td><%= lis.getTelf() %></td>
        <td><%= lis.getSexo() %></td>
        <td><%= lis.getNacionalidad() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
