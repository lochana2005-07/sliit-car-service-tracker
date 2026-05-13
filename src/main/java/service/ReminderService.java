package service;

import model.Reminder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReminderService {

    private static final String FILE_NAME = "reminders.txt";

    // CREATE
    public void addReminder(Reminder reminder) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(reminder.getVehicleNumber() + "," +
                    reminder.getMessage() + "," +
                    reminder.getReminderDate() + "," +
                    reminder.getType());
            writer.newLine();
            System.out.println("Reminder added!");
        } catch (IOException e) {
            System.out.println("Error saving reminder.");
        }
    }

    // READ
    public List<Reminder> getAllReminders() {
        List<Reminder> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Reminder r = new Reminder(
                        data[0],
                        data[1],
                        data[2],
                        data[3]
                );
                list.add(r);
            }
        } catch (IOException e) {
            System.out.println("Error reading reminders.");
        }
        return list;
    }

    // DISPLAY ALL
    public void displayAllReminders() {
        for (Reminder r : getAllReminders()) {
            r.displayInfo();
            System.out.println("-------------------");
        }
    }

    // DELETE
    public void deleteReminder(String vehicleNumber) {
        List<Reminder> list = getAllReminders();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Reminder r : list) {
                if (!r.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                    writer.write(r.getVehicleNumber() + "," +
                            r.getMessage() + "," +
                            r.getReminderDate() + "," +
                            r.getType());
                    writer.newLine();
                }
            }
            System.out.println("Reminder deleted (if found).");
        } catch (IOException e) {
            System.out.println("Error deleting reminder.");
        }
    }

    // SEARCH
    public Reminder searchByVehicle(String vehicleNumber) {
        for (Reminder r : getAllReminders()) {
            if (r.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                return r;
            }
        }
        return null;
    }

    // UPDATE
    public void updateReminder(String vehicleNumber, String newMessage, String newDate, String newType) {
        List<Reminder> list = getAllReminders();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Reminder r : list) {
                if (r.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                    r.setMessage(newMessage);
                    r.setReminderDate(newDate);
                    r.setType(newType);
                }
                writer.write(r.getVehicleNumber() + "," +
                        r.getMessage() + "," +
                        r.getReminderDate() + "," +
                        r.getType());
                writer.newLine();
            }
            System.out.println("Reminder updated!");
        } catch (IOException e) {
            System.out.println("Error updating reminder.");
        }
    }
}