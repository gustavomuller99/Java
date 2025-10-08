interface StringFunc {
    String func(String s);
}

public class LambdaArgumentsDemo {

    static String stringOp(StringFunc func, String s) {
        return func.func(s);
    }

    public static void main(String[] args) {
        String test = "string";
        String out;

        out = stringOp(s -> s.toUpperCase(), test);
        System.out.println(out);

        StringFunc func = (a) -> {
            StringBuilder result = new StringBuilder();
            for (int i = a.length() - 1; i >= 0; i--) {
                result.append(a.charAt(i));
            }
            return result.toString();
        };

        System.out.println(stringOp(func, test));
    }
}
