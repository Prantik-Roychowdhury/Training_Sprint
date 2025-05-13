package booking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidBookingException {
        EventBookingSystem system = new EventBookingSystem();
        system.loadEvents();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Event Ticket Booking System ---");
            System.out.println("1. Register Attendee");
            System.out.println("2. Add Event");
            System.out.println("3. Book Ticket");
            System.out.println("4. Show Events");
            System.out.println("5. Save & Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
			    case 1:
			        System.out.print("Enter Attendee ID: ");
			        String aId = scanner.nextLine();
			        System.out.print("Enter Attendee Name: ");
			        String aName = scanner.nextLine();
			        system.registerUser(new Attendee(aId, aName));
			        break;
			    case 2:
			        System.out.print("Enter Event Title: ");
			        String title = scanner.nextLine();
			        System.out.print("Enter Number of Tickets: ");
			        int tickets = scanner.nextInt();
			        scanner.nextLine();
			        system.addEvent(new Event(title, tickets));
			        break;
			    case 3:
			        System.out.print("Enter Attendee ID: ");
			        String attId = scanner.nextLine();
			        System.out.print("Enter Event Title: ");
			        String evTitle = scanner.nextLine();
			        system.bookTicket(attId, evTitle);
			        break;
			    case 4:
			        system.showEvents();
			        break;
			    case 5:
			        system.saveEvents();
			        System.out.println("Exiting...");
			        return;
			    default:
			        System.out.println("Invalid option.");
			}
        }
    }
}

