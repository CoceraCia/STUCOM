/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempresa;

/**
 *
 * @author migue
 */
public class Perfil {

    private String tipo; //backend, frontend, fullstack
    private String nivel; //junior, mid, senior
    private boolean certificacion;

    public Perfil(String tipo, String nivel, boolean certificacion) {
        this.tipo = tipo;
        this.nivel = nivel;
        this.certificacion = certificacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setCertificacion(boolean certificacion) {
        this.certificacion = certificacion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getNivel() {
        return this.nivel;
    }

    public boolean getCertificacion() {
        return this.certificacion;
    }

}
