/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package appliga;

/**
 *
 * @author migue
 */
public class Jugador {
    private String nombre;
    private int edad;
    private int dorsal;
    private int[] puntosAnotados;
    
    
    public Jugador(String nombre, int edad, int dorsal, int[] puntosAnotados){
        this.nombre = nombre;
        this.edad = edad;
        this.dorsal = dorsal;
        this.puntosAnotados = puntosAnotados;
    }
    
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    
    public int getDorsal(){
        return this.dorsal;
    }
    public void setDorsal(int dorsal){
        this.dorsal = dorsal;
    }
    
    
    public int[] getPuntosAnotados(){
        return this.puntosAnotados;
    }
    public void setPuntosAnotados(int[] puntosAnotados){
        this.puntosAnotados = puntosAnotados;
    }
    
    public int getPuntosTotales(){
        int puntos = 0;
        for (int i = 0; i < puntosAnotados.length; i++){
            puntos += puntosAnotados[i];
        }
        return puntos;
    }
    
    public void setPuntos(int puntos, int pos){
        if (pos < puntosAnotados.length && pos >= 0){
            puntosAnotados[pos] = puntos;
        } else {
            System.out.println("Posicion fuera del rango");
        }
    }
    
    public void mostrarInformacion(){
        System.out.println("INFORMACION JUGADOR:");
        System.out.println("\tNombre: "+nombre);
        System.out.println("\tEdad: "+edad);
        System.out.println("\tDorsal: "+dorsal);
        System.out.println("\tPuntos totales: "+ getPuntosTotales());
        for (int i = 0; i < puntosAnotados.length; i++){
            System.out.println("\t\t- Partido "+i+"--> "+puntosAnotados[i]);
        }
    }
    
    

}
