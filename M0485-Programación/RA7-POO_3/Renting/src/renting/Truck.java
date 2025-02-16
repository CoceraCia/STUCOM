/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renting;

/**
 *
 * @author migue
 */
public class Truck extends Vehicles{
    
    public Truck(String licenseTag, String color, String manufacturer) {
        super(licenseTag, color, manufacturer);
        modifiePrice();
    }
    
    private void modifiePrice(){
        final int PMA = 40;
        double price = this.getPrice() + (20 * PMA);
        this.setPrice(price);
    }
    
    @Override
    public String toString(){
        return "TRUCK "+ this.getManufacturer() +
                "\n\t- LicenseTag --> " + this.getLicenseTag()+
                "\n\t- Color --> " +this.getColor()+"\n";
    }
}
