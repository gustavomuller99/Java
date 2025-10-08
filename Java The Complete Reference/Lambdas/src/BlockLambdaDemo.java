interface NumericTest4 {
    int func(int n);
}

public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericTest4 fact = (n) -> {
            int i = 1;
            for (int j = 1; j <= n; j++) {
                i *= j;
            }
            return i;
        };

        System.out.println(fact.func(4));
    }
}
