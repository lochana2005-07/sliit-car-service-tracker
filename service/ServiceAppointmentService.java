package service;

import model.ServiceAppointment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppointmentService {

    private static final String FILE_NAME = "services.txt";

    // CREATE
    public void addService(ServiceAppointment service) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(service.getVehicleNumber() + "," +
                    service.getServiceType() + "," +
                    service.getServiceDate() + "," +
                    service.getMechanicName());
            writer.newLine();
            System.out.println("Service booked successfully!");
        } catch (IOException e) {
            System.out.println("Error saving service.");
        }
    }

    // READ
    public List<ServiceAppointment> getAllServices() {
        List<ServiceAppointment> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                ServiceAppointment s = new ServiceAppointment(
                        data[0],
                        data[1],
                        data[2],
                        data[3]
                );

                list.add(s);
            }

        } catch (IOException e) {
            System.out.println("Error reading services.");
        }

        return list;
    }

    // DISPLAY
    public void displayAllServices() {
        List<ServiceAppointment> services = getAllServices();

        for (ServiceAppointment s : services) {
            s.displayInfo();
            System.out.println("-------------------");
        }
    }
    public List<ServiceAppointment> searchByVehicle(String vehicleNumber) {
        List<ServiceAppointment> result = new ArrayList<>();

        for (ServiceAppointment s : getAllServices()) {
            if (s.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                result.add(s);
            }
        }

        return result;
    }
    public void updateService(String vehicleNumber, String newType, String newDate, String newMechanic) {

        List<ServiceAppointment> services = getAllServices();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (ServiceAppointment s : services) {

                if (s.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                    s.setServiceType(newType);
                    s.setServiceDate(newDate);
                    s.setMechanicName(newMechanic);
                }

                writer.write(s.getVehicleNumber() + "," +
                        s.getServiceType() + "," +
                        s.getServiceDate() + "," +
                        s.getMechanicName());
                writer.newLine();
            }

            System.out.println("Service updated!");

        } catch (IOException e) {
            System.out.println("Error updating service.");
        }
    }
    public void deleteService(String vehicleNumber) {

        List<ServiceAppointment> services = getAllServices();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (ServiceAppointment s : services) {

                if (!s.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                    writer.write(s.getVehicleNumber() + "," +
                            s.getServiceType() + "," +
                            s.getServiceDate() + "," +
                            s.getMechanicName());
                    writer.newLine();
                }
            }

            System.out.println("Service deleted (if found).");

        } catch (IOException e) {
            System.out.println("Error deleting service.");
        }
    }
}