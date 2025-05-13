package Ticket_Booking_System.baseClasses;

public class Attendee extends User
{
    Attendee(String id, String name)
    {
        super(id, name);
    }
    @Override
    void showProfile()
    {
        System.out.println("Name: "+this.name+"\nID: "+this.id);
    }
}
