import java.util.ArrayList;
import java.util.Iterator;

public class StreamDemo8 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("Andrew");
        list.add("Bob");
        list.add("Carl");
        list.add("Dan");

        Iterator<String> iterator = list.stream().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
