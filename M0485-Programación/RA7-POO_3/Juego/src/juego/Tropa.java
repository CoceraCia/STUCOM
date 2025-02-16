/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author migue
 */
public class Tropa extends Carta {

    private final int fuerza = 2;

    public Tropa() {
        this.setAtaque(fuerza * this.getAtaque());
    }

    public int getFuerza() {
        return this.fuerza;
    }
}
