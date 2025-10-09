import java.util.ArrayList;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<Double>();

        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);

        var reduce = numbers
                .stream()
                .map(a -> Math.sqrt(a))
                .reduce((a,b) -> a*b);

        System.out.println(reduce.get());
    }
}
