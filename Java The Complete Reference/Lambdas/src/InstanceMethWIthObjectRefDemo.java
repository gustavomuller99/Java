interface MyFunc<T> {
    boolean func(T v1, T v2);
}

class Temp {
    private int temp;

    Temp(int temp) {
        this.temp = temp;
    }

    boolean sameTemp(Temp temp2) {
        return this.temp == temp2.temp;
    }
}

public class InstanceMethWIthObjectRefDemo {

    static <T> int counter(T[] vals, MyFunc<T> func, T v) {
        int counter = 0;

        for (int i = 0; i < vals.length; i++) {
            if (func.func(vals[i], v)) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Temp[] vals = { new Temp(1), new Temp(2), new Temp(3), new Temp(4), new Temp(5) };

        var count = InstanceMethWIthObjectRefDemo.<Temp>counter(vals, Temp::sameTemp, new Temp(3));

        System.out.println(count);
    }
}
