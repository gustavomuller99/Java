interface SomeFunc<T> {
    T func(T t);
}

public class GenericFIDemo {
    public static void main(String[] args) {
        SomeFunc<Integer> integerFunc = (a) -> {
            int i = 1;
            for (int j = 1; j <= a; j++) {
                i *= j;
            }
            return i;
        };

        SomeFunc<String> stringFunc = (a) -> {
            StringBuilder result = new StringBuilder();
            for (int i = a.length() - 1; i >= 0; i--) {
                result.append(a.charAt(i));
            }
            return result.toString();
        };

        System.out.println(integerFunc.func(5));
        System.out.println(stringFunc.func("reverse"));
    }
}
