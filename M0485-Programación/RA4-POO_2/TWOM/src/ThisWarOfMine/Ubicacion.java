/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThisWarOfMine;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author migue
 */
public class Ubicacion {

    private final ArrayList<Objeto> objetos;
    private final int peligrosidad;
    private final int nivel;

    public Ubicacion(int nivel) {
        Random ran = new Random();
        this.nivel = nivel;
        this.peligrosidad = ran.nextInt(1, nivel + 1);
        this.objetos = generarObjetos();
    }

    public ArrayList<Objeto> getObjetos() {
        return this.objetos;
    }

    public int getPeligrosidad() {
        return this.peligrosidad;
    }

    private ArrayList<Objeto> generarObjetos() {
        Random ran = new Random();
        ArrayList<Objeto> objetos = new ArrayList<>();
        //generamos la cantidad de objetos que apareceran
        int cantidad = ran.nextInt(1, 11) - this.nivel;
        for (int i = 0; i < cantidad; i++) {
            int n = ran.nextInt(1, 101);
            if (n <= 10) { //10% de armas
                if (objExiste("Arma", objetos)) {
                    incrementarCantidadObj("Arma", objetos);
                } else {
                    objetos.add(new Objeto("Arma", 1));
                }
            } else if (n <= 25) { // 15% de medicamentos
                if (objExiste("Medicamentos", objetos)) {
                    incrementarCantidadObj("Medicamentos", objetos);
                } else {
                    objetos.add(new Objeto("Medicamentos", 1));
                }
            } else if (n <= 55) { // 30 % de comida
                if (objExiste("Comida", objetos)) {
                    incrementarCantidadObj("Comida", objetos);
                } else {
                    objetos.add(new Objeto("Comida", 1));
                }
            } else if (n <= 100) { // 45% de componentes
                if (objExiste("Componentes", objetos)) {
                    incrementarCantidadObj("Componentes", objetos);
                } else {
                    objetos.add(new Objeto("Componentes", 1));
                }
            }
        }
        return objetos;
    }

    // Funcion para comprobar que el objecto existe
    private boolean objExiste(String tipo, ArrayList<Objeto> objetos) {
        if (!objetos.isEmpty()) { //Si no esta vacia se ejecuta el codigo
            for (int i = 0; i < objetos.size(); i++) {
                Objeto obj = objetos.get(i);
                if (obj.getTipo().equals(tipo)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Funcion para incrementar la cantidad de objetos para que no haya duplicidad de objetos en el Array
    private void incrementarCantidadObj(String tipo, ArrayList<Objeto> objetos) {
        for (int i = 0; i < objetos.size(); i++) {
            Objeto obj = objetos.get(i);
            if (obj.getTipo().equals(tipo)) {
                obj.setCantidad(obj.getCantidad() + 1);
            }
        }
    }
}
