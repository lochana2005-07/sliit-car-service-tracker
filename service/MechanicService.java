package service;

import model.Mechanic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MechanicService {

    private static final String FILE_NAME = "mechanics.txt";

    // CREATE
    public void addMechanic(Mechanic mechanic) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(mechanic.getMechanicID() + "," +
                    mechanic.getName() + "," +
                    mechanic.getType() + "," +
                    mechanic.getExperienceYears());
            writer.newLine();
            System.out.println("Mechanic added!");
        } catch (IOException e) {
            System.out.println("Error saving mechanic.");
        }
    }

    // READ ALL
    public List<Mechanic> getAllMechanics() {
        List<Mechanic> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Mechanic m = new Mechanic(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                );
                list.add(m);
            }
        } catch (IOException e) {
            System.out.println("Error reading mechanics.");
        }
        return list;
    }

    // DISPLAY ALL
    public void displayAllMechanics() {
        for (Mechanic m : getAllMechanics()) {
            m.displayInfo();
            System.out.println("-------------------");
        }
    }

    // SEARCH
    public Mechanic searchMechanic(String mechanicID) {
        for (Mechanic m : getAllMechanics()) {
            if (m.getMechanicID().equalsIgnoreCase(mechanicID)) {
                return m;
            }
        }
        return null;
    }

    // UPDATE
    public void updateMechanic(String mechanicID, String newName, String newType, int newExperience) {
        List<Mechanic> list = getAllMechanics();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Mechanic m : list) {
                if (m.getMechanicID().equalsIgnoreCase(mechanicID)) {
                    m.setName(newName);
                    m.setType(newType);
                    m.setExperienceYears(newExperience);
                }
                writer.write(m.getMechanicID() + "," +
                        m.getName() + "," +
                        m.getType() + "," +
                        m.getExperienceYears());
                writer.newLine();
            }
            System.out.println("Mechanic updated!");
        } catch (IOException e) {
            System.out.println("Error updating mechanic.");
        }
    }

    // DELETE
    public void deleteMechanic(String mechanicID) {
        List<Mechanic> list = getAllMechanics();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Mechanic m : list) {
                if (!m.getMechanicID().equalsIgnoreCase(mechanicID)) {
                    writer.write(m.getMechanicID() + "," +
                            m.getName() + "," +
                            m.getType() + "," +
                            m.getExperienceYears());
                    writer.newLine();
                }
            }
            System.out.println("Mechanic deleted (if found).");
        } catch (IOException e) {
            System.out.println("Error deleting mechanic.");
        }
    }
}