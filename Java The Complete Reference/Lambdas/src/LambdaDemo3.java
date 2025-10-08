interface NumericTest3 {
    boolean test(int a, int b);
}

public class LambdaDemo3 {
    public static void main(String[] args) {
        NumericTest3 isFactor = (a, b) -> (a % b) == 0;

        System.out.println(isFactor.test(1, 2));
        System.out.println(isFactor.test(4, 2));
    }
}
