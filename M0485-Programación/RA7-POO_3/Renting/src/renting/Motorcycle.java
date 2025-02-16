/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renting;

/**
 *
 * @author migue
 */
public class Motorcycle extends Vehicles {
    private int cc;
    
    public Motorcycle(String licenseTag, String color, String manufacturer, int cc) {
        super(licenseTag, color, manufacturer);
        this.cc = cc;
        modifiePrice(cc);
        
    }
    
    public void setCc(int cc){
        this.cc = cc;
    }
    
    public int getCc(){
        return this.cc;
    }
    
    private void modifiePrice(int cc){
        //we are going to apply the price based on the basePrice + (the number of seats * 1.5€)
        double price = this.getPrice() + (cc * 0.05);
        this.setPrice(price);
    }
    
    @Override
    public String toString(){
        return "MOTORCYCLE "+ this.getManufacturer() +
                "\n\t- LicenseTag --> " + this.getLicenseTag()+
                "\n\t- Color --> " +this.getColor() +
                "\n\t- Cc --> " +this.cc+"\n";
    }
}
