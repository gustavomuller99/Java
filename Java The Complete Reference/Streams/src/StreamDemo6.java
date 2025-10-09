import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);

        list.forEach(System.out::println);

        IntStream stream = list.stream().mapToInt(d -> (int) Math.ceil(d));

        stream.forEach(System.out::println);

    }
}
