/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.io.*;
import java.util.*;

/**
 *
 * @author CoceraCia
 * GitHub: https://github.com/CoceraCia
 */
public class FileManager {
    //Attributes
    private String location = "prueba.txt";
    private File file;

    /**
     * Constructor to manage a File, starting with a Location
     * In case file doesn't exists, it will be created
     * @param location path of the file
     * */
    public FileManager(String location) {
        try {
            File f = new File(location);
            f.createNewFile();
            this.file = f;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Constructor to manage a File
     * @param file that we are going to manage
     * */
    public FileManager(File file) {
        this.file = file;
    }
    
    public FileManager() {
        this.file = new File(location);
    }

    /**
    *
    * @param content that will be written on file
    **/
    public void write(String content) {
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(this.file, true));
            wr.write(content);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    *Clear the current file
    * 
    **/
    public void clear() {
        //OverWrite the current file
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(this.file, false));
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return returns an ArrayList containing all the lines from the file
     *                 in case it's empty returns null
     **/
    public ArrayList<String> read() {
        try{
            BufferedReader r = new BufferedReader(new FileReader(this.file));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = r.readLine()) != null){
                 lines.add(line);
            }
            r.close();
            return lines;
        } catch (IOException e){
            return null;  
        }
    }
}
