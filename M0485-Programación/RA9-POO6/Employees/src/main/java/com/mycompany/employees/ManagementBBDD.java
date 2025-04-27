/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
/**
 *
 * @author migue
 */
public class ManagementBBDD {
    private String url;
    private String user;
    private String password;
    private Connection conn;
    
    public ManagementBBDD(String url, String user, String password) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        if (!testConnection()){
            throw new SQLException("Incorrect credentials");
        }
        createDatabase();
        createEmployeeTable();
    }
    
    private boolean testConnection(){
         try {
            this.conn = DriverManager.getConnection(this.url,this.user, this.password);
            return true;
        } catch (SQLException  e){
            e.printStackTrace();
            return false;
        }
    }
    
    private boolean createDatabase(){
        String CreateDbQuery = "CREATE DATABASE IF NOT EXISTS EmployeeManagement;";
        String UseDbQuery = "USE EmployeeManagement;";
        
        try(Statement stmt = this.conn.createStatement()){
            stmt.executeUpdate(CreateDbQuery);
            stmt.executeUpdate(UseDbQuery);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    private boolean createEmployeeTable(){
        String query = "CREATE TABLE IF NOT EXISTS employee("
                + "id INT PRIMARY KEY, "
                + "name varchar(45),"
                + "age int, "
                + "department varchar(45), "
                + "salary decimal(10,2)"
                + ")";
        
        try {
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertEmployee(Employee emp){
        String query = "INSERT INTO employee (id, name, age, department, salary) VALUES (?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setInt(3, emp.getAge());
            pstmt.setString(4, emp.getDepartament());
            pstmt.setDouble(5, emp.getSalary());
            if (pstmt.executeUpdate() > 0){ //if its inserted it will return a row
                Employees.employees.put(emp.getId(), emp); //we add it to our hashmap
                return true;
            } else {
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateEmployee(int id, String name, int age, String department, Double salary){
        String query = "UPDATE employee "
                + "SET name = ?, "
                + "age = ?, "
                + "department = ?, "
                + "salary = ? "
                + "WHERE id = ?";
        if (!Employees.employeeExists(id)){
            System.out.println("Not exists");
            return false;
        }
        try(PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.setDouble(4, salary);
            pstmt.setInt(5, id);
            if (pstmt.executeUpdate() > 0){
                Employee emp = Employees.employees.get(id);
                emp.setName(name);
                emp.setAge(age);
                emp.setDepartament(department);
                emp.setSalary(salary);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    
    public HashMap<Integer, Employee> obtainEmployees(){
        String query = "SELECT * FROM employee;";
        HashMap<Integer, Employee> hmemp = new HashMap<>();
        try{
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");
                Double salary = rs.getDouble("salary");
                hmemp.put(id, new Employee(id, name, age, department, salary));
            }
            return hmemp;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean deleteEmployee(int id){
        String query = "DELETE FROM employee WHERE id = ?;";
        try(PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, id);
            if(pstmt.executeUpdate() > 0){
                Employees.employees.remove(id);
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
