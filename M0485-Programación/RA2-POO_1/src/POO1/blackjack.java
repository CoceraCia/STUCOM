/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO1;

import java.util.*;

/**
 *
 * @author migue
 */
public class blackjack {

    public static void main(String[] args) {
        int puntuacionMaquina;
        int puntuacionJugador;
        boolean otraPartida;
        do {
            puntuacionJugador = cartasJugador();
            puntuacionMaquina = cartasMaquina();
            mostrarGanador(puntuacionJugador, puntuacionMaquina);
            otraPartida = jugarOtraPartida();
        } while (otraPartida);
        System.out.println("Hasta Luego!");
    }

    public static int cartasJugador() {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);
        int puntuacion = 0;
        boolean plantarse = false;
        int n = ran.nextInt(1, 11);
        puntuacion += n;
        System.out.println("Carta generada-->" + n);
        System.out.println("Tu puntuacion es de " + puntuacion);
        while (puntuacion <= 21 && plantarse == false) {
            System.out.print("Introduce un 1 para pedir otro numero, introduce un 0 para plantarte-->");
            while (true) {
                int x = sc.nextInt();
                if (x == 0) {
                    plantarse = true;
                    break;
                } else if (x != 0 && x != 1) {
                    System.out.print("Valor incorrecto, Introduzcalo de nuevo-->");
                } else {
                    break;
                }
            }
            int num = ran.nextInt(1, 11);
            puntuacion += num;
            System.out.println("Carta generada-->" + num);
            System.out.println("Tu puntuacion es de " + puntuacion);
        }
        return puntuacion;
    }

    public static int cartasMaquina() {
        Random ran = new Random();
        int puntuacion = 0;
        while (puntuacion <= 16) {
            int num = ran.nextInt(1, 11);
            puntuacion += num;
        }
        return puntuacion;
    }

    public static void mostrarGanador(int jugador, int maquina) {
        System.out.println("-----------------------------------------------RESULTADOS------------------------------");
        if (jugador <= 21 && maquina <= 21) {
            if ((21 - jugador) == (21 - maquina)) {
                System.out.println("Ha sido un empateee!!");
                System.out.println("Puntuacion jugador-->" + jugador);
                System.out.println("Puntuacion maquina-->" + maquina);
            } else if ((21 - jugador) < (21 - maquina)) {
                System.out.println("El ganador ha sido el jugador!!");
                System.out.println("Puntuacion jugador-->" + jugador);
                System.out.println("Puntuacion maquina-->" + maquina);
            } else {
                System.out.println("El ganador ha sido la maquina!!");
                System.out.println("Puntuacion jugador-->" + jugador);
                System.out.println("Puntuacion maquina-->" + maquina);
            }
        } else if (jugador > 21 && maquina > 21) {
            System.out.println("Ninguno ha sido ganador!!");
            System.out.println("Puntuacion jugador-->" + jugador);
            System.out.println("Puntuacion maquina-->" + maquina);
        } else if (jugador > 21) {
            System.out.println("El ganador ha sido la maquina!!");
            System.out.println("Puntuacion jugador-->" + jugador);
            System.out.println("Puntuacion maquina-->" + maquina);
        } else {
            System.out.println("El ganador ha sido el jugador!!");
            System.out.println("Puntuacion jugador-->" + jugador);
            System.out.println("Puntuacion maquina-->" + maquina);
        }
    }

    public static boolean jugarOtraPartida() {
        Scanner sc = new Scanner(System.in);
        boolean otra;
        System.out.print("Desea jugar otra partida?\nIntroduzca \"Si\" para jugar otra partida, introduzca \"No\" para cerrar la partida-->");
        while (true) {
            String x = sc.nextLine();
            if (x.toLowerCase().equals("si")) {
                System.out.println("-----------------------------NUEVA PARTIDA----------------");
                otra = true;
                break;
            } else if (x.toLowerCase().equals("no")) {
                otra = false;
                break;
            } else {
                System.out.println("Valor incorrecto");
            }
        }
        return otra;
    }
}
