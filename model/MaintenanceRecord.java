package model;

public class MaintenanceRecord {

    private String vehicleNumber;
    private String maintenanceType; // Regular / Emergency
    private String maintenanceDate;
    private double cost;

    // Constructor
    public MaintenanceRecord(String vehicleNumber, String maintenanceType, String maintenanceDate, double cost) {
        this.vehicleNumber = vehicleNumber;
        this.maintenanceType = maintenanceType;
        this.maintenanceDate = maintenanceDate;
        this.cost = cost;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public double getCost() {
        return cost;
    }

    // Setters
    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // Display
    public void displayInfo() {
        System.out.println("Vehicle: " + vehicleNumber);
        System.out.println("Maintenance Type: " + maintenanceType);
        System.out.println("Date: " + maintenanceDate);
        System.out.println("Cost: $" + cost);
    }
}