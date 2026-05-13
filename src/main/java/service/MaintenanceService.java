package service;

import model.MaintenanceRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceService {

    private static final String FILE_NAME = "maintenance_history.txt";

    // CREATE
    public void addRecord(MaintenanceRecord record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(record.getVehicleNumber() + "," +
                    record.getMaintenanceType() + "," +
                    record.getMaintenanceDate() + "," +
                    record.getCost());
            writer.newLine();
            System.out.println("Maintenance record added!");
        } catch (IOException e) {
            System.out.println("Error saving record.");
        }
    }

    // READ ALL
    public List<MaintenanceRecord> getAllRecords() {
        List<MaintenanceRecord> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                MaintenanceRecord r = new MaintenanceRecord(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                );
                list.add(r);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return list;
    }

    // DISPLAY ALL
    public void displayAllRecords() {
        List<MaintenanceRecord> records = getAllRecords();
        for (MaintenanceRecord r : records) {
            r.displayInfo();
            System.out.println("-------------------");
        }
    }

    // DELETE
    public void deleteRecord(String vehicleNumber) {
        List<MaintenanceRecord> records = getAllRecords();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (MaintenanceRecord r : records) {
                if (!r.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                    writer.write(r.getVehicleNumber() + "," +
                            r.getMaintenanceType() + "," +
                            r.getMaintenanceDate() + "," +
                            r.getCost());
                    writer.newLine();
                }
            }
            System.out.println("Record deleted (if found).");
        } catch (IOException e) {
            System.out.println("Error deleting record.");
        }
    }

    // SEARCH
    public List<MaintenanceRecord> searchByVehicle(String vehicleNumber) {
        List<MaintenanceRecord> result = new ArrayList<>();
        for (MaintenanceRecord r : getAllRecords()) {
            if (r.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                result.add(r);
            }
        }
        return result;
    }

    // UPDATE
    public void updateRecord(String vehicleNumber, String newType, String newDate, double newCost) {
        List<MaintenanceRecord> records = getAllRecords();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (MaintenanceRecord r : records) {
                if (r.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                    r.setMaintenanceType(newType);
                    r.setMaintenanceDate(newDate);
                    r.setCost(newCost);
                }
                writer.write(r.getVehicleNumber() + "," +
                        r.getMaintenanceType() + "," +
                        r.getMaintenanceDate() + "," +
                        r.getCost());
                writer.newLine();
            }
            System.out.println("Record updated!");
        } catch (IOException e) {
            System.out.println("Error updating record.");
        }
    }
}