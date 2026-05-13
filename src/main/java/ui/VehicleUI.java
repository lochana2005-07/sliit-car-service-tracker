package ui;

import model.Vehicle;
import service.VehicleService;

import java.util.Scanner;

public class VehicleUI {

    private VehicleService service = new VehicleService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;

        do {
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Update Vehicle");
            System.out.println("5. Delete Vehicle");
            System.out.println("6. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    service.displayAllVehicles();
                    break;
                case 3:
                    searchVehicle();
                    break;
                case 4:
                    updateVehicle();
                    break;
                case 5:
                    deleteVehicle();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        while (choice != 6);
    }

    private void addVehicle() {
        System.out.print("Enter Vehicle Number: ");
        String number = scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(number, brand, model, year);
        service.addVehicle(vehicle);
    }

    private void deleteVehicle() {
        System.out.print("Enter Vehicle Number to delete: ");
        String number = scanner.nextLine();
        service.deleteVehicle(number);
    }
    private void searchVehicle() {
        System.out.print("Enter Vehicle Number: ");
        String number = scanner.nextLine();

        Vehicle v = service.searchVehicle(number);

        if (v != null) {
            v.displayInfo();
        } else {
            System.out.println("Vehicle not found!");
        }
    }
    private void updateVehicle() {
        System.out.print("Enter Vehicle Number to update: ");
        String number = scanner.nextLine();

        System.out.print("Enter New Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter New Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter New Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        service.updateVehicle(number, brand, model, year);
    }
}