package Ticket_Booking_System.baseClasses;

public class Attendee extends User
{
    Attendee(String id, String name)
    {
        super(id, name);
    }
    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    @Override
    void showProfile()
    {
        System.out.println("Name: "+this.name+"\nID: "+this.id);
    }
}
