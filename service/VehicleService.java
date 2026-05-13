package service;

import model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    private static final String FILE_NAME = "vehicles.txt";

    // CREATE (Add Vehicle)
    public void addVehicle(Vehicle vehicle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(vehicle.getVehicleNumber() + "," +
                    vehicle.getBrand() + "," +
                    vehicle.getModel() + "," +
                    vehicle.getYear());
            writer.newLine();
            System.out.println("Vehicle added successfully!");
        } catch (IOException e) {
            System.out.println("Error saving vehicle.");
        }
    }

    // READ (Get all vehicles)
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Vehicle v = new Vehicle(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                );
                list.add(v);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return list;
    }

    // DISPLAY ALL
    public void displayAllVehicles() {
        List<Vehicle> vehicles = getAllVehicles();

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("-------------------");
        }
    }

    // DELETE vehicle
    public void deleteVehicle(String vehicleNumber) {
        List<Vehicle> vehicles = getAllVehicles();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Vehicle v : vehicles) {
                if (!v.getVehicleNumber().equals(vehicleNumber)) {
                    writer.write(v.getVehicleNumber() + "," +
                            v.getBrand() + "," +
                            v.getModel() + "," +
                            v.getYear());
                    writer.newLine();
                }
            }
            System.out.println("Vehicle deleted (if found).");
        } catch (IOException e) {
            System.out.println("Error deleting vehicle.");
        }
    }
    public Vehicle searchVehicle(String vehicleNumber) {
        List<Vehicle> vehicles = getAllVehicles();

        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                return v;
            }
        }
        return null;
    }

    public void updateVehicle(String vehicleNumber, String newBrand, String newModel, int newYear) {

        List<Vehicle> vehicles = getAllVehicles();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Vehicle v : vehicles) {

                if (v.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                    v.setBrand(newBrand);
                    v.setModel(newModel);
                    v.setYear(newYear);
                }

                writer.write(v.getVehicleNumber() + "," +
                        v.getBrand() + "," +
                        v.getModel() + "," +
                        v.getYear());
                writer.newLine();
            }

            System.out.println("Vehicle updated successfully!");

        } catch (IOException e) {
            System.out.println("Error updating vehicle.");
        }
    }
}