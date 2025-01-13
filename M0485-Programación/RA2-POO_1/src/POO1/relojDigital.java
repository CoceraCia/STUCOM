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
public class relojDigital {

    public static void main(String[] args) {
        int opc;
        int[] reloj = iniciarReloj();
        do {
            mostrarReloj(reloj);
            opc = menu();
            switch (opc) {
                case 1:
                    adelantarHora(reloj);
                    break;
                case 2:
                    retrasarHora(reloj);
                    break;
                case 3:
                    adelantarMinuto(reloj);
                    break;
                case 4:
                    retrasarMinuto(reloj);
                    break;
            }
        } while (opc != 0);
    }

    //Creamos el reloj
    public static int[] iniciarReloj() {
        int[] reloj = new int[4];
        return reloj;
    }

    //metodo para mostrar la hora actual del reloj
    public static void mostrarReloj(int[] clock) {
        System.out.println(clock[0] + "" + clock[1] + ":" + clock[2] + "" + clock[3]);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salir[0]");
        System.out.println("Incrementar Hora[1]");
        System.out.println("Reducir Hora[2]");
        System.out.println("Incrementar Minuto[3]");
        System.out.println("Reducir minuto[4]");
        int x = sc.nextInt();
        return x;
    }

    public static void adelantarHora(int[] clock) {
        if (clock[0] == 2 && clock[1] == 3) {
            clock[0] = 0;
            clock[1] = 0;
        } else if (clock[1] == 9) {
            clock[0]++;
            clock[1] = 0;
        } else {
            clock[1]++;
        }
    }

    public static void retrasarHora(int[] clock) {
        if (clock[0] == 0 && clock[1] == 0) {
            clock[0] = 2;
            clock[1] = 3;
        } else if (clock[1] == 0) {
            clock[0]--;
            clock[1] = 9;
        } else {
            clock[1]--;
        }
    }

    public static void adelantarMinuto(int[] clock) {
        if (clock[2] == 5 && clock[3] == 9) {
            clock[2] = 0;
            clock[3] = 0;
            adelantarHora(clock);
        } else if (clock[3] == 9) {
            clock[2]++;
            clock[3] = 0;
        } else {
            clock[3]++;
        }
    }

    public static void retrasarMinuto(int[] clock) {
        if (clock[2] == 0 && clock[3] == 0) {
            clock[2] = 5;
            clock[3] = 9;
            retrasarHora(clock);
        } else if (clock[3] == 0) {
            clock[2]--;
            clock[3] = 9;
        } else {
            clock[3]--;
        }
    }
}
