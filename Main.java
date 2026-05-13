import ui.MaintenanceUI;
import ui.ReminderUI;
import ui.ServiceUI;
import ui.VehicleUI;
import ui.MechanicUI;
import ui.FeedbackUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Vehicle Management");
            System.out.println("2. Service Scheduling");
            System.out.println("3. Maintenance History");
            System.out.println("4. Reminders");
            System.out.println("5. Mechanic Management");
            System.out.println("6. Feedback System");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    new VehicleUI().start();
                    break;
                case 2:
                    new ServiceUI().start();
                    break;
                case 3:
                    new MaintenanceUI().start();
                    break;
                case 4:
                    new ReminderUI().start();
                    break;
                case 5:
                    new MechanicUI().start();
                    break;
                case 6:
                    new FeedbackUI().start();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7); // loop until user chooses Exit
    }
}