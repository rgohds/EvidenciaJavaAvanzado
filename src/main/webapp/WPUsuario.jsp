<%-- 
    Document   : WPUsuario
    Created on : 10 jul 2023, 20:46:54
    Author     : rlgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.IMC"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Usuario</title>
    </head>
    <body>
        <h1>Usuario</h1>
        <form action="IMC" method="post">                      
           Introduzca tu nombre completo:<br><input type="text" name="Nombre" value=""><br>
           Introduzca tu usuario:<br><input type="text" name="Usuario" value=""><br>
           Introduce tu Edad:<br><input type="text" name="Edad" value=""><br>
           Introduce tu Sexo:<br><input type="text" name="Sexo" value=""><br>
           Introduce tu Estatura:<br><input type="text" name="Estatura" value=""><br>           
           <input type="submit" value="SalvarUsuario">
        </form>        
    </body>
</html>
