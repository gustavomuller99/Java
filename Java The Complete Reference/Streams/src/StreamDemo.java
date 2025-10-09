import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(17);


        Stream<Integer> stream = list.stream();

        Optional<Integer> minVal = stream.min(Integer::compare);
        if (minVal.isPresent()) {
            System.out.println(minVal.get());
        }

        stream = list.stream();
        Optional<Integer> maxVal = stream.max(Integer::compare);
        if (maxVal.isPresent()) {
            System.out.println(maxVal.get());
        }

        list
                .stream()
                .sorted()
                .forEach(n -> System.out.println(n));

        list
                .stream()
                .filter(e -> e % 2 == 1)
                .forEach(n -> System.out.println(n));

        list
                .stream()
                .reduce((a, b) -> a + b);
    }
}