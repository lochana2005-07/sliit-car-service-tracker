package ui;

import model.Reminder;
import service.ReminderService;

import java.util.Scanner;

public class ReminderUI {

    private ReminderService service = new ReminderService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;
        do {
            System.out.println("\n===== REMINDER SYSTEM =====");
            System.out.println("1. Add Reminder");
            System.out.println("2. View All Reminders");
            System.out.println("3. Search Reminder");
            System.out.println("4. Update Reminder");
            System.out.println("5. Delete Reminder");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addReminder();
                    break;
                case 2:
                    service.displayAllReminders();
                    break;
                case 3:
                    searchReminder();
                    break;
                case 4:
                    updateReminder();
                    break;
                case 5:
                    deleteReminder();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    private void addReminder() {
        System.out.print("Vehicle Number: ");
        String vNo = scanner.nextLine();

        System.out.print("Message: ");
        String message = scanner.nextLine();

        System.out.print("Reminder Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Type (Email/System): ");
        String type = scanner.nextLine();

        Reminder r = new Reminder(vNo, message, date, type);
        service.addReminder(r);
    }

    private void searchReminder() {
        System.out.print("Vehicle Number: ");
        String vNo = scanner.nextLine();

        Reminder r = service.searchByVehicle(vNo);
        if (r != null) {
            r.displayInfo();
        } else {
            System.out.println("Reminder not found.");
        }
    }

    private void updateReminder() {
        System.out.print("Vehicle Number to update: ");
        String vNo = scanner.nextLine();

        System.out.print("New Message: ");
        String message = scanner.nextLine();

        System.out.print("New Date: ");
        String date = scanner.nextLine();

        System.out.print("New Type: ");
        String type = scanner.nextLine();

        service.updateReminder(vNo, message, date, type);
    }

    private void deleteReminder() {
        System.out.print("Vehicle Number to delete: ");
        String vNo = scanner.nextLine();
        service.deleteReminder(vNo);
    }
}