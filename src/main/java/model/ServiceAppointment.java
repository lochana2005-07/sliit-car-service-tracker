package model;

public class ServiceAppointment {

    private String vehicleNumber;
    private String serviceType;
    private String serviceDate;
    private String mechanicName;

    // Constructor
    public ServiceAppointment(String vehicleNumber, String serviceType, String serviceDate, String mechanicName) {
        this.vehicleNumber = vehicleNumber;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.mechanicName = mechanicName;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    // Setters
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    // Display
    public void displayInfo() {
        System.out.println("Vehicle: " + vehicleNumber);
        System.out.println("Service Type: " + serviceType);
        System.out.println("Date: " + serviceDate);
        System.out.println("Mechanic: " + mechanicName);
    }
}