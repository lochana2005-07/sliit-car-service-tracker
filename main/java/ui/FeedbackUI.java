package ui;

import model.Feedback;
import service.FeedbackService;

import java.util.List;
import java.util.Scanner;

public class FeedbackUI {

    private FeedbackService service = new FeedbackService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n===== FEEDBACK SYSTEM =====");
            System.out.println("1. Submit Feedback");
            System.out.println("2. View All Feedback");
            System.out.println("3. Search by Vehicle");
            System.out.println("4. Update Feedback");
            System.out.println("5. Delete Feedback");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    submitFeedback();
                    break;
                case 2:
                    service.displayAllFeedback();
                    break;
                case 3:
                    searchFeedback();
                    break;
                case 4:
                    updateFeedback();
                    break;
                case 5:
                    deleteFeedback();
                    break;
                case 6:
                    System.out.println("Exiting Feedback System...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private void submitFeedback() {
        System.out.print("Feedback ID: ");
        String id = scanner.nextLine();
        System.out.print("Vehicle Number: ");
        String vehicleNo = scanner.nextLine();
        System.out.print("User Name: ");
        String user = scanner.nextLine();
        System.out.print("Comments: ");
        String comments = scanner.nextLine();
        System.out.print("Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        Feedback f = new Feedback(id, vehicleNo, user, comments, rating);
        service.addFeedback(f);
    }

    private void searchFeedback() {
        System.out.print("Enter Vehicle Number: ");
        String vehicleNo = scanner.nextLine();
        List<Feedback> list = service.searchByVehicle(vehicleNo);
        if (list.isEmpty()) {
            System.out.println("No feedback found for this vehicle.");
        } else {
            for (Feedback f : list) {
                f.displayInfo();
                System.out.println("----------------");
            }
        }
    }

    private void updateFeedback() {
        System.out.print("Feedback ID to update: ");
        String id = scanner.nextLine();
        System.out.print("New User Name: ");
        String user = scanner.nextLine();
        System.out.print("New Comments: ");
        String comments = scanner.nextLine();
        System.out.print("New Rating: ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        service.updateFeedback(id, user, comments, rating);
    }

    private void deleteFeedback() {
        System.out.print("Feedback ID to delete: ");
        String id = scanner.nextLine();
        service.deleteFeedback(id);
    }
}