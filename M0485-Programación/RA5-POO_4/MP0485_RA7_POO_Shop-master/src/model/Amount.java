/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author migue
 */
public class Amount {
    
    private double value;
    final private String CURRENCY = "$";
    
    public Amount(double value){
        this.value = value;
    }
    
    public void setValue(double value){
        this.value = value;
    }
    
    public double getValue(){
        return this.value;
    }
    
    public String getCurrency(){
        return this.CURRENCY;
    }
    
    public String showAmount(){
        return this.value + this.CURRENCY;
    }
    
}
