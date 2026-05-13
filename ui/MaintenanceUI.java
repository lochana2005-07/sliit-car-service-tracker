package ui;

import model.MaintenanceRecord;
import service.MaintenanceService;

import java.util.List;
import java.util.Scanner;

public class MaintenanceUI {

    private MaintenanceService service = new MaintenanceService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;
        do {
            System.out.println("\n===== MAINTENANCE HISTORY =====");
            System.out.println("1. Add Record");
            System.out.println("2. View All Records");
            System.out.println("3. Search by Vehicle");
            System.out.println("4. Update Record");
            System.out.println("5. Delete Record");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addRecord();
                    break;
                case 2:
                    service.displayAllRecords();
                    break;
                case 3:
                    searchRecord();
                    break;
                case 4:
                    updateRecord();
                    break;
                case 5:
                    deleteRecord();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    private void addRecord() {
        System.out.print("Vehicle Number: ");
        String vNo = scanner.nextLine();

        System.out.print("Maintenance Type (Regular/Emergency): ");
        String type = scanner.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Cost: ");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        MaintenanceRecord r = new MaintenanceRecord(vNo, type, date, cost);
        service.addRecord(r);
    }

    private void searchRecord() {
        System.out.print("Enter Vehicle Number: ");
        String vNo = scanner.nextLine();

        List<MaintenanceRecord> list = service.searchByVehicle(vNo);
        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (MaintenanceRecord r : list) {
                r.displayInfo();
                System.out.println("----------------");
            }
        }
    }

    private void updateRecord() {
        System.out.print("Vehicle Number to update: ");
        String vNo = scanner.nextLine();

        System.out.print("New Maintenance Type: ");
        String type = scanner.nextLine();

        System.out.print("New Date: ");
        String date = scanner.nextLine();

        System.out.print("New Cost: ");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        service.updateRecord(vNo, type, date, cost);
    }

    private void deleteRecord() {
        System.out.print("Vehicle Number to delete: ");
        String vNo = scanner.nextLine();
        service.deleteRecord(vNo);
    }
}