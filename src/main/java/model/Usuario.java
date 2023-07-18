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
    private int Edad;
    private char Sexo;
    private int Estatura;    
    
    public Usuario(int pidUsuario, String pNombreCompleto,
            String pNombreUsuario, int pEdad, char pSexo,
            int pEstatura) {
        this.idUsuario = pidUsuario;
        this.NombreCompleto = pNombreCompleto;
        this.NombreUsuario = pNombreUsuario;
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

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public int getEstatura() {
        return Estatura;
    }

    public void setEstatura(int Estatura) {
        this.Estatura = Estatura;
    }
            
}
