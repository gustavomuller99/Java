interface NumericTest {
    boolean test(int a);
}

public class LambdaDemo2 {
    public static void main(String[] args) {
        NumericTest isEven = (n) -> (n % 2) == 0;

        System.out.println(isEven.test(2));
        System.out.println(isEven.test(3));
    }
}
