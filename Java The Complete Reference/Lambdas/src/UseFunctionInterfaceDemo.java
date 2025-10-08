import java.util.function.Function;

public class UseFunctionInterfaceDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> fun = (n) -> {
            int i = 1;
            for (int j = 1; j <= n; j++) {
                i *= j;
            }
            return i;
        };

        System.out.println(fun.apply(5));
    }
}
