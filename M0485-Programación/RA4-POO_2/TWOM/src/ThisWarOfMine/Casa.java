/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThisWarOfMine;
import java.util.ArrayList;
/**
 *
 * @author migue
 */
public class Casa {
    private boolean cama;
    private final ArrayList<Objeto> objetos;
    
    public Casa(boolean cama, ArrayList<Objeto> objetos){
        this.cama = cama;
        this.objetos = objetos;
    }
    
    public void setCama(boolean isAvailable){
        this.cama = isAvailable;
    }
    
    public boolean getCama(){
        return this.cama;
    }
    
    public void setObjetos(ArrayList<Objeto> objetos){
        for (Objeto obj: objetos){
            this.objetos.add(obj);
        }
    }
    
    public void setObjetos(Objeto objeto){
        this.objetos.add(objeto);
    }
    
    public ArrayList<Objeto> getObjetos(){
        return this.objetos;
    }
    
    // Funcion para comprobar que el objeto existe
    public boolean objExiste(String tipo) {
        if (!this.objetos.isEmpty()) { //Si no esta vacia se ejecuta el codigo
            for (int i = 0; i < this.objetos.size(); i++) {
                Objeto obj = this.objetos.get(i);
                if (obj.getTipo().equalsIgnoreCase(tipo)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Funcion para incrementar la cantidad de objetos para que no haya duplicidad de objetos en el Array
    public void incrementarCantidadObj(String tipo, int cantidad) {
        for (int i = 0; i < this.objetos.size(); i++) {
            Objeto obj = this.objetos.get(i);
            if (obj.getTipo().equals(tipo)) {
                obj.setCantidad(obj.getCantidad() + cantidad);
            }
        }
    }
    
    //Funcion para restar la cantidad de objetos para que no haya duplicidad de objetos en el Array
    public void restarCantidadObj(String tipo, int cantidad) {
        for (int i = 0; i < this.objetos.size(); i++) {
            Objeto obj = this.objetos.get(i);
            if (obj.getTipo().equals(tipo)) {
                if (obj.getCantidad() - 1 > 0){
                    obj.setCantidad(obj.getCantidad() - cantidad);
                } else {
                    objetos.remove(i);
                }
            }
        }
    }
}
