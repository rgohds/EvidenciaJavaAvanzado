/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rlgar
 */
public class Medida {
    private int idMedida;
    private int idUsuario;
    private String Fecha;
    private int Peso;
    private float IMC;
    
    public Medida(int pidMedida,int pidUsuario, String pFecha, int pPeso,float pIMC)
            {
                this.idMedida = pidMedida;
                this.idUsuario = pidUsuario;
                this.Fecha = pFecha;
                this.Peso = pPeso;
                this.IMC = pIMC;
            }

    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }
}
