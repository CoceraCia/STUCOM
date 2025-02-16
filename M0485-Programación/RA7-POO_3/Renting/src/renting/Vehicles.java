/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package renting;

/**
 *
 * @author migue
 */
public class  Vehicles implements Rentable {
    private String licenseTag;
    private String color;
    private String manufacturer;
    private double price;
    
    
    private final int BASE_PRICE = 50; //50€ a day
    
    public Vehicles(String licenseTag, String color, String manufacturer){
        this.licenseTag = licenseTag;
        this.color = color;
        this.manufacturer = manufacturer;
        this.price = this.BASE_PRICE;
    }
    
    public int getBasePrice(){
        return this.BASE_PRICE;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getLicenseTag(){
        return this.licenseTag;
    }
    public void setLicenseTag(String licenseTag){
        this.licenseTag = licenseTag;
    }
    public String getManufacturer(){
        return this.manufacturer;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    @Override   //implemented from interface Rentable
    public double rent(int numDays) {
        return this.price * numDays;
    }
    
    @Override
    public String toString(){
        return "--------VEHICLE "+ this.getManufacturer() +
                "-------\n\tLicenseTag --> " + this.getLicenseTag()+
                "\n\tColor --> " +this.getColor();
    }
}
