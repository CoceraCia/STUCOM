/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThisWarOfMine;

import java.util.*;

/**
 *
 * @author migue
 */
public class Personaje {

    private String nombre;
    private int salud = 10;
    private int hambre = 1;
    private int sueño = 1;
    private String habilidad;
    private ArrayList<Objeto> objetos;

    public Personaje(String nombre, ArrayList<Objeto> objetos) {
        //Con estos metodos nos aseguramos que los nombres salgan bien formateados
        this.nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        this.objetos = objetos;
        switch (nombre) {
            case "Arica" ->
                this.habilidad = "SIGILO";
            case "Bruno" ->
                this.habilidad = "COCINERO";
            case "Katia" ->
                this.habilidad = "ELOCUENDIA";
            case "Pavel" ->
                this.habilidad = "RAPIDEZ";
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public String getHabilidad() {
        return this.habilidad;
    }
    
    public void setHabilidad(String habilidad){
        this.habilidad = habilidad;
    }

    public int getSalud() {
        return this.salud;
    }
    
    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getHambre() {
        return this.hambre;
    }
    
    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getSueño() {
        return this.sueño;
    }
    
    public void setSueño(int sueño){
        this.sueño = sueño;
    }
    
    public ArrayList<Objeto> getObjetos(){
        return this.objetos;
    }
    
    public void setObjetos(ArrayList<Objeto> objetos){
        this.objetos = objetos;
    }

    public void dormir() {
        this.sueño = 1;
    }

    public void vigilar(int nivel) {
        Random ran = new Random();
        this.sueño = +5;
        if (this.sueño > 10) {
            this.sueño = 10;
        }
        int resultado = ran.nextInt(0, 51) - nivel;
        if (resultado >= 40 && resultado <= 50) {   //COMERCIANTE --> añadimos 2 de comida y componentes
            if (objExiste("Comida", this.objetos)) {
                incrementarCantidadObj("Comida", this.objetos);
            } else {
                this.objetos.add(new Objeto("Comida", 2));
            }
            if (objExiste("Componentes", this.objetos)) {
                incrementarCantidadObj("Componentes", this.objetos);
            } else {
                this.objetos.add(new Objeto("Componentes", 2));
            }

        } else if (resultado <= 5) {  //ASALTO --> restamos 2 de vida
            this.salud = - 2;
            if (this.salud < 0) {
                this.salud = 0;
            }
        }
    }

    public void explorar(Ubicacion ubi) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        // vamos a hacer que los objetos empiezen por el indice 1, asi nos aseguramos que al presionar 0 salgamos de la funcion
        for (int i = 0; i < ubi.getObjetos().size(); i++) {
            Objeto objeto = ubi.getObjetos().get(i);
            System.out.println((i + 1) + ") " + objeto.getTipo() + "-->" + objeto.getCantidad());
        }
        //A continuacion le usuario seleccionara los objetos que quiera añadir
        for (int i = 0; i < ubi.getObjetos().size(); i++) {
            Objeto objeto = ubi.getObjetos().get(i);
            System.out.print("Objeto a añadir (para parar presione 0) --> ");
            int n = sc.nextInt(); //indice del objeto a añadir
            if (n == 0) {
                return;
            } else {
                this.objetos.add(objeto);
            }
        }

        //determinamos si sufrira daños
        int ranInt = ran.nextInt(0, ubi.getPeligrosidad());
        //si es mayor o igual a 0 devolvemos el valor resultante en caso contrario 0
        this.salud = (this.salud - ranInt >= 0) ? this.salud - ranInt : 0;
    }

    // Funcion para comprobar que el objeto existe
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
