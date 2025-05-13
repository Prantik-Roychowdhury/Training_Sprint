package Ticket_Booking_System.baseClasses;

import java.io.*;
import java.util.*;

public class EventBookingSystem {
    private List<Attendee> attendees;
    private List<Organizer> organizers;
    private List<Event> events;
    private List<Ticket> tickets;

    public EventBookingSystem() {
        attendees = new ArrayList<>();
        organizers = new ArrayList<>();
        events = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void registerUser(String id, String name, String userType) {
        if (userType.equalsIgnoreCase("Attendee")) {
            Attendee attendee = new Attendee(id, name);
            attendees.add(attendee);
            System.out.println("Attendee registered successfully.");
        } else if (userType.equalsIgnoreCase("Organizer")) {
            Organizer organizer = new Organizer(id, name);
            organizers.add(organizer);
            System.out.println("Organizer registered successfully.");
        } else {
            System.out.println("Invalid user type.");
        }
    }

    public void addEvent(String title, int availableTickets) {
        Event event = new Event(title, availableTickets);
        events.add(event);
        System.out.println("Event added successfully.");
    }
    
    public void bookTicket(String attendeeId, String eventTitle) {
        Attendee attendee = findAttendeeById(attendeeId);
        Event event = findEventByTitle(eventTitle);

        if (attendee == null) {
            System.out.println("Attendee not found.");
            return;
        }

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        if (event.isAvailable()) {
            Ticket ticket = new Ticket(attendee, event);
            tickets.add(ticket);
            event.setAvailableTickets(event.getAvailableTickets() - 1);
            System.out.println("Ticket booked successfully.");
        } else {
            System.out.println("No tickets available for this event.");
        }
    }

    public void showEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            System.out.println("Available Events:");
            for (Event event : events) {
                System.out.println("Title: " + event.getTitle() + ", Tickets Available: " + event.getAvailableTickets());
            }
        }
    }

    public void saveEvents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("events.dat"))) {
            oos.writeObject(events);
            System.out.println("Events saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    public void loadEvents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("events.dat"))) {
            events = (List<Event>) ois.readObject();
            System.out.println("Events loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading events: " + e.getMessage());
        }
    }

    private Attendee findAttendeeById(String id) {
        for (Attendee attendee : attendees) {
            if (attendee.getId().equals(id)) {
                return attendee;
            }
        }
        return null;
    }

    private Event findEventByTitle(String title) {
        for (Event event : events) {
            if (event.getTitle().equalsIgnoreCase(title)) {
                return event;
            }
        }
        return null;
    }
}
