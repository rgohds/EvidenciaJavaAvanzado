/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rlgar
 */
public class UsuarioDbUtil {
    
    public static int ValidaUsuario(String pNombreUsuario, 
                                    String pPwd ) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/evidencia?useSSL=false";
        String userName = "root";
        String password = "j$NT1hm$uCIf2aMU";
        int Resultado = 0;
                       
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        
        Statement stmt = con.createStatement();
        
        String query = "select * from tblUsuario where NombreUsuario = '";
        query = query + pNombreUsuario + "'";
                       
        String DbPwd = "";
        
        ResultSet rs = stmt.executeQuery(query);
        
        int rowCount = 0;
        while (rs.next()) {
               rowCount++;
               DbPwd = rs.getString("Pwd");
          }
        if (rowCount == 0) {
               Resultado = 1; // Usuario no existe
          }
        else
        {
            if (pPwd.equals(DbPwd))
            {                
              Resultado = 2; // Usuario valido
            }
            else
            {                
              Resultado = 3; // Password Incorrecto
            }
        }        
        return Resultado;        
    }
    
    public static String GetMessage(int Resultado )
    {
        String Smensaje = "";
        if (Resultado==1) {
               Smensaje = "Usuario no existe";
        } 
        else if (Resultado==3) {
               Smensaje = "Password Incorrecto";
        }
        return Smensaje;
    }
    
    public static model.Usuario GetUser(String pNombreUsuario) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/evidencia?useSSL=false";
        String userName = "root";
        String password = "j$NT1hm$uCIf2aMU";
        model.Usuario U = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        
        Statement stmt = con.createStatement();
        
        String query = "select * from tblUsuario where NombreUsuario = '";
        query = query + pNombreUsuario + "'";
        
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next())
        {
         int pidUsuario = rs.getInt(1);
         String pNombreCompleto = rs.getString(2);
         pNombreUsuario = rs.getString(3);
         String pPwd = rs.getString(4);
         int pEdad = rs.getInt(5);
         String pSexo = rs.getString(6);
         int pEstatura = rs.getInt(7);         
         
         U = new model.Usuario(pidUsuario, pNombreCompleto, pNombreUsuario, pPwd, pEdad, pSexo, pEstatura);
        } 
    return U;        
    }
    
    public static int InsertUsuario(model.Usuario U) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/evidencia?useSSL=false";
        String userName = "root";
        String password = "j$NT1hm$uCIf2aMU";
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        
        Statement stmt = con.createStatement();
        
        String querymax = "select max(idUsuario) from tblusuario";
        ResultSet rsmax = stmt.executeQuery(querymax);
        
        int Max = 0;
        
        int rowCount = 0;
        while (rsmax.next()) {
               rowCount++;
               Max = Integer.valueOf(rsmax.getString(1));
          }
        Max = Max + 1;
        
        String queryIns = "Insert Into tblusuario ";
        queryIns = queryIns + "(IdUsuario,NombreCompleto,NombreUsuario,Pwd,Edad, Sexo, Estatura) values(" ;        
        queryIns = queryIns + Max + ",";
        queryIns = queryIns + "'" + U.getNombreCompleto() + "'" +  ",";
        queryIns = queryIns + "'" + U.getNombreUsuario()+ "'" +  ",";
        queryIns = queryIns + "'" + U.getPwd() + "'" + ",";        
        queryIns = queryIns + String.valueOf(U.getEdad()) + ",";
        queryIns = queryIns + "'" + String.valueOf(U.getSexo()) + "'" + ",";
        queryIns = queryIns + String.valueOf(U.getEstatura()) + ")";        
                       
        boolean resultado = stmt.execute(queryIns);
                     
        return Max;
    }
}
