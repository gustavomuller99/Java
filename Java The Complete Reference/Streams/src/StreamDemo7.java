import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

class NamePhoneMail7 {
    String name;
    String phone;
    String email;

    NamePhoneMail7(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

class NamePhone7 {
    String name;
    String phone;

    NamePhone7(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<NamePhoneMail7> list = new ArrayList<NamePhoneMail7>();

        list.add(new NamePhoneMail7("name1", "phone1", "email1"));
        list.add(new NamePhoneMail7("name2", "phone2", "email2"));
        list.add(new NamePhoneMail7("name3", "phone3", "email3"));
        list.add(new NamePhoneMail7("name4", "phone4", "email4"));

        var resultList = list
                .stream()
                .map(a -> new NamePhone7(a.name, a.phone))
                .collect(Collectors.toList());

        var resultSet = list
                .stream()
                .map(a -> new NamePhone7(a.name, a.phone))
                .collect(Collectors.toSet());

        var resultList2 = list
                .stream()
                .map(a -> new NamePhone7(a.name, a.phone))
                .collect(
                        () -> new LinkedList<>(),
                        (list1, element) -> list1.add(element),
                        (list1, list2) -> list1.addAll(list2));

        resultList.forEach(x -> System.out.println(x.name + " " + x.phone));
        resultSet.forEach(x -> System.out.println(x.name + " " + x.phone));
    }
}
