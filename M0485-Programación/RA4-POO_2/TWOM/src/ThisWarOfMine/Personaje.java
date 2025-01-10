/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThisWarOfMine;
import java.util.ArrayList;
/**
 *
 * @author migue
 */
public class Personaje {
    private String nombre;
    private int salud = 10;
    private int hambre = 1;
    private int sueño = 1;
    private String habilidad;
    private ArrayList<Objeto> objetos;
    
    public Personaje(String nombre, ArrayList<Objeto> objetos){
        //Con estos metodos nos aseguramos que los nombres salgan bien formateados
        this.nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        this.objetos = objetos;
        switch (nombre){
            case "Arica"->this.habilidad = "SIGILO";
            case "Bruno"->this.habilidad = "COCINERO";
            case "Katia"->this.habilidad = "ELOCUENDIA";
            case "Pavel"->this.habilidad = "RAPIDEZ";
        }
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getSalud(){
        return this.salud;
    }
    
    public int getHambre(){
        return this.hambre;
    }
    
    public int getSueño(){
        return this.sueño;
    }
}
