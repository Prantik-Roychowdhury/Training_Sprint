package Ticket_Booking_System.baseClasses;

public class Event {
    private String title;
    private int availableTickets;

    public Event(String title, int availableTickets) {
        this.title = title;
        this.availableTickets = availableTickets;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public boolean isAvailable() {
        return availableTickets > 0;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    @Override
    public String toString() {
        return "Event: " + title + " | Available Tickets: " + availableTickets;
    }
}

