/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author migue
 */
public class Hechizo extends Carta {

    private final int magia = 4;

    public Hechizo() {
        this.setAtaque(this.getAtaque() + this.magia);
    }

    public int getMagia() {
        return this.magia;
    }

}
