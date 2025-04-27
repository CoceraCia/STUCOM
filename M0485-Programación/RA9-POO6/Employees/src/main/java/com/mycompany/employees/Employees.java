/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.employees;

import Frames.Home;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author migue
 */
public class Employees {

    public static ManagementBBDD conn;
    public static HashMap<Integer, Employee> employees;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("No se pudo aplicar FlatLaf");
        }
        try {
            ManagementBBDD conn = new ManagementBBDD("jdbc:mysql://localhost:3306/", "root", "");
            setConn(conn);
            setEmployees(conn.obtainEmployees());
            System.out.println("Succesful connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
    }

    public static void setConn(ManagementBBDD conn) {
        Employees.conn = conn;
    }

    public static void setEmployees(HashMap<Integer, Employee> employees) {
        Employees.employees = employees;
    }

    public static Employee getEmployeeById(int id) {
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getKey() == id) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static boolean employeeExists(int id) {
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getKey() == id) {
                return true;
            }
        }
        return false;
    }

    public static String getEmployeesToString() {
        String txt = "<html><body><h1>EMPLOYEES LIST</h1>";
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            int id = entry.getValue().getId();
            String name = entry.getValue().getName();
            int age = entry.getValue().getAge();
            String department = entry.getValue().getDepartament();
            double salary = entry.getValue().getSalary();
            txt += "<p>ID: " + id + "</p>"
                    + "<p>Name: " + name + "</p>"
                    + "<p>Age: " + age + "</p>"
                    + "<p>Department: " + department + "</p>"
                    + "<p>Salary: " + salary + "</p>"
                    + "<hr>";
        }
        txt += "</body></html>";
        return txt;
    }

    public static String getEmployeesToString(int pId) {
        String txt = "<html><body><h1>EMPLOYEES LIST</h1>";
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            String x = String.valueOf(pId);
            String key = String.valueOf(entry.getKey());
            if (key.contains(x)) {
                int id = entry.getValue().getId();
                String name = entry.getValue().getName();
                int age = entry.getValue().getAge();
                String department = entry.getValue().getDepartament();
                double salary = entry.getValue().getSalary();
                txt += "<p>ID: " + id + "</p>"
                        + "<p>Name: " + name + "</p>"
                        + "<p>Age: " + age + "</p>"
                        + "<p>Department: " + department + "</p>"
                        + "<p>Salary: " + salary + "</p>"
                        + "<hr>";
            }
        }
        txt += "</body></html>";
        return txt;
    }

}
