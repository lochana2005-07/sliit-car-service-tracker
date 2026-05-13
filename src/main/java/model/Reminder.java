package model;

public class Reminder {

    private String vehicleNumber;
    private String message;
    private String reminderDate; // YYYY-MM-DD
    private String type; // Email / System notification

    // Constructor
    public Reminder(String vehicleNumber, String message, String reminderDate, String type) {
        this.vehicleNumber = vehicleNumber;
        this.message = message;
        this.reminderDate = reminderDate;
        this.type = type;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getReminderDate() {
        return reminderDate;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Display
    public void displayInfo() {
        System.out.println("Vehicle: " + vehicleNumber);
        System.out.println("Message: " + message);
        System.out.println("Date: " + reminderDate);
        System.out.println("Type: " + type);
    }
}