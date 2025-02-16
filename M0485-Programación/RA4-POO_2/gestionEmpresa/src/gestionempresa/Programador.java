/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionempresa;

/**
 *
 * @author migue
 */
public class Programador {

    private String nombre;
    private String dni;
    private Perfil[] perfiles = new Perfil[3]; //Solo necesitamos 3 perfiles

    public Programador(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPerfiles(Perfil[] perfiles) {
        this.perfiles = perfiles;
    }
    
    //en caso de querer agregar solo 1 perfil
    public void setPerfil(Perfil perfil) {
        for (int i = 0;i < this.perfiles.length; i++){
            if (perfiles[i] == null){
                perfiles[i] = perfil;
                return;
            }
        }
        System.out.println("Todos los perfiles estan llenos");
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public Perfil[] getPerfiles() {
        return this.perfiles;
    }
}
