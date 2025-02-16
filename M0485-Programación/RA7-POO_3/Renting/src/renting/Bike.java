/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renting;

/**
 *
 * @author migue
 */
public class Bike extends Vehicles {
    private boolean itsEbike;
    
    public Bike(String licenseTag, String color, String manufacturer, boolean itsEbike) {
        super(licenseTag, color, manufacturer);
        this.itsEbike = itsEbike;
    }
    
    public void setItsEbike(boolean x){
        this.itsEbike = x;
    }
    
    public boolean getItsEbike(){
        return this.itsEbike;
    }
    
    // We dont care the numDays we basically want to know if its an e-bike
    @Override
    public double rent(int numDays){
        return (itsEbike == true)?this.getPrice() + 15: this.getPrice() + 10;
    }
    
    @Override
    public String toString(){
        return "BIKE "+ this.getManufacturer() +
                "\n\t- LicenseTag --> " + this.getLicenseTag()+
                "\n\t- Color --> " +this.getColor() +
                "\n\t- its Ebike? --> " +this.itsEbike+"\n";
    }
}
