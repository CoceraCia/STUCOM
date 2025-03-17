/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alumnos;

import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author migue
 */
public class RegistrosAlumnos {

    private static ArrayList<Alumno> register = new ArrayList();
    private static String file = "register/register.txt"; //location of the file that we are going to work

    public static ArrayList<Alumno> getRegister() {
        return register;
    }

    public static void setRegister(ArrayList<Alumno> register) {
        RegistrosAlumnos.register = register;
    }

    public static String getFile() {
        return file;
    }

    public static void setFile(String file) {
        RegistrosAlumnos.file = file;
    }

    /**
     * Adds to the register a Student
     *
     * @param alu
     */
    public static void addToRegister(Alumno alu) {
        register.add(alu);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        Scanner sc = new Scanner(System.in);
        genFile(file); //gen the file if not exists
        obtainStudents(); //obtain the students already storaged in the txt
        Home home = new Home();
        home.setVisible(true);
    }

    public static void genFile(String location) {
        File f = new File(location);
        if (f.getParentFile() != null) {
            File parent = f.getParentFile();
            parent.mkdirs();
        }
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("File created");
            } catch (IOException e) {
                System.out.println("There was an error, the file couldn't get created");
                System.out.println(e);
            }
        }
    }

    public static void genStudent() {
        Scanner sc = new Scanner(System.in);
        FileManager fm = new FileManager();
        try {
            System.out.println("==================================");
            System.out.println("        DATA OF THE STUDENT");
            System.out.println("==================================");
            System.out.print("\tName: ");
            String name = sc.nextLine().strip();
            System.out.print("\tLastName: ");
            String last = sc.nextLine().strip();
            System.out.print("\tAge: ");
            int age = sc.nextInt();
            sc.nextLine(); //limpiamos el buffer
            System.out.print("\tCourse: ");
            String course = sc.nextLine().strip();
            System.out.print("\tDNI: ");
            String dni = sc.nextLine().strip();
            if (repeatedDni(dni)) {
                System.out.println("\tERROR- DNI ALREADY EXISTS");
                return;
            }
            register.add(new Alumno(name, last, age, course, dni));
            System.out.println("Student was succesfully created");
            String data = name + ";" + last + ";" + age + ";" + course + ";" + dni + "\n";
            fm.openFile(file, data, true);
        } catch (InputMismatchException e) {
            System.out.println("\tERROR - INCORRECT VALUE");
        }

    }

    public static String showStudents() {
        String students = "";
        students += """
        <!DOCTYPE html>
        <html lang="es">
            <head>
                <meta charset="UTF-8">
                 <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">
                <style>
                    body {
                       margin: 0;
                       padding: 0;
                       font-family: 'Montserrat', sans-serif;
                       justify-content: center;
                       align-items: center;
                       text-align: center;
                       background-color: #1E1E1E;
                       color: #E0E0E0;
                    }
                 </style>
            </head>
        <body>
        """;
        for (Alumno student : register) {
            students += "<h2>------------------------DNI: " + student.getDni() + "------------------------</h2>";
            students += "<p>Name: " + student.getNombre() + "</p>";
            students += "<p>Last Name: " + student.getApellido() + "</p>";
            students += "<p>Age: " + student.getEdad() + "</p>";
            students += "<p>Course: " + student.getCurso() + "</p>";
            students += "<br>";
        }
        students += """
        </body>
        </html>
        """;
        return students;
    }

    public static String showStudentByDni(String dni) {
        String students = "";
        students += """
        <!DOCTYPE html>
        <html lang="es">
            <head>
                <meta charset="UTF-8">
                 <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;700&display=swap" rel="stylesheet">
                <style>
                    body {
                       margin: 0;
                       padding: 0;
                       font-family: 'Montserrat', sans-serif;
                       justify-content: center;
                       align-items: center;
                       text-align: center;
                       background-color: #1E1E1E;
                       color: #E0E0E0;
                    }
                 </style>
            </head>
        <body>
        """;
        boolean found = false;
        for (Alumno student : register) {
            if (student.getDni().startsWith(dni.toLowerCase())) {
                found = true;
                students += "<h2>------------------------DNI: " + student.getDni() + "------------------------</h2>";
                students += "<p>Name: " + student.getNombre() + "</p>";
                students += "<p>Last Name: " + student.getApellido() + "</p>";
                students += "<p>Age: " + student.getEdad() + "</p>";
                students += "<p>Course: " + student.getCurso() + "</p>";
                students += "<br>";
            }
        }
        if (found == false) {
            students += "<p>NOT FOUND</p>";
        }
        students += """
        </body>
        </html>
        """;
        return students;
    }

    //method to obtain the students from the txt and apply to the ArrayList
    public static void obtainStudents() {
        FileManager fm = new FileManager();
        ArrayList<String> students = fm.openFile(file);
        for (String s : students) {
            String[] student = s.split(";");
            if (student.length > 1) {
                register.add(new Alumno(student[0], student[1], Integer.parseInt(student[2]), student[3], student[4]));
            }
        }
    }

    public static boolean repeatedDni(String dni) {
        for (Alumno student : register) {
            if (student.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }

    public static boolean removeStudent(String dni) {
        FileManager fm = new FileManager();
        showStudents();
        boolean deleted = false;
        for (int i = 0; i < register.size(); i++) {
            if (register.get(i).getDni().equalsIgnoreCase(dni)) {
                register.remove(i);
                deleted = true;
                break;
            }
        }
        if (deleted == true) {
            overwriteFile();
            return true;
        } else {
            return false;
        }
    }

    public static void overwriteFile() {
        FileManager fm = new FileManager();
        fm.openFile(file, "", false); //overwrite the file
        for (Alumno s : register) {
            String data = s.getNombre() + ";" + s.getApellido() + ";" + s.getEdad() + ";" + s.getCurso() + ";" + s.getDni() + "\n";
            fm.openFile(file, data, true); //add to the file
        }
    }

}
