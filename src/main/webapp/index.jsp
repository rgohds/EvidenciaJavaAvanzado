<%-- 
    Document   : index
    Created on : 10 jul 2023, 19:29:23
    Author     : rlgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.IMC"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
    </head>
    <body>
        <h1>Evidencia - IMC Tracking</h1>
        <form action="IMC" method="post">            
            <input type="submit" name = "sel" value="AltaUsuario">
            <input type="submit" name = "sel" value="calcular">
            <input type="submit" name = "sel" value="Visualizar Historico">
        </form>
    </body>
</html>