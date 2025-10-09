import java.util.ArrayList;

public class StreamDemo3 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();

        list.add(3.9);
        list.add(3.8);
        list.add(3.7);

        double productSqrRoots = list.parallelStream().reduce(
                1.0,
                (a,b) -> a * Math.sqrt(b),
                (a,b) -> a * b
        );

        System.out.println(productSqrRoots);
    }
}
