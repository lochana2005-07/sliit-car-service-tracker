package ui;

import model.ServiceAppointment;
import service.ServiceAppointmentService;

import java.util.List;
import java.util.Scanner;

public class ServiceUI {

    private ServiceAppointmentService service = new ServiceAppointmentService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;

        do {
            System.out.println("\n===== SERVICE MANAGEMENT =====");
            System.out.println("1. Book Service");
            System.out.println("2. View All Services");
            System.out.println("3. Search by Vehicle");
            System.out.println("4. Update Service");
            System.out.println("5. Delete Service");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addService();
                    break;
                case 2:
                    service.displayAllServices();
                    break;
                case 3:
                    searchService();
                    break;
                case 4:
                    updateService();
                    break;
                case 5:
                    deleteService();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    private void addService() {
        System.out.print("Vehicle Number: ");
        String vNo = scanner.nextLine();

        System.out.print("Service Type: ");
        String type = scanner.nextLine();

        System.out.print("Service Date: ");
        String date = scanner.nextLine();

        System.out.print("Mechanic Name: ");
        String mech = scanner.nextLine();

        ServiceAppointment s = new ServiceAppointment(vNo, type, date, mech);
        service.addService(s);
    }

    private void searchService() {
        System.out.print("Enter Vehicle Number: ");
        String vNo = scanner.nextLine();

        List<ServiceAppointment> list = service.searchByVehicle(vNo);

        if (list.isEmpty()) {
            System.out.println("No services found.");
        } else {
            for (ServiceAppointment s : list) {
                s.displayInfo();
                System.out.println("----------------");
            }
        }
    }

    private void updateService() {
        System.out.print("Vehicle Number: ");
        String vNo = scanner.nextLine();

        System.out.print("New Service Type: ");
        String type = scanner.nextLine();

        System.out.print("New Date: ");
        String date = scanner.nextLine();

        System.out.print("New Mechanic: ");
        String mech = scanner.nextLine();

        service.updateService(vNo, type, date, mech);
    }

    private void deleteService() {
        System.out.print("Vehicle Number: ");
        String vNo = scanner.nextLine();
        service.deleteService(vNo);
    }
}