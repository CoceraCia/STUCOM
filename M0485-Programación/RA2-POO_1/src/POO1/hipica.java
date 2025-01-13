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
public class hipica {

    public static void main(String[] args) {
        // Inicialización de variables
        int turno = 0;
        char[][] hipodromo;
        int participantes = cantidadParticipantes(); // Llama a una función para obtener la cantidad de participantes
        int apuesta = elegirCaballo(participantes); // Llama a una función para que el usuario elija un caballo

        // Crea un arreglo bidimensional para representar el hipódromo
        hipodromo = new char[participantes][50];
        // Inicializa el hipódromo
        iniciarHipodromo(hipodromo);

        // Bucle principal: simula la carrera
        while (avanzarCaballo(hipodromo, turno) < 50) {
            // Incrementa el turno, alternando entre caballos
            if (turno < participantes - 1) {
                turno++;
            } else {
                turno = 0;
            }
        }

        // Verifica si el jugador ganó o perdió
        if (apuesta == turno) {
            System.out.println("ganaste, caballo ganador " + turno);
        } else {
            System.out.println("perdiste, [" + apuesta + "] gana el caballo " + turno);
        }
    }

    public static void iniciarHipodromo(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = '.';
            }
        }
    }

    public static void mostrarHipodromo(char[][] hipodromo) {
        for (int i = 0; i < hipodromo.length; i++) {
            System.out.print("[" + i + "]");
            for (int j = 0; j < hipodromo[i].length; j++) {
                System.out.print(hipodromo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int cantidadParticipantes() {
        Scanner sc = new Scanner(System.in);
        int part;
        while (true) {
            System.out.print("Introduce el numero de jinetes (min 2 y max 8) : ");
            part = sc.nextInt();
            if (part > 1 && part < 9) {
                return part;
            }
        }
    }

    public static int elegirCaballo(int participantes) {
        Scanner sc = new Scanner(System.in);
        int caballo;
        while (true) {
            System.out.print("Apuesta que caballo ganará (caballos disponibles desde 0 a " + (participantes - 1) + ") : ");
            caballo = sc.nextInt();
            if (caballo >= 0 && caballo <= participantes) {
                return caballo;
            }
        }
    }

    public static int avanzarCaballo(char[][] hipodromo, int turno) {
        //generamos un numero random que actuara como dado
        Random ran = new Random();
        int x = ran.nextInt(1, 7);
        System.out.println("Caballo " + turno + " --> Dado = " + x);
        //con la funcion comprobaremos en que posicion se encuentra el caballo
        int pos = comprobarPosicionCaballo(hipodromo, turno);
        
        //Comenzamos a rellenar las posiciones
        if ((pos + x) >= 50) {  //si las posiciones superan el valor maximo de la lista, limitaremos el conteo hasta 50 para evitar un Index Out Of Bounds
            for (int i = pos; i < 50; i++) {
                hipodromo[turno][i] = '#';
            }
        } else {
            for (int i = pos; i < (pos + x); i++) {
                hipodromo[turno][i] = '#';
            }
        }

        mostrarHipodromo(hipodromo);
        return comprobarPosicionCaballo(hipodromo, turno);
    }

    public static int comprobarPosicionCaballo(char[][] hipodromo, int turno) {
        int i;
        for (i = 0; i < 50; i++) {
            if (hipodromo[turno][i] == '.') {
                break;
            }
        }
        return i;
    }
}
