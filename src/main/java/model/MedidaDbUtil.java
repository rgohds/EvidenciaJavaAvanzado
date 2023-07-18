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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rlgar
 */
public class MedidaDbUtil {
    
    public static List<model.Medida> getMedidas() throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/evidencia?useSSL=false";
        String userName = "root";
        String password = "j$NT1hm$uCIf2aMU";
        
        ArrayList<model.Medida> Medidas = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        
        Statement stmt = con.createStatement();
        
        ResultSet rs = stmt.executeQuery("select * from tblmedida");
        
        while (rs.next())
        {
         int pidMedida = rs.getInt(1);
         int pidUsuario = rs.getInt(2);
         String pFecha = rs.getString(3);
         int pPeso = rs.getInt(4);
         float pIMC = rs.getFloat(5); 
         model.Medida m = new model.Medida(pidMedida,pidUsuario,pFecha,pPeso,pIMC);
         Medidas.add(m);         
        }       
        return Medidas;        
    }
    
}
