package Ticket_Booking_System.baseClasses;

public class Organizer extends User
{
    boolean active = true;
    Organizer(String id, String name)
    {
        super(id, name);
    }
    public void setActive(boolean active)
    {
        this.active = active;
    }
    public boolean isActive()
    {
        return active;
    }
    @Override
    void showProfile()
    {
        System.out.println("Name: "+this.name+"\nID: "+this.id+"\nIs active?"+(isActive()?"Yes":"No"));
    }
}