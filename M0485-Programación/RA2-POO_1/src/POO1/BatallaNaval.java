
import java.util.*;

public class BatallaNaval {

    public static void main(String[] args) {
        char[][] panelJugador = new char[5][5];
        char[][] panelMaquina = new char[5][5];
        int barcosJugador, barcosMaquina, cantidad = 0;

        cantidad = cantidadBarcos();
        barcosJugador = cantidad;
        barcosMaquina = cantidad;

        iniciarMatriz(panelJugador);
        iniciarMatriz(panelMaquina);
        situarBarcosJugador(panelJugador, cantidad);
        situarBarcosMaquina(panelMaquina, cantidad);

        System.out.println("Empieza la partida");

        do {
            if (disparaJugador(panelMaquina)) {
                barcosMaquina--;
            }
            mostrarPanel(panelMaquina);

            if (disparaMaquina(panelJugador)) {
                barcosJugador--;
            }
            mostrarPanel(panelJugador);
        } while (barcosJugador > 0 && barcosMaquina > 0);

        mostrarGanador(barcosJugador, barcosMaquina);
    }

    public static void iniciarMatriz(char[][] panel) {
        for (int i = 0; i < panel.length; i++) { //recorremos filas
            for (int j = 0; j < panel[i].length; j++) { //recorremos columnas
                panel[i][j] = '*';
            }
        }
    }

    public static int cantidadBarcos() {
        Scanner sc = new Scanner(System.in);
        int cantidad;
        while (true) {
            System.out.print("Cuantos barcos deseas min 1 y max 5?-->");
            cantidad = sc.nextInt();
            if (cantidad > 0 && cantidad <= 5) {
                break;
            }
        }
        return cantidad;
    }

    public static void situarBarcosJugador(char[][] panel, int cantidad) {
        Scanner sc = new Scanner(System.in);
        int fila, columna;
        for (int i = 0; i < cantidad; i++) { //recorremos en base a la cantidad de Barcos
            System.out.println("---------------------BARCO " + (i+1) + "---------------");
            while (true) {
                System.out.print("Introduce fila (rango: 0,4)-->");
                fila = sc.nextInt();
                System.out.print("Introduce columna (rango: 0,4)-->");
                columna = sc.nextInt();
                if (fila >= 0 && columna >= 0 && fila < 5 && columna < 5) { //Si esta en los rangos validos rompemos el bucle
                    break;
                } else {
                    System.out.println("--ERROR--VALOR FUERA DE RANGO");
                }
            }
            panel[fila][columna] = 'B';
        }
        System.out.println("Barcos situados correctamente");
    }

    public static void situarBarcosMaquina(char[][] panel, int cantidad) {
        Random ran = new Random();
        int fila, columna;
        for (int i = 0; i < cantidad; i++) {
            while (true) {
                fila = ran.nextInt(0, 5);
                columna = ran.nextInt(0, 5);
                if (panel[fila][columna] == '*') {
                    break;
                }
            }
            panel[fila][columna] = 'B';
        }
        System.out.println("Barcos de la maquina situados correctamente");
    }

    public static boolean disparaJugador(char[][] panel) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------TURNO JUGADOR----------------------------------");
        int fila, col;
        while (true) { //en caso de que la casilla sea A o " se repite
            System.out.print("Introduce la fila(0,4)-->");
            fila = sc.nextInt();
            System.out.print("Introduce la columna(0,4)-->");
            col = sc.nextInt();
            if (fila >= 0 && col >= 0 && fila < 5 && col < 5) {
                if (panel[fila][col] != 'A' && panel[fila][col] != '"') { //Comprobamos que no sea A o "
                    break;
                } else {
                    System.out.println("CORDENADA INVALIDA");
                }
            } else {
                System.out.println("RANGO INVALIDO");
            }

        }
        if (panel[fila][col] == 'B') {
            panel[fila][col] = '"';
            return true;
        } else {
            panel[fila][col] = 'A';
            return false;
        }
    }

    public static boolean disparaMaquina(char[][] panel) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("----------------------------TURNO MAQUINA----------------------------------");
        int fila, col;
        while (true) { //en caso de que la casilla sea A o " se repite
            fila = ran.nextInt(0, 5);
            col = ran.nextInt(0, 5);
            if (panel[fila][col] != 'A' && panel[fila][col] != '"') { //Comprobamos que no sea A o "
                break;
            }
        }
        if (panel[fila][col] == 'B') {
            panel[fila][col] = '"';
            return true;
        } else {
            panel[fila][col] = 'A';
            return false;
        }
    }

    public static void mostrarPanel(char[][] panel) {
        for (int i = 0; i < panel.length; i++) { //recorremos filas
            for (int j = 0; j < panel.length; j++) { //recorremos columnas
                System.out.print(panel[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void mostrarGanador(int barcosJugador, int barcosMaquina) {
        if (barcosJugador == 0 && barcosMaquina == 0) {
            System.out.println("Ha habido empateeee");
        } else if (barcosJugador == 0){
            System.out.println("El ganador ha sido la maquinaa");
        } else{
            System.out.println("El ganador ha sido el jugadorrr");
        }
        System.out.println("Barcos restantes del jugador: "+barcosJugador+"\nBarcos restantes de la maquina: "+barcosMaquina);
    }
}
