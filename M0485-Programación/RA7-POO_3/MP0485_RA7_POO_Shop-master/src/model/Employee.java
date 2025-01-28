/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import main.Logable;

/**
 *
 * @author migue
 */
public class Employee extends Person implements Logable {
    private int employeeid;
    private String password;
    
    
    //constantes fijas
    private final int EMPLOYEE_ID = 123;
    private final String PASSWORD = "test";
    
    public Employee(String name){
        super(name);
        this.employeeid = this.EMPLOYEE_ID;
        this.password = this.PASSWORD;
    }
    
    public int getId(){
        return this.employeeid;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    @Override   //Implemented from Logable
    public boolean login(int id, String password){
        return (this.employeeid == id && this.password.equals(password));
    }
}
