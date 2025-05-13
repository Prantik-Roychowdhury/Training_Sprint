import java.util.Iterator;
import java.util.List;

@RoleRequired(role = "Admin")
public class Admin extends User {

    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Admin Profile");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }

    public void removeEvent(List<Event> events, String title) {
        try {
            // Check if the class has the RoleRequired annotation
            if (this.getClass().isAnnotationPresent(RoleRequired.class)) {
                RoleRequired role = this.getClass().getAnnotation(RoleRequired.class);
                if ("Admin".equals(role.role())) {
                    Iterator<Event> iterator = events.iterator();
                    boolean removed = false;

                    while (iterator.hasNext()) {
                        Event event = iterator.next();
                        if (event.getTitle().equalsIgnoreCase(title)) {
                            iterator.remove();
                            removed = true;
                            System.out.println("Event \"" + title + "\" removed successfully.");
                        }
                    }

                    if (!removed) {
                        System.out.println("Event \"" + title + "\" not found.");
                    }
                } else {
                    System.out.println("Access denied: Role not authorized.");
                }
            } else {
                System.out.println("Access denied: Missing @RoleRequired annotation.");
            }
        } catch (Exception e) {
            System.out.println("Error while removing event: " + e.getMessage());
        }
    }
}
