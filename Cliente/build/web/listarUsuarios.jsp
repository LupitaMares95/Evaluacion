

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar usuarios</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id Cliente</th>
                    <th>Nombre</th>
                    <th>Aptpat</th>
                    <th>Aptmat</th>
                    <th>Telefono</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td>${cliente.idUsuario}</td>
                        <td>${cliente.nombre}</td>
                        <td>${cliente.apepat}</td>
                        <td>${cliente.apemat}</td>
                        <td>${cliente.telefono}</td>
                        <td>${cliente.edad}</td>
                        <td><a href="ClientesControlador?action=cambiar&idCliente=${usuario.idCliente}">Cambiar</a></td>
                        <td><a href="ClientesControlador?action=borrar&idCliente=${usuario.idCliente}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ClienteControlador?action=agregar">Nuevo Cliente</a>
        </p>
    </body>
</html>
