import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class MyClass {
    private int val;

    MyClass(int val) {
        this.val = val;
    }

    int getVal() {
        return val;
    }
}

public class UseMethodRef {

    static int compare(MyClass obj1, MyClass obj2) {
        return obj1.getVal() - obj2.getVal();
    }

    public static void main(String[] args) {
        MyClass[] list = {new MyClass(1), new MyClass(2), new MyClass(3), new MyClass(4), new MyClass(5), new MyClass(6)};

        var max = Collections.max(Arrays.asList(list), UseMethodRef::compare);

        System.out.println(max.getVal());
    }
}
