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

public class pila {
    public static void main(String[] args) {
        int array[] = new int[10];
        Arrays.fill(array, -1);
        int opc;

        do {
            opc = menu();
            switch (opc) {
                case 1:
                    apilar(array);
                    break;
                case 2:
                    desapilar(array);
                    break;
                case 3:
                    mostrarPrimero(array);
                    break;
                case 4:
                    mostrarUltimo(array);
                    break;
            }
        } while (opc != 0);
    }
    
    public static int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Presiona [0]  para salir");
        System.out.println("Presiona [1] para apilar");
        System.out.println("Presiona [2] para desapilar ");
        System.out.println("Presiona [3] para mostrarPrimero");
        System.out.println("Presiona [4] para mostrarUltimor");
        
        System.out.print("Que desea hacer?");
         int x = sc.nextInt();
         return x;
    }
    
    public static int[] apilar(int[] array){
        Scanner sc = new Scanner(System.in);
        if (comprobarLleno(array)){
            System.out.println("La lista esta llena, no es posible realizar la accion");
        } else{
            int pos = encontrarPosicionVacia(array);
            System.out.print("Introduzca el numero a añadir-->");
            array[pos] = sc.nextInt();
        }
        return array;
    }
    public static int[] desapilar(int[] array){
        if (comprobarVacio(array) == true){
            System.out.println("No es posible realizar la accion, pila llena");
        } else if (comprobarLleno(array)){
            array[array.length-1] = -1;
        } else {
            int pos = encontrarPosicionVacia(array);
            array[pos-1] = -1; 
        }
        return array;
    }
    public static int[] mostrarPrimero(int[] array){
        if (comprobarVacio(array) == true){
            System.out.println("La pila esta vacia");
        } else if(comprobarLleno(array) == true){
            System.out.println("El primero en salir sera-->"+array[array.length-1]);
        }else {
            int pos = encontrarPosicionVacia(array);
            System.out.println("El primero en salir sera-->"+array[pos-1]);
        }
        return array;
    }
    public static int[] mostrarUltimo(int[] array){
        if (comprobarVacio(array) == true){
            System.out.println("La pila esta vacia");
        } else {
            System.out.println("El ultimo en salir sera-->"+array[0]);
        }
        return array;
    }

    public static boolean comprobarLleno(int[] array){
        boolean full = true;
        for(int i = 0; i<array.length; i++){
            if (array[i] == -1){
                full = false;
            }
        }
        return full;
    }
    public static boolean comprobarVacio(int[] array){
        boolean vacio = true;
        for(int i = 0; i<array.length; i++){
            if (array[i] != -1){
                vacio = false;
            }
        }
        return vacio;
    }
    
    public static int encontrarPosicionVacia(int[] array){
        // si esta lleno dara un error, así nos aseguramos que este escrito bien el codigo
        int x = array.length+ 1;
        for (int i = 0; i < array.length; i++){
            if (array[i] == -1){
                x = i;
                break;
            }
        }
        return x;
    }
}
