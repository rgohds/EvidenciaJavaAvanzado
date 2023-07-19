<%-- 
    Document   : VisualizarHistorico
    Created on : 10 jul 2023, 21:08:44
    Author     : rlgar
--%>

<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
            /*String NombreCompleto = String.valueOf(request.getAttribute("NombreCompleto"));
            String NombreUsuario = String.valueOf(request.getAttribute("NombreUsuario"));
            String Edad = String.valueOf(request.getAttribute("Edad"));
            String Sexo = String.valueOf(request.getAttribute("Sexo"));
            String Estatura = String.valueOf(request.getAttribute("Estatura"));            */

            String NombreCompleto="";
            String NombreUsuario="";
            String Edad="";
            String Sexo="";
            String Estatura="";
            String IMC="";

            HttpSession sesion = request.getSession(false);
            Enumeration e = sesion.getAttributeNames();
            if(e.hasMoreElements())
            {
                NombreCompleto = String.valueOf(sesion.getAttribute("NombreCompleto"));
                NombreUsuario = String.valueOf(sesion.getAttribute("NombreUsuario"));
                Edad = String.valueOf(sesion.getAttribute("Edad"));
                Sexo = String.valueOf(sesion.getAttribute("Sexo"));
                Estatura = String.valueOf(sesion.getAttribute("Estatura"));
                IMC = String.valueOf(request.getAttribute("IMC"));
            }
            
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>    
    <body>        
        <h1>Calcula tu IMC</h1>
        Hola: <%=NombreCompleto%><br>
        Edad: <%=Edad%><br>
        Sexo: <%=Sexo%><br>
        Estatura: <%=Estatura%> cm<br>
        IMC Actual: <%=IMC%> <br>
        <br>
        <table border="1" cellpadding="10%" align="left" bordercolor="red">
        <tr>
          <th>Fecha</th>
          <th>Peso </th>
          <th>IMC</th>
        </tr>
        <c:forEach var="items" items="${medidas}">
        <tr>    
            <td>${items.getFecha()}</td>
            <td>${items.getPeso()}</td>
            <td>${items.getIMC()}</td>            
        </tr>    
        </c:forEach>        
    </body>
</html>
