import java.util.ArrayList;

class NamePhoneMail {
    String name;
    String phone;
    String email;

    NamePhoneMail(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phone;

    NamePhone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneMail> namePhoneMails = new ArrayList<NamePhoneMail>();

        namePhoneMails.add(new NamePhoneMail("name1", "phone1", "email1"));
        namePhoneMails.add(new NamePhoneMail("name2", "phone2", "email2"));
        namePhoneMails.add(new NamePhoneMail("name3", "phone3", "email3"));

        namePhoneMails.stream().map(
                a -> new NamePhone(a.name, a.phone)
        )
        .forEach(a -> System.out.println(a.name + " " + a.phone));
    }
}
