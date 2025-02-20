/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alumnos;

import java.util.*;
import java.io.*;

/**
 *
 * @author migue
 */
public class RegistrosAlumnos {

    public static ArrayList<Alumno> register = new ArrayList();
    public static String file = "register/register.txt"; //location of the file that we are going to work

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        genFile(file); //gen the file if not exists
        obtainStudents(); //obtain the students already storaged in the txt
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int x;
        do {
            System.out.println("==================================");
            System.out.println("              MENU");
            System.out.println("==================================");
            System.out.println("1- Add student");
            System.out.println("2- Delete student");
            System.out.println("3- Show register");
            System.out.println("0- Exit");
            System.out.print("Select an option --> ");
            try {
                x = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value, try again");
                sc.nextLine();
                x = -1;
            }
            switch (x) {
                case 1 ->
                    genStudent();
                case 2 ->
                    removeStudent();
                case 3 ->
                    showStudents();
            }
        } while (x != 0);
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

    public static void showStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENTS LIST");
        for (Alumno student : register) {
            System.out.println("Name: "+ student.getNombre());
            System.out.println("Last Name: "+ student.getApellido());
            System.out.println("Age: "+ student.getEdad());
            System.out.println("Course: "+ student.getCurso());
            System.out.println("DNI: "+ student.getDni());
            System.out.println("-------------------------------------");
        }
    }

    //method to obtain the students from the txt and apply to the ArrayList
    public static void obtainStudents() {
        FileManager fm = new FileManager();
        ArrayList<String> students = fm.openFile(file);
        for (String s: students){
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

    public static void removeStudent() {
        Scanner sc = new Scanner(System.in);
        FileManager fm = new FileManager();
        showStudents();
        System.out.print("Introduce the DNI of the student to remove --> ");
        String dni = sc.nextLine().strip();
        boolean deleted = false;
        for (int i = 0; i < register.size(); i++) {
            if (register.get(i).getDni().equalsIgnoreCase(dni)) {
                register.remove(i);
                System.out.println("Succesfully deleted");
                deleted = true;
                break;
            }
        }
        if (deleted == true){
            fm.openFile(file, "", false); //overwrite the file
            for (Alumno s:register){
                String data = s.getNombre() + ";" + s.getApellido() + ";" + s.getEdad() + ";" + s.getCurso() + ";" + s.getDni() + "\n";
                fm.openFile(file, data, true); //add to the file
            }
        } else {
            System.out.println("Student wasn't found");
        }
    }

}
