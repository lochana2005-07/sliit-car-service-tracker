package service;

import model.Feedback;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackService {

    private static final String FILE_NAME = "feedback.txt";

    // CREATE
    public void addFeedback(Feedback feedback) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(feedback.getFeedbackID() + "," +
                    feedback.getVehicleNumber() + "," +
                    feedback.getUserName() + "," +
                    feedback.getComments() + "," +
                    feedback.getRating());
            writer.newLine();
            System.out.println("Feedback submitted!");
        } catch (IOException e) {
            System.out.println("Error saving feedback.");
        }
    }

    // READ ALL
    public List<Feedback> getAllFeedback() {
        List<Feedback> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Feedback f = new Feedback(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4])
                );
                list.add(f);
            }
        } catch (IOException e) {
            System.out.println("Error reading feedback.");
        }
        return list;
    }

    // DISPLAY ALL
    public void displayAllFeedback() {
        for (Feedback f : getAllFeedback()) {
            f.displayInfo();
            System.out.println("-------------------");
        }
    }

    // SEARCH by Vehicle
    public List<Feedback> searchByVehicle(String vehicleNumber) {
        List<Feedback> result = new ArrayList<>();
        for (Feedback f : getAllFeedback()) {
            if (f.getVehicleNumber().equalsIgnoreCase(vehicleNumber)) {
                result.add(f);
            }
        }
        return result;
    }

    // UPDATE
    public void updateFeedback(String feedbackID, String newUser, String newComments, int newRating) {
        List<Feedback> list = getAllFeedback();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Feedback f : list) {
                if (f.getFeedbackID().equalsIgnoreCase(feedbackID)) {
                    f.setUserName(newUser);
                    f.setComments(newComments);
                    f.setRating(newRating);
                }
                writer.write(f.getFeedbackID() + "," +
                        f.getVehicleNumber() + "," +
                        f.getUserName() + "," +
                        f.getComments() + "," +
                        f.getRating());
                writer.newLine();
            }
            System.out.println("Feedback updated!");
        } catch (IOException e) {
            System.out.println("Error updating feedback.");
        }
    }

    // DELETE
    public void deleteFeedback(String feedbackID) {
        List<Feedback> list = getAllFeedback();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Feedback f : list) {
                if (!f.getFeedbackID().equalsIgnoreCase(feedbackID)) {
                    writer.write(f.getFeedbackID() + "," +
                            f.getVehicleNumber() + "," +
                            f.getUserName() + "," +
                            f.getComments() + "," +
                            f.getRating());
                    writer.newLine();
                }
            }
            System.out.println("Feedback deleted (if found).");
        } catch (IOException e) {
            System.out.println("Error deleting feedback.");
        }
    }
}