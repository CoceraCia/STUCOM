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
public class Ajedrez {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] tablero = iniciarTablero();

        //Pedimos color a jugar
        String[] jugadores = seleccionarColor();
        String jugador1 = jugadores[0], jugador2 = jugadores[1];

        while (reyesVivos(tablero)) {
            for (int turnoJugador = 1; turnoJugador <= 2; turnoJugador++) {
                boolean turnoJugador1 = (turnoJugador == 1);
                if (turnoJugador1) {
                    System.out.println("------------------------------TURNO DEL JUGADOR 1----------------------------");
                } else {
                    System.out.println("------------------------------TURNO DEL JUGADOR 2----------------------------");
                }

                //PUNTO 1 imprimo el tablero
                mostrarTablero(tablero);

                //PUNTO 2 Pido la pieza a mover
                int[] posPieza;
                String pieza;
                while (true) {
                    System.out.println("ESCOJA UNA PIEZA");
                    while (true) {
                        while (true) {
                            posPieza = seleccionarPieza(tablero);
                            pieza = tablero[posPieza[0]][posPieza[1]];
                            //Nos aseguramos que el jugador 1 este seleccionando su color
                            if ((jugador1.equals("negras") && pieza.startsWith("[") && turnoJugador1 == true) || (jugador1.equals("blancas") && pieza.startsWith("(") && turnoJugador1 == true)) {
                                break;
                                //Nos aseguramos que el jugador 2 este seleccionando su color
                            } else if ((jugador2.equals("negras") && pieza.startsWith("[") && turnoJugador1 == false) || (jugador2.equals("blancas") && pieza.startsWith("(") && turnoJugador1 == false)) {
                                break;
                            } else {
                                System.out.println("Pieza Invalida");
                            }
                        }
                        System.out.println("Has elegido esta pieza--> " + pieza);
                        System.out.print("Desea cambiar de pieza? y/n -->");
                        String answer = sc.nextLine().strip().toLowerCase();
                        while (true) {
                            if (answer.equals("y") || answer.equals("n")) {
                                break;
                            }
                        }
                        if (answer.equals("n")) {
                            break;
                        }
                    }

                    //PUNTO 3, 4 y 5 Pido la poscion a mover la pieza, las restricciones van incluidas en la funcion y se actualiza automaticamente
                    System.out.println("MUEVA LA PIEZA");
                    System.out.println("Posicion actual--> " + pieza);
                    mostrarTablero(tablero);
                    if (movimientoPieza(pieza, tablero, posPieza)) {
                        break;
                    }
                }
            }
        }
        mostrarGanador(tablero);
    }

    public static String[] seleccionarColor() {
        Scanner sc = new Scanner(System.in);
        String jugadores[] = new String[2];
        while (true) {
            System.out.print("Jugador 1 seleccione que color desea jugar. Escriba (blancas o negras)-->");
            String x = sc.nextLine().toLowerCase().strip();
            if (x.equals("blancas") || x.equals("negras")) {
                if (x.equals("blancas")) {
                    jugadores[0] = x;
                    jugadores[1] = "negras";
                } else {
                    jugadores[0] = x;
                    jugadores[1] = "blancas";
                }
                break;
            } else {
                System.out.println("Valor Incorrecto");
            }
        }
        return jugadores;
    }

    public static String[][] iniciarTablero() {
        String[][] tablero = {
            {"[T]", "[C]", "[A]", "[K]", "[Q]", "[A]", "[C]", "[T]"},
            {"[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]", "[P]"},
            {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
            {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
            {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
            {" . ", " . ", " . ", " . ", " . ", " . ", " . ", " . "},
            {"(P)", "(P)", "(P)", "(P)", "(P)", "(P)", "(P)", "(P)"},
            {"(T)", "(C)", "(A)", "(Q)", "(K)", "(A)", "(C)", "(T)"}
        };
        return tablero;
    }

    public static void mostrarTablero(String[][] tablero) {

        //Imprimimos tablero
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + " "); //cordenadas filas
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
        
        //Cordenadas para las columnas
        System.out.print(" ");
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        
        for (char letra: abecedario) {
            System.out.print("  " + letra + " ");
        }
        System.out.println("");
    }

    public static int[] seleccionarPieza(String[][] tablero) {
        while (true) {
            int[] pos = obtenerPosicion();
            int fila = pos[0];
            int col = pos[1];
            //Comprobamos que ha elegido una ficha
            if (tablero[fila][col].equals(" . ") == false) {
                return pos;
            } else {
                System.out.println("-ERROR-No has elegido ninguna ficha");
                mostrarTablero(tablero);
            }
        }
    }

    public static int[] obtenerPosicion() {
        Scanner sc = new Scanner(System.in);
        int[] posiciones = new int[2];
        while (true) {
            //Pedimos la fila y la columna
            System.out.print("Introduzca la fila: ");
            posiciones[0] = sc.nextInt();
            sc.nextLine(); //Limpiamos el buffer
            System.out.print("Introduzca la columna: ");
            String columna = sc.nextLine().strip().toLowerCase();
            posiciones[1] = indiceColumna(columna);
            
            //Comprobamos que este en el rango adecuado
            if (posiciones[0] >= 0 && posiciones[0] < 8 && posiciones[1] >= 0 && posiciones[1] < 8) {
                break;
            } else {
                System.out.println("-ERROR-Rangos Incorrectos");
            }
        }
        return posiciones;
    }

    public static boolean movimientoPieza(String pieza, String[][] tablero, int[] posPieza) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int[] mov = obtenerPosicion(); // posicion a mover de la pieza
            if (restriccionMovimiento(pieza, tablero, mov, posPieza) == false) {
                if (verificarObstaculo(posPieza[0], mov[0], posPieza[1], mov[1], tablero) == false || pieza.contains("C")) {
                    if (tablero[mov[0]][mov[1]].equals(" . ")) {
                        tablero[mov[0]][mov[1]] = pieza;
                        tablero[posPieza[0]][posPieza[1]] = " . ";
                        break;
                    } else {    //Eliminamos las piezas siempre y cuando no sean del mismo color
                        if (pieza.startsWith("[") && tablero[mov[0]][mov[1]].startsWith("(")) {
                            tablero[mov[0]][mov[1]] = pieza;
                            tablero[posPieza[0]][posPieza[1]] = " . ";
                            break;
                        } else if (pieza.startsWith("(") && tablero[mov[0]][mov[1]].startsWith("[")) {
                            tablero[mov[0]][mov[1]] = pieza;
                            tablero[posPieza[0]][posPieza[1]] = " . ";
                            break;
                        } else {
                            System.out.print("-ERROR-Movimiento restringido, pieza del mismo color");
                        }
                    }
                } else {
                    System.out.println("-ERROR-Obstaculo en el camino");
                    mostrarTablero(tablero);
                    System.out.print("Desea cambiar de pieza? y/n -->");
                    String answer = sc.nextLine().strip().toLowerCase();
                    while (true) {
                        if (answer.equals("y") || answer.equals("n")) {
                            break;
                        }
                    }
                    if (answer.equals("y")) {
                        return false;
                    }
                }
            } else {
                System.out.println("-ERROR-Movimiento restringido");
                mostrarTablero(tablero);
                System.out.print("Desea cambiar de pieza? y/n -->");
                String answer = sc.nextLine().strip().toLowerCase();
                while (true) {
                    if (answer.equals("y") || answer.equals("n")) {
                        break;
                    }
                }
                if (answer.equals("y")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean restriccionMovimiento(String pieza, String[][] tablero, int[] movimiento, int[] posicionPieza) {
        //filas y columnas para mover la pieza
        int filaFin = movimiento[0];
        int colFin = movimiento[1];

        //Posiciones actuales de las piezas
        int[] posicion = posicionPieza;
        int filaIni = posicion[0];
        int colIni = posicion[1];
        boolean restringido = true;
        switch (pieza) {
            case "[P]", "(P)" -> {  //Peon
                //Si tiene una pieza que esta 
                //si es la primera vez que se mueve puede hacer 
                if ((pieza.equals("[P]") && filaIni == 1) || (pieza.equals("(P)") && filaIni == 6)) {
                    //hacemos esta comparacion ya que el peon dependiendo de donde este situado reducira casillas, por ejemplo las piezas () empiezan en la posicion 6 por lo tanto al avanzar reduciran casillas
                    int avanza = (pieza.equals("[P]")) ? 2 : -2;
                    // esta variable es en caso de que solo quiera moverse una posicion
                    int avanzaFil = (pieza.equals("[P]")) ? 1 : -1;
                    //Se puede mover dos filas hacia alante y la columna tiene que ser la misma
                    if (filaFin == filaIni + avanza && colFin == colIni) {
                        restringido = false;    //Movimiento valido
                    } else if (filaFin == filaIni + avanzaFil && colFin == colIni) {
                        restringido = false;    //Movimiento valido
                    } else if (filaFin == filaIni + avanzaFil && (colFin == colIni + 1 || colFin == colIni - 1)) {
                        restringido = false;    //Movimiento valido.Se puede comer a la pieza, la pieza sera comida en la funcion movimientoPieza();
                    }
                } else { // en caso de que no sea la primera vez que se mueve
                    int avanzaFil = (pieza.equals("[P]")) ? 1 : -1;
                    if (filaFin == filaIni + avanzaFil && colFin == colIni) {
                        restringido = false;    //Movimiento valido
                    } else if (filaFin == filaIni + avanzaFil && (colFin == colIni + 1 || colFin == colIni - 1)) {
                        restringido = false;    //Movimiento valido.Se puede comer a la pieza, la pieza sera comida en la funcion movimientoPieza();
                    }
                }
                break;
            }
            case "[T]", "(T)" -> {  //Torre
                //Se puede mover solo en linea recta
                if ((filaIni == filaFin && colIni != colFin) || (filaIni != filaFin && colIni == colFin)) {
                    restringido = false;    //Movimiento valido
                }
                break;
            }
            case "[A]", "(A)" -> {  //Alfil
                //SOLO SE PUEDE MOVER EN DIAGONAL
                // La similitud que tienen esq si las filas tienen una diferencia de 2, haga lo que haga los valores aumentaran o disminuiran pero siempre en base a esa diferencia
                //Es decir con el valor absoluto nos aseguramos que la diferencia en todos los casos siempre sea la misma
                if (Math.abs(filaIni - filaFin) == Math.abs(colIni - colFin)) {
                    restringido = false;    //Movimiento valido
                }
                break;
            }
            //Solo  se puede mover en forma de L, siempre avanzara o retrocedera 2 filas y 1 columna o 2 columnas y 1 fila
            case "[C]", "(C)" -> {
                if ((Math.abs(filaIni - filaFin) == 2 && Math.abs(colIni - colFin) == 1) || (Math.abs(filaIni - filaFin) == 1 && Math.abs(colIni - colFin) == 2)) {
                    restringido = false;    //Movimiento valido
                }
                break;
            }
            //La reina puede moverse en linea recta y diagonal como la Torre y el Alfil
            case "[Q]", "(Q)" -> {
                if (Math.abs(filaIni - filaFin) == Math.abs(colIni - colFin)) { //Movimiento Diagonal
                    restringido = false;    //Movimiento valido
                } else if (filaIni == filaFin && colIni != colFin || filaIni != filaFin && colIni == colFin) { //Movimiento lineal
                    restringido = false;    //Movimiento valido
                }
                break;
            }
            //Puede realizar cualquier movimiento pero solo puede moverse una casilla
            case "[K]", "(K)" -> {
                if (Math.abs(filaIni - filaFin) == 1 && Math.abs(colIni - colFin) == 1) { //Movimiento Diagonal
                    restringido = false;    //Movimiento valido
                } else if ((filaIni == filaFin && Math.abs(colIni - colFin) == 1) || (Math.abs(filaIni - filaFin) == 1 && colIni == colFin)) { //Movimiento lineal (Horizontal)(Vertical)
                    restringido = false;    //Movimiento valido
                }
                break;
            }
        }

        return restringido;
    }

    public static boolean verificarObstaculo(int filaIni, int filaFin, int colIni, int colFin, String[][] tablero) {
        int avanzaFil, avanzaCol;
        boolean obstaculiza = false;

        if (filaIni == filaFin) {
            avanzaFil = 0; //En caso de que sea la misma posicion nos devolvera un 0 para evitar que el valor cambie
        } else {
            avanzaFil = (filaIni < filaFin) ? 1 : -1; // Si la fila final es mayor a la inicial se avanza, se nos devuelve un 1 , en caso de que sea falso, un -1
        }

        if (colIni == colFin) {
            avanzaCol = 0; //En caso de que sea la misma posicion nos devolvera un 0 para evitar que el valor cambie
        } else {
            avanzaCol = (colIni < colFin) ? 1 : -1; // Si la col final es mayor a la inicial se avanza, se nos devuelve un 1 , en caso de que sea falso, un -1
        }

        //En este bucle for creamos dos variables que actuaran como fila y columna, tendran los valores de la fila ini y col ini + si avanzan posicion o no, esto nos ayudará a descartar que se tengan en cuenta las posiciones iniciales
        //Tenemos dos condiciones ya que las evaluara en funcion de si es mayor o menor, eso variara dependiendo si estamos retrocediendo o avanzando, pero tienen en comun que siempre llegan a la posicion final
        // He descubierto a hacer estas condiciones gracias al chatGPT lo importante es que he entendido la logica y me ha ayudado a llegar a hacer esta funcion
        for (int fila = filaIni + avanzaFil, col = colIni + avanzaCol; fila != filaFin || col != colFin; fila += avanzaFil, col += avanzaCol) {
            if (tablero[fila][col].equals(" . ") == false) {
                obstaculiza = true;
                break;
            }
        }
        return obstaculiza;
    }

    public static boolean reyesVivos(String[][] tablero) {
        int vivos = 0;
        for (String[] fila : tablero) {
            for (String pieza : fila) {
                if (pieza.contains("K")) {
                    vivos++;
                }
            }
        }
        if (vivos == 2) {
            return true;
        }
        return false;
    }

    public static void mostrarGanador(String[][] tablero) {
        for (String[] fila : tablero) {
            for (String pieza : fila) {
                if (pieza.equals("[K]")) {
                    System.out.println("Han ganado las piezas negras!!");
                    break;
                } else if (pieza.equals("(K)")){
                    System.out.println("Han ganado las piezas blancas!!");
                    break;
                }
            }
        }
    }
    
    public static int indiceColumna(String columna){
        String[] abecedario = {"a", "b", "c", "d", "e", "f", "g", "h"};
        int i;
        for(i = 0; i < abecedario.length; i++){
                if (abecedario[i].equals(columna)){
                    break;
                }
            }
        return i;
    }
}
