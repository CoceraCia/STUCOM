/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author migue
 */
public class Estructura extends Carta{
    private final int escudo = 3;
    
    public Estructura(){
        this.setDefensa(this.getDefensa() * escudo);
    }

    public int getEscudo() {
        return this.escudo;
    }
    
    
}
