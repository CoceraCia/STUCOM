/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionempresa;

import java.util.*;

/**
 *
 * @author migue
 */
public class Empresa {

    public static ArrayList<Programador> listadoProgramadores = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca empleado recursos humanos");
        System.out.print("Nombre -> ");
        String nombre = sc.nextLine();
        System.out.print("Apellido -> ");
        String apellido = sc.nextLine();

        Empleado empleado = new Empleado(nombre, apellido);

        //Se usan los metodos getters y setters para mostrar que se ha creado correctamente el objeto Empleado
        System.out.println("Bienvenido/a " + empleado.getNombre() + " " + empleado.getApellido());

        menu();
    }

    public static void menu() {
        int n;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------MENU------------");
            System.out.println("1 - Introducir programador");
            System.out.println("2 - añadir perfil a un programador encontrado por DNI");
            System.out.println("3 - Mostrar datos de un programador por DNI");
            System.out.println("4 - Mostrar numeros de programadores de un perfil");
            System.out.println("5 - Mostrar programadores por experiencia");
            System.out.println("0 - Salir del programa");
            System.out.print("Selecciona una opcion -> ");
            n = sc.nextInt();
            switch (n) {
                case 1 ->
                    introducirProgramador();
                case 2 ->
                    añadirPerfil();
                case 3 ->
                    mostrarDatos();
                case 4 ->
                    mostrarNumProgramadores();
                case 5 ->
                    mostrarNivProgramadores();
            }
        } while (n != 0);
    }

    public static void introducirProgramador() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el nombre del programador -> ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca el dni del programador -> ");
        String dni = sc.nextLine();

        Empresa.listadoProgramadores.add(new Programador(nombre, dni));
    }

    public static void añadirPerfil() {
        Scanner sc = new Scanner(System.in);
        Programador pr;

        System.out.print("Introduzca el dni del programador al cual aplicar el perfil -> ");
        String dni = sc.nextLine();

        for (int i = 0; i < Empresa.listadoProgramadores.size(); i++) {
            if (Empresa.listadoProgramadores.get(i).getDni().equals(dni)) {
                pr = Empresa.listadoProgramadores.get(i);
                pr.setPerfil(crearPerfil());
                return;
            }
        }
        System.out.println("No encontrado");

    }

    public static void mostrarDatos() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca el dni del programador al cual aplicar el perfil -> ");
        String dni = sc.nextLine();
        Programador pr;
        for (int i = 0; i < Empresa.listadoProgramadores.size(); i++) {
            if (Empresa.listadoProgramadores.get(i).getDni().equals(dni)) {
                pr = Empresa.listadoProgramadores.get(i);
                System.out.println("Nombre programador -> " + pr.getNombre());
                System.out.println("DNI programador -> " + pr.getDni());
                for (int j = 0; j < pr.getPerfiles().length; j++){
                    Perfil[] perfiles = pr.getPerfiles();
                    if (perfiles[j] != null){
                        System.out.println("Perfil ->"+perfiles[j].getTipo());
                        System.out.println("Nivel ->"+perfiles[j].getNivel());
                        System.out.println("Certificado ->"+perfiles[j].getCertificacion());
                    }
                }
                return;
            }
        }
        System.out.println("No encontrado");
    }

    public static void mostrarNumProgramadores() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tipo de perfil-> ");
        String perfil = sc.nextLine();
        int cantidad = 0;
        for (int i = 0; i < Empresa.listadoProgramadores.size(); i++) {
            Programador pr = Empresa.listadoProgramadores.get(i);
            Perfil[] perfiles = pr.getPerfiles();
            for (int j = 0; j < perfiles.length; j++) {
                if (perfiles[j] != null) {
                    if (perfiles[j].getTipo().equals(perfil)) {
                        cantidad++;
                    }
                }

            }
        }
        System.out.println("Cantidad de programadores del perfil -> " + cantidad);
    }

    public static void mostrarNivProgramadores() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nivel de experiencia -> ");
        String nivel = sc.nextLine();
        int cantidad = 0;
        for (int i = 0; i < Empresa.listadoProgramadores.size(); i++) {
            Programador pr = Empresa.listadoProgramadores.get(i);
            Perfil[] perfiles = pr.getPerfiles();
            for (int j = 0; j < perfiles.length; j++) {
                if (perfiles[j] != null) {
                    if (perfiles[j].getNivel().equals(nivel)) {
                        cantidad++;
                    }
                }

            }
        }
        System.out.println("Cantidad de programadores" +nivel + " -> " + cantidad);
    }

    public static Perfil crearPerfil() {
        String tipo, nivel, x;
        boolean certificado = false, aceptado = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduzca el tipo de perfil (backend, frontend, fullstack) -> ");
            tipo = sc.nextLine();
            if (!tipo.equalsIgnoreCase("Backend") || !tipo.equalsIgnoreCase("frontend") || !tipo.equalsIgnoreCase("Fullstack")) {
                aceptado = false;
            }
            System.out.print("Introduzca el nivel del perfil (junior, mid, senior) ->");
            nivel = sc.nextLine();
            if (!nivel.equalsIgnoreCase("junior") || !nivel.equalsIgnoreCase("mid") || !nivel.equalsIgnoreCase("senior")) {
                aceptado = false;
            }
            System.out.print("Introduzca si tiene certificado (y, n)  ->");
            x = sc.nextLine();
            if (x.equalsIgnoreCase("y") || x.equalsIgnoreCase("n")) {
                certificado = (x.equalsIgnoreCase("y"));
                break;
            } else {
                aceptado = false;
            }
        } while (aceptado == false);

        return new Perfil(tipo, nivel, certificado);

    }
}
