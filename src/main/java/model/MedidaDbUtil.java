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
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author rlgar
 */
public class MedidaDbUtil {
    
    public static List<model.Medida> getMedidas(String IdUsuario) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/evidencia?useSSL=false";
        String userName = "root";
        String password = "j$NT1hm$uCIf2aMU";
        
        ArrayList<model.Medida> Medidas = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        
        Statement stmt = con.createStatement();
        
        String query = "select * from tblmedida where idUsuario = " + IdUsuario;
        query = query + " order by fecha";
        
        
        ResultSet rs = stmt.executeQuery(query);
        
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

    public static boolean InsertMedida(model.Usuario U, int peso) throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/evidencia?useSSL=false";
        String userName = "root";
        String password = "j$NT1hm$uCIf2aMU";
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,userName,password);
        
        Statement stmt = con.createStatement();
        
        String querymax = "select max(idMedida) from tblmedida";
        ResultSet rsmax = stmt.executeQuery(querymax);
        
        int Max = 0;
        
        int rowCount = 0;
        while (rsmax.next()) {
               rowCount++;
               Max = Integer.valueOf(rsmax.getString(1));
          }
        Max = Max + 1;
        
        String queryIns = "Insert Into tblmedida ";
        queryIns = queryIns + "(IdMedida,idUsuario,Fecha,Peso,IMC) values(" ;        
        queryIns = queryIns + Max + ",";
        queryIns = queryIns + String.valueOf(U.getIdUsuario()) + ",";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();                
        queryIns = queryIns + "'" + dtf.format(now) + "',";
        queryIns = queryIns + String.valueOf(peso) + ",";
        queryIns = queryIns + U.CalcIMC(peso) + ")";      
        
                       
        boolean resultado = stmt.execute(queryIns);
                     
        return !resultado;        
    }    
        
}
