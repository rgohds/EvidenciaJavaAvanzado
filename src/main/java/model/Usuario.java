/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rlgar
 */
public class Usuario {
    private int idUsuario;
    private String NombreCompleto;
    private String NombreUsuario;
    private String Pwd;
    private int Edad;
    private String Sexo;
    private int Estatura;    
    
    public Usuario(int pidUsuario, String pNombreCompleto,
            String pNombreUsuario, String pPwd, int pEdad, String pSexo,
            int pEstatura) {
        this.idUsuario = pidUsuario;
        this.NombreCompleto = pNombreCompleto;
        this.NombreUsuario = pNombreUsuario;
        this.Pwd = pPwd;
        this.Edad = pEdad;
        this.Sexo = pSexo;
        this.Estatura = pEstatura;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
    
    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public int getEstatura() {
        return Estatura;
    }

    public void setEstatura(int Estatura) {
        this.Estatura = Estatura;
    }
    
    public float CalcIMC(int peso) {
        return (float) peso / (float) (((float) this.Estatura/100) * ((float)this.Estatura/100));
    }
    
    public static String ValidaDatosUsuario(int pEdad, int pEstatura, String NombreUsuario, String Pwd )
    {
        String Smensaje = "";
        if (NombreUsuario.equals("")) {
               Smensaje = "Introduzca un nombre de usuario";
        } else if (Pwd.equals("") ) {
               Smensaje = "Introduzca un password";
        }        
        else if (pEdad < 15 ) {
               Smensaje = "La edad minima es de 15 años";
        } 
        else if (pEstatura < 100 ) {
               Smensaje = "La estatura minima son 100 cm";
        } else if (pEstatura > 250 ) {
               Smensaje = "La estatura maxima son 250 cm";
        }
        return Smensaje;
    }
            
}
