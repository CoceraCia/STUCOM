/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cocera.miguel;

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Bank {

    public static void main(String[] args) {
        //Inicializacion de array para añadir cuentas
        Account[] accounts = new Account[2];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = createAccount(i);
        }

        //mostramos el menu y se procesara la opcion elegida
        menu(accounts);
    }

    //menu
    public static void menu(Account[] accounts) {
        int opcion;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu Principal");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Sacar dinero");
            System.out.println("4. Realizar transferencia");
            System.out.println("5. Salir");
            while (true) {
                System.out.print("Ingrese una opcion: ");
                opcion = sc.nextInt();
                if (opcion > 0 && opcion <= 5) {
                    break;
                }
            }

            switch (opcion) {
                case 1 -> {
                    consultarSaldo(accounts);
                    break;
                }
                case 2 -> {
                    ingresarDinero(accounts);
                    break;
                }
                case 3 -> {
                    sacarDinero(accounts);
                    break;
                }
                case 4 -> {
                    realizarTransferencia(accounts);
                    break;
                }
                default -> {
                    break;
                }
            }
        } while (opcion != 5);

    }

    //Funcion que crea cuentas
    public static Account createAccount(int number) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del titular de la cuenta " + number + ": ");
        String holder = sc.nextLine().strip();
        System.out.print("Ingrese el saldo inicial de la cuenta " + number + ": ");
        double balance = sc.nextDouble();

        return new Account(number, balance, holder);
    }

    //Consultamos el saldo
    public static void consultarSaldo(Account[] accounts) {
        Scanner sc = new Scanner(System.in);
        String holder;
       
        //Comprobamos que exista el titular
        while (true) {
            System.out.print("Nombre del titular--> ");
            holder = sc.nextLine();
            if (holderExists(accounts, holder)) {
                break;
            }
        }
        
        //Buscamos la cuenta para consultar el dinero
        int index = obtainIndex(accounts, holder);
        System.out.println("El saldo de la cuenta es:" + accounts[index].getBalance());
    }
    
    //Ingresamos dinero
    public static void ingresarDinero(Account[] accounts) {
        Scanner sc = new Scanner(System.in);
        String holder;

        //Comprobamos que exista el titular
        while (true) {
            System.out.print("Nombre del titular--> ");
            holder = sc.nextLine();
            if (holderExists(accounts, holder)) {
                break;
            }
        }

        //Pedimos el dinero a ingresar
        System.out.print("Dinero a ingresar--> ");
        int money = sc.nextInt();

        //Buscamos la cuenta para añadir el dinero
        int index = obtainIndex(accounts, holder);
        accounts[index].setBalance(accounts[index].getBalance() + money);
        System.out.println("El dinero ha sido ingresado correctamente");
    }
    
    //Sacamos dinero
    public static void sacarDinero(Account[] accounts) {
        Scanner sc = new Scanner(System.in);
        String holder;

        //Comprobamos que exista el titular
        while (true) {
            System.out.print("Nombre del titular--> ");
            holder = sc.nextLine();
            if (holderExists(accounts, holder)) {
                break;
            }
        }
        
        double money;
        //Buscamos la cuenta para retirar el dinero
        int index = obtainIndex(accounts, holder);
        while (true){
            //Pedimos el dinero a retirar
            System.out.print("Dinero a retirar--> ");
            money = sc.nextInt();
            if (money >= 0 && accounts[index].getBalance() - money >= 0){
                break;
            }
        }
        accounts[index].setBalance(accounts[index].getBalance() - money);
        System.out.println("El dinero ha sido retirado correctamente");
    }
    
    //Realizamos Transferencia
    public static void realizarTransferencia(Account[] accounts){
        Scanner sc = new Scanner(System.in);
        
        //pedimos el holder origen
        String origen;
        while (true){
            System.out.print("Nombre del titular origen --> ");
            origen = sc.nextLine();
            if (holderExists(accounts, origen)){
                break;
            }
        }
        Account acOrig = accounts[obtainIndex(accounts, origen)];
        
        //pedimos el holder destino
        String destino;
        while (true){
            System.out.print("Nombre del titular destino --> ");
            destino = sc.nextLine();
            if (holderExists(accounts, destino)){
                break;
            }
        }
        Account acDest = accounts[obtainIndex(accounts, destino)];
        
        while (true){
            System.out.print("Dinero a transferir-->");
            double money = sc.nextDouble();
            if (money >= 0 && money <= acOrig.getBalance()){
                //Sumamos el dinero a la cuenta destino
                acDest.setBalance(money + acDest.getBalance());
                //Quitamos el dinero de la cuenta origen
                acOrig.setBalance(money-acOrig.getBalance());
                System.out.println("Transferencia realizada");
                break;
            }
        }
    }
    
    
    //Metodos externos a los que se piden en la actividad, los uso como herramientas
    
    public static boolean holderExists(Account[] accounts, String holder) {
        for (Account ac : accounts) {
            if (ac.getHolder().toLowerCase().contains(holder.toLowerCase().strip())) {
                return true;
            }
        }
        return false;
    }

    public static int obtainIndex(Account[] accounts, String holder){
        //si existe devolvemos su indice, en caso de que no exista devolvemos un -1
        for (int i = 0; i < accounts.length; i++){
             if (accounts[i].getHolder().toLowerCase().equals(holder.toLowerCase().strip())) {
                return i;
            }
        }
        return -1;
    }
}
