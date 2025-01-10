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
}
