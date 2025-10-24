package virtualProxyExample;

public class VirtualDemo {
    public static void main(String[] args) {

        ContactList contactList = new ContactListProxyImpl();

        Company company = new Company("ABC Company", "India", "156146456", contactList);
        System.out.println("Company Name: " + company.getCompanyName());
        System.out.println("Company Address: " + company.getCompanyAddress());
        System.out.println("Company phone: " + company.getCompanyContactNo());

        System.out.println("Requesting contact list");
        contactList = company.getContactList();

        for(Employee e : contactList.getEmployeeList()) {
            System.out.println("Employee Name: " + e.getEmployeeName());
        }
    }
}
