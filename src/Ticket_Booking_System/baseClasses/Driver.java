package Ticket_Booking_System.baseClasses;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        EventBookingSystem bookingSystem = new EventBookingSystem();
        Scanner scanner = new Scanner(System.in);

        bookingSystem.loadEvents();
        
        boolean flag=true;
        while (flag==true) {
            System.out.println("Event Ticket Booking System");
            System.out.println("1. Register Attendee");
            System.out.println("2. Add Event");
            System.out.println("3. Book Ticket");
            System.out.println("4. Show Events");
            System.out.println("5. Save & Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerAttendee(bookingSystem, scanner);
                    break;
                case "2":
                    addEvent(bookingSystem, scanner);
                    break;
                case "3":
                    bookTicket(bookingSystem, scanner);
                    break;
                case "4":
                    bookingSystem.showEvents();
                    break;
                case "5":
                    bookingSystem.saveEvents();
                    System.out.println("Data saved successfully.");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerAttendee(EventBookingSystem system, Scanner scanner) {
        System.out.print("Enter Attendee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Attendee Name: ");
        String name = scanner.nextLine();
        system.registerUser(id, name, "Attendee");
    }

    private static void addEvent(EventBookingSystem system, Scanner scanner) {
        System.out.print("Enter Event Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Number of Tickets: ");
        int tickets = Integer.parseInt(scanner.nextLine());
        system.addEvent(title, tickets);
    }

    private static void bookTicket(EventBookingSystem system, Scanner scanner) {
        System.out.print("Enter Attendee ID: ");
        String attendeeId = scanner.nextLine();
        System.out.print("Enter Event Title: ");
        String eventTitle = scanner.nextLine();
        system.bookTicket(attendeeId, eventTitle);
    }
}
