

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar usuarios</title>
    </head>
    <body>
        <form action="UsuarioController" method="post">
            <fieldset>
                <div>
                <label>id de Cliente: </label>
                <input type="text" name="idCliente" value="${cliente.idCliente}"
                       placeholder="idCliente"
                           readonly="readonly"
                       />
                </div>
                       <div>
                <label>Nombre: </label>
                <input type="text" name="nombre" value="${cliente.nombre}"
                       placeholder="nombre"/>
                       </div>
                       <div>       
                <label>Apellido paterno: </label>
                <input type="text" name="apepat" value="${cliente.apepat}"
                       placeholder="apepat"/>
                       </div>
                                <div>       
                <label>Apellido materno: </label>
                <input type="text" name="apemat" value="${cliente.apepat}"
                       placeholder="apepat"/>
                       </div>
                       <div>
                <label>Telefono: </label>
                <input type="text" name="telefono" value="${cliente.telefono}"
                       placeholder="telefono"/>
                       </div>
                       <div>
                <label>Edad: </label>
                <input type="text" name="edad" value="${cliente.edad}"
                       placeholder="Edad del usuario"/>
                       </div>
                       <div>
                           <input type="submit" value="Guardar"/>
                       </div>
            </fieldset>
        </form>
    </body>
</html>
