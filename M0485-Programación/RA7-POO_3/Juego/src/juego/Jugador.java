/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

/**
 *
 * @author migue
 */
public class Jugador implements Batalla {

    private String nombre;
    private int vida = 100;
    private Carta[] cartas;

    public Jugador(String nombre, Carta[] cartas) {
        this.nombre = nombre;
        this.cartas = cartas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Carta[] getCartas() {
        return this.cartas;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    @Override
    public int atacar(Carta carta) {
        return carta.getAtaque();
    }

    @Override
    public int defender(Carta carta) {
        return carta.getDefensa();
    }

}
