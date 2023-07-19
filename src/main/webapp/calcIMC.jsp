<%-- 
    Document   : calcIMC
    Created on : 10 jul 2023, 20:56:05
    Author     : rlgar
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.IMC"%>
<!DOCTYPE html>
<html>
    <%
            /*String NombreCompleto = String.valueOf(request.getAttribute("NombreCompleto"));
            String NombreUsuario = String.valueOf(request.getAttribute("NombreUsuario"));
            String Edad = String.valueOf(request.getAttribute("Edad"));
            String Sexo = String.valueOf(request.getAttribute("Sexo"));
            String Estatura = String.valueOf(request.getAttribute("Estatura"));            */

            String Smensaje = String.valueOf(request.getAttribute("mensaje"));
            
            String NombreCompleto="";
            String NombreUsuario="";
            String Edad="";
            String Sexo="";
            String Estatura="";

            HttpSession sesion = request.getSession(false);
            Enumeration e = sesion.getAttributeNames();
            if(e.hasMoreElements())
            {
                NombreCompleto = String.valueOf(session.getAttribute("NombreCompleto"));
                NombreUsuario = String.valueOf(session.getAttribute("NombreUsuario"));
                Edad = String.valueOf(session.getAttribute("Edad"));
                Sexo = String.valueOf(session.getAttribute("Sexo"));
                Estatura = String.valueOf(session.getAttribute("Estatura"));
            }
            
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calcula tu IMC</title>
    </head>
    <body>
        <%if (Smensaje != "null") {%>
        <br><%=Smensaje%><br>  
        <%}
        %> 
        <h1>Calcula tu IMC</h1>
        Hola: <%=NombreCompleto%><br>
        Edad: <%=Edad%><br>
        Sexo: <%=Sexo%><br>
        Estatura: <%=Estatura%> cm<br>
        <br>
        <form action="IMC" method="post">
            Introduzca tu peso actual:<br><input type="text" name="Peso" value=""><br>
            <input type="submit" name = "sel" value="Calcula IMC">
        </form>    
    </body>
</html>
