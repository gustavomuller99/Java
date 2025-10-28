package accessExample;

import accessExample.accessControl.AccessControl;
import accessExample.accessControl.AccessControlProvider;

public class Demo {
    public static void main(String[] args) {
        AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("USER");
        User user = new User("accessExample.User A", "USER Level", userAccessControl);
        System.out.println(user);

        System.out.println("************************************");

        userAccessControl = AccessControlProvider.getAccessControlObject("USER");
        user = new User("accessExample.User B", "USER Level", userAccessControl);
        System.out.println("Changing access control of: " + user.getUserName());
        user.getAccessControl().setAccess("READ REPORTS");
        System.out.println(user);

        System.out.println("************************************");

        AccessControl managerAccessControl = AccessControlProvider.getAccessControlObject("MANAGER");
        user = new User("accessExample.User C", "MANAGER Level", managerAccessControl);
        System.out.println(user);
    }
}
