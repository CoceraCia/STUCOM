/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author migue
 */
public class Carta {
    private int ataque = 2;
    private int defensa = 2;
    
    public Carta (){
    }
    
    public int getAtaque(){
        return this.ataque;
    }
    
    public int getDefensa(){
        return this.defensa;
    }
    
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
}
