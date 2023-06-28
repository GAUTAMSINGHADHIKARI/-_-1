import java.util.Scanner;

// Class representing the Online Reservation System
public class ReservationSystem {
    // Method to handle the login form
    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Login Form ===");
        System.out.print("Enter login ID: ");
        String loginId = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Validate the login credentials (you can customize this based on your
        // requirements)
        if (loginId.equals("admin") && password.equals("password")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid login credentials. Please try again.");
            return false;
        }
    }

    // Method to handle the reservation form
    public static void makeReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Reservation Form ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();

        // Assume train name is retrieved from a database based on the train number
        String trainName = getTrainName(trainNumber);

        System.out.println("Train Name: " + trainName);

        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();

        System.out.print("Enter date of journey: ");
        String journeyDate = scanner.nextLine();

        System.out.print("Enter departure: ");
        String departure = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        // Process and store the reservation details in the database
        saveReservation(name, trainNumber, trainName, classType, journeyDate, departure, destination);

        System.out.println("Reservation successfully made!");
    }

    // Method to handle the cancellation form
    public static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cancellation Form ===");
        System.out.print("Enter PNR number: ");
        String pnrNumber = scanner.nextLine();

        // Retrieve reservation details based on the PNR number
        Reservation reservation = getReservationByPNR(pnrNumber);

        if (reservation != null) {
            System.out.println("Reservation details:");
            System.out.println(reservation.toString());

            System.out.print("Are you sure you want to cancel? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                // Perform cancellation logic and update the database
                cancelReservationByPNR(pnrNumber);
                System.out.println("Reservation successfully cancelled!");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Reservation not found for the provided PNR number.");
        }
    }

    // Helper method to retrieve train name based on train number (dummy
    // implementation)
    private static String getTrainName(String trainNumber) {
        // This method could query the database to retrieve the train name
        // Replace this with your actual implementation
        return "Sample Train Name";
    }

    // Helper method to save reservation details to the database (dummy
    // implementation)
    private static void saveReservation(String name, String trainNumber, String trainName,
            String classType, String journeyDate, String departure, String destination) {
        // This method could save the reservation details to the database
        // Replace this with your actual implementation
        System.out.println("Saving reservation details to the database...");
    }

    // Helper method to retrieve reservation by PNR number (dummy implementation)
    private static Reservation getReservationByPNR(String pnrNumber) {
        // This method could query the database to retrieve the reservation by PNR
        // number
        // Replace this with your actual implementation
        return null;
    }

    // Helper method to cancel reservation by PNR number (dummy implementation)
    private static void cancelReservationByPNR(String pnrNumber) {
        // This method could perform the cancellation logic and update the database
        // Replace this with your actual implementation
        System.out.println("Cancelling reservation...");
    }

    // Main method to run the reservation system
    public static void main(String[] args) {
        boolean isLoggedIn = false;
        Scanner scanner = new Scanner(System.in);

        while (!isLoggedIn) {
            isLoggedIn = login();
        }

        System.out.println("=== Online Reservation System ===");
        System.out.println("1. Make Reservation");
        System.out.println("2. Cancel Reservation");
        System.out.println("0. Exit");

        boolean exit = false;
        while (!exit) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the Online Reservation System!");
    }
}

// Class representing a reservation entity (you can customize this based on your
// database schema)
class Reservation {
    private String name;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String departure;
    private String destination;

    public Reservation(String name, String trainNumber, String trainName, String classType,
            String journeyDate, String departure, String destination) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nTrain Number: " + trainNumber +
                "\nTrain Name: " + trainName +
                "\nClass Type: " + classType +
                "\nJourney Date: " + journeyDate +
                "\nDeparture: " + departure +
                "\nDestination: " + destination;
    }
}
