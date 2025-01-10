/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThisWarOfMine;

/**
 *
 * @author migue
 */
public class Objeto {
    private String tipo;
    private int cantidad;
    public Objeto(String tipo, int cantidad){
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    @Override
    public String toString(){
        return "Objeto -> "+this.tipo+" ("+this.cantidad+")";
    }
}
