/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego;

import java.util.*;

/**
 *
 * @author migue
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Carta[] mazo = new Carta[6];
        genMazo(mazo);

        Jugador[] jugadores = new Jugador[2]; //almacenamos los dos jugadores
        Carta[][] cartas = new Carta[2][3]; //almacenamos las cartas de los dos jugadores
        for (int i = 0; i < jugadores.length; i++) {
            String nombre = "Jugador" + (i + 1);
            //Le damos 3 cartas aleatorias del mazo
            genCartas(cartas[i], mazo);
            jugadores[i] = new Jugador(nombre, cartas[i]);
        }

        comenzarPartida(jugadores[0], jugadores[1]);
        mostrarGanador(jugadores[0], jugadores[1]);

    }

    public static void genMazo(Carta[] mazo) {
        //Generamos el mazo
        for (int i = 0; i < mazo.length; i++) {
            if (i < 2) {
                mazo[i] = new Tropa();
            } else if (i < 4) {
                mazo[i] = new Estructura();
            } else {
                mazo[i] = new Hechizo();
            }
        }
    }

    public static void genCartas(Carta[] cartas, Carta[] mazo) {
        Random ran = new Random();
        for (int j = 0; j < 3; j++) {
            cartas[j] = mazo[ran.nextInt(0, 6)];
        }
    }

    public static void comenzarPartida(Jugador jugador1, Jugador jugador2) {
        Jugador[] jugador = new Jugador[]{jugador1, jugador2};

        //el i representa el inicio del jugador 1 por eso empieza en 0 e incrementa, ya que la segunda vez que se ejecute el video pasara a ser el jug2
        //en cambio la j se inicializa en 1 y se restra, así del jugador2 pasa al 1
        for (int i = 0, j = 1; i < 2; i++, j--) {
            System.out.println(jugador[i].getNombre() + " ataca con su "+(i+1)+" carta con valor: " + jugador[i].getCartas()[0].getAtaque());
            System.out.println(jugador[j].getNombre() + " defiende con su "+(i+1)+" carta con valor: " + jugador[j].getCartas()[0].getDefensa());
            int diferencia = jugador[i].getCartas()[0].getAtaque() - jugador[j].getCartas()[0].getDefensa();
            if (diferencia > 0) {
                jugador[j].setVida(jugador[j].getVida() - diferencia);
                System.out.println(jugador[j].getNombre() + " pierde " + diferencia + " de vida");
            } else {
                System.out.println(jugador[j].getNombre() + " no pierde vida, ataque anulado");
            }
        }
    }

    public static void mostrarGanador(Jugador jugador1, Jugador jugador2) {
        System.out.println("Vida Jugador 1 : " + jugador1.getVida());
        System.out.println("Vida Jugador 2 : " + jugador2.getVida());
        if (jugador1.getVida() == jugador2.getVida()) {
            System.out.println("Ha sido un empateeee!!");
        } else {
            String ganador = (jugador1.getVida() > jugador2.getVida()) ? "Ganador jugador 1!!!" : "Ganador jugador 2!!!";
            System.out.println(ganador);
        }
    }
}
