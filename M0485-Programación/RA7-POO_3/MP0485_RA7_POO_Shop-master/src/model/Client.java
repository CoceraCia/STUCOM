/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import main.Payable;

/**
 *
 * @author migue
 */
public class Client extends Person implements Payable{
    private int memberId;
    private Amount balance;
    
    //CONSTANT VALUES
    private final int MEMBER_ID = 456;
    private final Amount BALANCE = new Amount(50);
    
    public Client (String name){
        super(name);
        this.balance = this.BALANCE;
        this.memberId = this.MEMBER_ID;
    }
    
    public Amount getBalance(){
        return this.balance;
    }
    
    public int getId(){
        return this.memberId;
    }

    @Override
    public boolean pay(Amount amount) {
        //If our balance substracted by the amount of money is more than 0 it means that we are able to pay
        return (this.balance.getValue() - amount.getValue() > 0); 
        
    }
}
