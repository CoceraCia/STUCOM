/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appliga;

import java.util.*;

/**
 *
 * @author migue
 */
public class AppLiga {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidad;

        while (true) {
            System.out.print("Jugadores a crear--> ");
            cantidad = sc.nextInt();
            if (cantidad > 0) {
                break;
            }
        }

        Jugador[] jugadores = new Jugador[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.println("------------------- JUGADOR " + i + " -------------------");
            Jugador jugador = crearJugador();
            jugadores[i] = jugador;
            System.out.println("Jugador " + i + " creado");
        }

        int opcion = 0;
        do {
            menu();
            System.out.print("Introduzca la opcion a realizar --> ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 ->
                    consultarJugador(jugadores);
                case 2 ->
                    puntosTotales(jugadores);
                case 3 ->
                    anotarPuntos(jugadores);
                case 4 ->
                    maximoAnotador(jugadores);
            }
        } while (opcion != 5);
    }

    public static void menu() {
        System.out.println("--------------------------MENU-----------------------------");
        System.out.println("1 - Consultar jugador");
        System.out.println("2 - Puntos totales de jugador");
        System.out.println("3 - Anotar Puntos");
        System.out.println("4 - Calcular Maximo Anotador");
        System.out.println("5 - Salir");
    }

    public static Jugador crearJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("edad: ");
        int edad = sc.nextInt();
        System.out.print("dorsal: ");
        int dorsal = sc.nextInt();
        //Confirmamos que juegue algun partido
        int x;
        while (true) {
            System.out.print("Partidos a jugar: ");
            x = sc.nextInt();
            if (x > 0) {
                break;
            }
        }
        int[] partidos = new int[x];
        for (int i = 0; i < x; i++) {
            System.out.print("\t- Puntos partido " + i + ": ");
            int puntos = sc.nextInt();
            partidos[i] = puntos;
        }

        return new Jugador(nombre, edad, dorsal, partidos);
    }

    public static void consultarJugador(Jugador[] jugadores) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Introduzca el jugador a mostrar--> ");
            String jugador = sc.nextLine();

            for (int i = 0; i < jugadores.length; i++) {
                if (jugador.equalsIgnoreCase(jugadores[i].getNombre())) {
                    jugadores[i].mostrarInformacion();
                    esperarRespuesta();
                    return;
                }
            }

            System.out.println("Jugador no encontrado");
        }
    }

    public static void puntosTotales(Jugador[] jugadores) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Introduzca el jugador--> ");
            String jugador = sc.nextLine();

            for (int i = 0; i < jugadores.length; i++) {
                if (jugador.equalsIgnoreCase(jugadores[i].getNombre())) {
                    System.out.println("PUNTOS ANOTADOS-->" + jugadores[i].getPuntosTotales());
                    esperarRespuesta();
                    return;
                }
            }

            System.out.println("Jugador no encontrado");
        }
    }

    public static void anotarPuntos(Jugador[] jugadores) {
        Scanner sc = new Scanner(System.in);
        int puntos = 0, partido = 0, jugador = 0;

        //Bucle para confirmar que el jugador introducido existe
        while (true) {
            System.out.print("Introduzca el jugador--> ");
            String nombre = sc.nextLine();
            boolean encontrado = false;
            for (int i = 0; i < jugadores.length; i++) {
                if (nombre.equalsIgnoreCase(jugadores[i].getNombre())) {
                    jugador = i;
                    encontrado = true;
                    break;
                }

            }
            if (encontrado == true) {
                break;
            } else {
                System.out.println("Jugador no encontrado");
            }
        }

        //Bucle para confirmar que el partido jugado y los puntos anotados son validos
        while (true) {
            System.out.print("Partido jugado?--> ");
            partido = sc.nextInt();
            //Si partido es mayor a 0 y menor a la longitud de partidos jugados
            if (partido >= 0 && partido < jugadores[jugador].getPuntosAnotados().length) {
                break;
            } else {
                System.out.print("-ERROR- El partido no existe. Partidos existentes -> ");
                for (int i = 0; i < jugadores[jugador].getPuntosAnotados().length; i++) {
                    //Creamos operacion ternaria para quitarnos la coma en caso de que sea el primer partido
                    String p = (i == 0) ? "" + i : "," + i;
                    System.out.print(p);
                }
                System.out.println();
            }
        }

        //Bucle para confirmar que los numeros no son negativos
        while (true) {
            System.out.print("Puntos anotados?--> ");
            puntos = sc.nextInt();
            if (puntos >= 0) {
                break;
            } else {
                System.out.println("-ERROR- valor incorrecto");
            }
        }

        //Queremos sumar los puntos a los ya añadidos para ello creo un array en el cual obtendremos los puntos del jugador
        int[] puntosBase = jugadores[jugador].getPuntosAnotados();
        jugadores[jugador].setPuntos(puntosBase[partido] + puntos, partido);
        System.out.println("Puntos anotados");
        esperarRespuesta();
    }

    public static void maximoAnotador(Jugador[] jugadores) {
        int mvp = 0;
        for (int i = 1; i < jugadores.length; i++) {
            if (jugadores[mvp].getPuntosTotales() < jugadores[i].getPuntosTotales()) {
                mvp = i;
            }
        }
        System.out.println("El maximo anotador ha sido --> " + jugadores[mvp].getNombre());
        esperarRespuesta();
    }

    public static void esperarRespuesta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("PRESIONE ENTER PARA CONTINUAR");
        sc.nextLine();
    }
}
