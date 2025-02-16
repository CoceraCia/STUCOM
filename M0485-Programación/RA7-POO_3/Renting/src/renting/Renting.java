/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renting;

import java.util.*;

/**
 *
 * @author migue
 */
public class Renting {

    public static ArrayList<Vehicles> vcs = new ArrayList<>();
    
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicles> vehicles = new ArrayList<>();
        int n;
        do {

            System.out.println("1 - New vehicle");
            System.out.println("2 - Show fleet");
            System.out.println("3 - Rent vehicle");
            System.out.println("0 - Exit");
            while (true) {
                try {
                    System.out.print("Execute action -> ");
                    n = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect Value, please Input a number");
                    sc.nextLine(); //clear the buffer, if its not clear it will cause an infinite loop
                }
            }

            switch (n) {
                case 1 ->
                    newVehicle(Renting.vcs);
                case 2 ->
                    showFleet(Renting.vcs);
                case 3 ->
                    rentVehicle(Renting.vcs);
            }
        } while (n != 0);
    }

    public static void newVehicle(ArrayList<Vehicles> vcs) {
        Random ran = new Random();

        //We create arrays were we specifie the type and color based on the position
        String[] types = {"car", "truck", "motorcycle", "bike"};
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange", "Purple"};

        String color = colors[ran.nextInt(0, colors.length)];
        String type = types[ran.nextInt(0, types.length)];

        String licenseTag;
        boolean isRepeated;
        do {
            licenseTag = genLicenseTag();
            isRepeated = false;
            for (int i = 0; i < vcs.size(); i++) {
                if (vcs.get(i).getLicenseTag().equals(licenseTag)) {
                    isRepeated = true;
                }
            }
        } while (isRepeated == true);

        switch (type) {
            case "car" -> {
                String[] carManufacturers = {"Toyota", "Ford", "BMW", "Honda", "Audi"};
                vcs.add(new Car(licenseTag, color, carManufacturers[ran.nextInt(0, carManufacturers.length)], ran.nextInt(0, 6)));
            }
            case "truck" -> {
                String[] truckManufacturers = {"Volvo", "Scania", "Freightliner", "MAN", "Kenworth"};
                vcs.add(new Truck(licenseTag, color, truckManufacturers[ran.nextInt(0, truckManufacturers.length)]));
            }
            case "motorcycle" -> {
                String[] motorcycleManufacturers = {"Harley-Davidson", "Yamaha", "Kawasaki", "Ducati", "Honda"};
                vcs.add(new Motorcycle(licenseTag, color, motorcycleManufacturers[ran.nextInt(0, motorcycleManufacturers.length)], ran.nextInt(0, 1301)));
            }
            case "bike" -> {
                String[] bikeManufacturers = {"Trek", "Specialized", "Giant", "Cannondale", "Schwinn"};
                vcs.add(new Bike(licenseTag, color, bikeManufacturers[ran.nextInt(0, bikeManufacturers.length)], ran.nextBoolean()));
            }
        }
        System.out.println("VEHICLE GENERATED");
    }

    public static void showFleet(ArrayList<Vehicles> vcs) {
        for (int i = 0; i < vcs.size(); i++) {
            System.out.print(vcs.get(i).toString());
        }
    }

    public static void rentVehicle(ArrayList<Vehicles> vcs) {
        Scanner sc = new Scanner(System.in);
        boolean isFinded = false;
        do {
            System.out.print("Please introduce the vehicle to rent, introduce their LicenseTag --> ");
            String x = sc.nextLine();
            for (Vehicles vehicle : vcs) {
                if (x.equals(vehicle.getLicenseTag())) {
                    System.out.println(("Vehicle finded"));
                    isFinded = true;
                    break;
                }
            }
        } while (!isFinded);
    }

    public static String genLicenseTag() {
        //the licenseTag is going to be the same way as the spanish one -> 4 numbers and 3 letters #### ABC
        Random ran = new Random();

        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String licenseTag = "";

        for (int i = 0; i < 7; i++) {
            if (i < 4) {
                licenseTag += Integer.toString(ran.nextInt(0, 10));
            } else {
                licenseTag += alphabet[ran.nextInt(0, (alphabet.length - 1))];
            }
        }
        return licenseTag;
    }
}
