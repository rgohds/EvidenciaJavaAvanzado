<%-- 
    Document   : LoginPage
    Created on : 10 jul 2023, 19:29:23
    Author     : rlgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.IMC"%>
<html>
    <%
            String Smensaje = String.valueOf(request.getAttribute("mensaje"));
    %>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <%if (Smensaje != "null") {%>
        <br><%=Smensaje%><br>  
        <%}
        %>  
        <form action="IMC" method="post">            
            Introduzca su Usuario:<br>
            <input type="text" name="Usuario" value=""><br>
            Introduzca su Pwd:<br>
            <input type="text" name="Password" value=""><br>            
            <input type="submit" name = "sel" value="Valida Login">
        </form>
    </body>
</html>