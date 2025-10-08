interface Func {
    int func(int a);
}

public class VariableCaptureDemo {
    public static void main(String[] args) {
        int num = 10;

        Func lambda = (a) -> a + num;
        System.out.println(lambda.func(num));

        Func illegal = (a) -> {
            // num++; final or effectively final
            return 10;
        };

        // num = 3; removes effectively final
    }
}
