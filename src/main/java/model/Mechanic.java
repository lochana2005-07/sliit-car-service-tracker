package model;

public class Mechanic {

    private String mechanicID;
    private String name;
    private String type; // SeniorMechanic / JuniorMechanic
    private int experienceYears;

    // Constructor
    public Mechanic(String mechanicID, String name, String type, int experienceYears) {
        this.mechanicID = mechanicID;
        this.name = name;
        this.type = type;
        this.experienceYears = experienceYears;
    }

    // Getters
    public String getMechanicID() {
        return mechanicID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    // Display
    public void displayInfo() {
        System.out.println("Mechanic ID: " + mechanicID);
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Experience: " + experienceYears + " years");
    }
}