/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;

/**
 *
 * @author migue
 */
public class FilesManipulation {

    //to know if a file or folder exists
    public boolean exists(String location) {
        File f = new File(location);
        return f.exists();
    }

    //if not exists creates a location with their folders and files
    public boolean createLocation(String location) {
        File f = new File(location);
        try{
            return (f.mkdir() || f.mkdirs() || f.createNewFile());
        } catch (IOException e){
            System.out.println("Error at creating the location");
            return false;
        }
    }
}
