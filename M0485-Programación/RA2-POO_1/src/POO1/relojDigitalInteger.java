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
public class relojDigitalInteger {
    public static void main(String[] args) {
        int opc;
        ArrayList<Integer> reloj = iniciarReloj();
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
    public static ArrayList<Integer> iniciarReloj() {
        ArrayList<Integer> reloj = new ArrayList<>();
        reloj.add(0);
        reloj.add(0);
        reloj.add(0);
        reloj.add(0);
        return reloj;
    }

    //metodo para mostrar la hora actual del reloj
    public static void mostrarReloj(ArrayList<Integer> clock) {
        System.out.println(clock.get(0)+""+clock.get(1)+":"+clock.get(2)+""+clock.get(3));
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

    public static void adelantarHora(ArrayList<Integer> clock) {
        if (clock.get(0) == 2 && clock.get(1) == 3) {
            clock.set(0, 0);
            clock.set(1, 0);
        } else if (clock.get(1) == 9) {
            clock.set(0, clock.get(0)+1);
            clock.set(1, 0);
        } else {
            clock.set(1, clock.get(1)+1);
        }
    }

    public static void retrasarHora(ArrayList<Integer> clock) {
        if (clock.get(0) == 0 && clock.get(1) == 0) {
            clock.set(0, 2);
            clock.set(1, 3);
        } else if (clock.get(1) == 0) {
            clock.set(0, clock.get(0)-1);
            clock.set(1, 9);
        } else {
            clock.set(1, clock.get(1)-1);
        }
    }

    public static void adelantarMinuto(ArrayList<Integer> clock) {
        if (clock.get(2) == 5 && clock.get(3) == 9) {
            clock.set(2,0);
            clock.set(3,0);
            adelantarHora(clock);
        } else if (clock.get(3) == 9) {
            clock.set(2, clock.get(2)+1);
            clock.set(3,0);
        } else {
            clock.set(3, clock.get(3)+1);
        }
    }

    public static void retrasarMinuto(ArrayList<Integer> clock) {
        if (clock.get(2) == 0 && clock.get(3) == 0) {
            clock.set(2,5);
            clock.set(3,9);
            retrasarHora(clock);
        } else if (clock.get(3) == 0) {
            clock.set(2, clock.get(2)-1);
            clock.set(3,9);
        } else {
            clock.set(3,clock.get(3)-1);
        }
    }
}
