/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cocera.miguel;

/**
 *
 * @author migue
 */
public class Account {
    //Atributos
    private int number;
    private double balance;
    private String holder;
    
    //Constructor
    public Account(int number, double balance, String holder){
        this.number = number;
        this.balance = balance;
        this.holder = holder;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void setHolder(String holder){
        this.holder = holder;
    }
}
