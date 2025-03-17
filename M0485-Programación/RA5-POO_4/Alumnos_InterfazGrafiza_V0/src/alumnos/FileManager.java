/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alumnos;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author migue
 */
public class FileManager {
    /**
     * Function that reads a file
     * @param file the file that's going to be open
     * @return  returns an array of the given lines by the file
     */
    public ArrayList<String> openFile(String file){
        ArrayList<String> alu = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                alu.add(line);
            }
            reader.close();
        } catch(IOException e){
            System.out.println("There was an error reading the file");
        }
        return alu;
    }
    /**
     * Function that writes a file
     * @param file the file that's going to be open
     * @param content content to write
     * @param type true = add content, false = overwrite content
     */
    public void openFile(String file, String content, boolean type){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, type))){
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("There was an error reading the file");
        }
    }
}
