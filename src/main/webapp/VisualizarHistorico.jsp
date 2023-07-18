<%-- 
    Document   : VisualizarHistorico
    Created on : 10 jul 2023, 21:08:44
    Author     : rlgar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String Nombre = String.valueOf(request.getAttribute("Nombre"));
    %> 
    <body>        
        <h1>Resultado IMC</h1>
        Hola: <%=Nombre%><br>
        Estatura: 174 cm<br>
        Fecha : 10/07/2023<br>
        <br>
        <c:forEach var="items" items="${medidas}">
            ${items}
        </c:forEach>        
    </body>
</html>
