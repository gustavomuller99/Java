interface MyFuncRef<T> {
    int func(T[] vals, T t);
}

class ArrayOps {
    static <T> int countingMatches(T[] arr, T v) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == v) {
                count++;
            }
        }
        return count;
    }
}

public class GenericMethRefDemo {

    static <T> int myOp(MyFuncRef<T> f, T[] vals, T t) {
        return f.func(vals, t);
    }

    public static void main(String[] args) {
        Integer[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int count;

        count = GenericMethRefDemo.<Integer>myOp(ArrayOps::<Integer>countingMatches, ints, 3);

        System.out.println(count);
    }
}
