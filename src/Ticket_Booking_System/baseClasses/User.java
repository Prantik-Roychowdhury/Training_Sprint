package Ticket_Booking_System.baseClasses;

abstract public class User
{
    protected String id;
    protected String name;
    User(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    abstract void showProfile();
}