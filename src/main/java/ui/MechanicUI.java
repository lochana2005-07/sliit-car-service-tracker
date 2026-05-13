package ui;

import model.Mechanic;
import service.MechanicService;

import java.util.Scanner;

public class MechanicUI {

    private MechanicService service = new MechanicService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;
        do {
            System.out.println("\n===== MECHANIC MANAGEMENT =====");
            System.out.println("1. Add Mechanic");
            System.out.println("2. View All Mechanics");
            System.out.println("3. Search Mechanic");
            System.out.println("4. Update Mechanic");
            System.out.println("5. Delete Mechanic");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMechanic();
                    break;
                case 2:
                    service.displayAllMechanics();
                    break;
                case 3:
                    searchMechanic();
                    break;
                case 4:
                    updateMechanic();
                    break;
                case 5:
                    deleteMechanic();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    private void addMechanic() {
        System.out.print("Mechanic ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Type (Senior/Junior): ");
        String type = scanner.nextLine();

        System.out.print("Experience (years): ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        Mechanic m = new Mechanic(id, name, type, exp);
        service.addMechanic(m);
    }

    private void searchMechanic() {
        System.out.print("Enter Mechanic ID: ");
        String id = scanner.nextLine();
        Mechanic m = service.searchMechanic(id);
        if (m != null) {
            m.displayInfo();
        } else {
            System.out.println("Mechanic not found.");
        }
    }

    private void updateMechanic() {
        System.out.print("Mechanic ID to update: ");
        String id = scanner.nextLine();

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Type: ");
        String type = scanner.nextLine();

        System.out.print("New Experience: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        service.updateMechanic(id, name, type, exp);
    }

    private void deleteMechanic() {
        System.out.print("Mechanic ID to delete: ");
        String id = scanner.nextLine();
        service.deleteMechanic(id);
    }
}