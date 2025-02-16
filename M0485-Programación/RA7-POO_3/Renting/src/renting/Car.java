/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renting;

/**
 *
 * @author migue
 */
public class Car extends Vehicles {
    private int seats;
    
    public Car(String licenseTag, String color, String manufacturer, int seats){
        super(licenseTag, color, manufacturer);
        this.seats = seats;
        modifiePrice(seats);
    }
    
    //everytime a seat is modified, the price has to change too
    public void setSeats(int seats){
        this.seats = seats;
        modifiePrice(seats);
    }
    
    public int getSeats(){
        return this.seats;
    }
    
    
    private void modifiePrice(int seats){
        //we are going to apply the price based on the basePrice + (the number of seats * 1.5€)
        double price = this.getPrice() + (1.5*seats);
        this.setPrice(price);
    }
    
    @Override
    public String toString(){
        return "CAR "+ this.getManufacturer() +
                "\n\t- LicenseTag --> " + this.getLicenseTag()+
                "\n\t- Color --> " +this.getColor() +
                "\n\t- Number of seats --> " +this.seats+"\n";
    }
}
