package model;

public class Vehicle {
    private String vehicleNumber;
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Vehicle(String vehicleNumber, String brand, String model, int year) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}