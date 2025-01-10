/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThisWarOfMine;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author migue
 */
public class Ubicacion {
    private ArrayList<Objeto> objetos;
    private int peligrosidad;
    private int nivel = 1;
    
    public Ubicacion(){
        Random ran = new Random();
        this.peligrosidad = ran.nextInt(1, this.nivel + 1);
    }
    
    public void incrementarNivel(){
        this.nivel++;
    }
    
    private ArrayList<Objeto> generarObjetos(){
        Random ran = new Random();
        ArrayList<Objeto> objetos = new ArrayList<>();
        //generamos la cantidad de objetos que apareceran
        int n = ran.nextInt(1,11);
        for (int i = 0; i < n; i++ ){
            
        }
        return objetos;
    }
    
}
