import java.util.ArrayList;
import java.util.Spliterator;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("Andrew");
        list.add("Bob");
        list.add("Carl");
        list.add("Dan");

        Spliterator<String> spliterator = list
                .stream()
                .spliterator();

        Spliterator<String> spliterator1 = spliterator.trySplit();

        if (spliterator1 != null) {
            spliterator1.forEachRemaining(System.out::println);
        }

        spliterator.forEachRemaining(System.out::println); // half
    }
}
