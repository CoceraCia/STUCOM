/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempresa;

/**
 *
 * @author migue
 */
public class Empleado {
    private String nombre;
    private String apellido;
    
    public Empleado(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
}
