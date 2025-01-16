package ThisWarOfMine;

import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author migue
 */
public class ThisWarOfMine {

    /**
     * @param args the command line arguments
     */
    public static Casa casa = new Casa(true, new ArrayList<>());

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        ArrayList<Personaje> personajes = generateCharacters();
        ArrayList<Personaje> jugadores = getCharacters(personajes);

        nuevaPartida(jugadores);
    }

    public static ArrayList<Personaje> generateCharacters() {
        ArrayList<Personaje> personajes = new ArrayList<>();
        String[] nombres = {"Arica", "Bruno", "Katia", "Pavel"};
        for (int i = 0; i < 4; i++) {
            personajes.add(new Personaje(nombres[i], new ArrayList<>()));
        }
        return personajes;
    }

    public static ArrayList<Personaje> getCharacters(ArrayList<Personaje> personajes) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personaje> jugadores = new ArrayList<>();
        System.out.println("--------------------PERSONAJES------------------");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println("\t" + i + " - " + personajes.get(i).getNombre() + " | Habilidad -> " + personajes.get(i).getHabilidad());
        }
        int numJugadores;
        while (true) {
            System.out.print("Cuantos jugadores van a jugar? min:1 max:4 -->");
            numJugadores = sc.nextInt();
            if (numJugadores > 0 && numJugadores <= 4) {
                break;
            }
        }
        for (int i = 0; i < numJugadores; i++) {
            int personaje;
            while (true) {
                System.out.print("Jugador " + (i + 1) + " escoja un personaje (Introduzca el indice) --> ");
                personaje = sc.nextInt();
                if (personaje >= 0 && personaje < 4) {
                    break;
                }
            }
            jugadores.add(personajes.get(personaje));
        }
        return jugadores;
    }

    public static void nuevaPartida(ArrayList<Personaje> jugadores) {
        //inicializamos una variable turno
        int turno = 0;
        int nivel = 1;
        while (checkSalud(jugadores)) {
            //inicializamos el personaje al cual le toca este turno
            Personaje jugador = jugadores.get(turno);
            //Aqui inicia la partida
            mostrarObjetos();
            Ubicacion ubi = generateUbicacion(nivel);
            ArrayList<Personaje> rolPers = escogerRoles(jugadores);

            //operacion ternaria para devolver 0 si ha llegado al ultimo turno en caso de que no aumentamos el turno
            turno = (turno == (jugadores.size() - 1)) ? 0 : turno++;
            nivel++;
        }
    }

    public static boolean checkSalud(ArrayList<Personaje> jugadores) {
        for (Personaje jugador : jugadores) {
            if (jugador.getSalud() == 0) {
                return false;
            }
        }
        return true;
    }

    public static void mostrarObjetos() {
        System.out.println("----------OBJETOS DISPONIBLES EN CASA------");
        for (Objeto obj : casa.getObjetos()) {
            obj.toString();
        }
    }

    public static Ubicacion generateUbicacion(int nivel) {
        return new Ubicacion(nivel);
    }

    public static ArrayList<Personaje> escogerRoles(ArrayList<Personaje> jugadores) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personaje> rolesPers = new ArrayList<>();
        System.out.println("Selecciona en este orden:");
        System.out.println("1) Rol jugador en casa durmiendo");
        System.out.println("2) Rol jugador en casa vigilando");
        System.out.println("3) Rol jugador explorando");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println(i + "- " + jugadores.get(i).getNombre());
        }
        for (int i = 0; i < jugadores.size(); i++) {
            int n;
            while (true) {
                System.out.print(i + ") (Introduzca el numero del jugador)--> ");
                n = sc.nextInt(); //numero de jugador
                if (n >= 0 && n < jugadores.size()) {
                    break;
                }
            }
            rolesPers.add(jugadores.get(n));
        }
        return rolesPers;
    }
}
