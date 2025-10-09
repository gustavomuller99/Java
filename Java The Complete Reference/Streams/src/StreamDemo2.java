import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Optional<Integer> productObj = list.stream().reduce((a,b) -> a*b);
        if (productObj.isPresent()) {
            System.out.println(productObj.get());
        }

        int product = list.stream().reduce(1, (a,b) -> a*b);
        System.out.println(product);
    }
}
