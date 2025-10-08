interface MyFuncConstructor<R, T> {
    R func(T n);
}

class MyClass1<T> {
    private T val;

    MyClass1(T val) {
        this.val = val;
    }

    T getVal() {
        return val;
    }
}

class MyClass2 {
    private String val;

    MyClass2(String val) {
        this.val = val;
    }

    String getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {

    static <R, T> R myClassFactory(MyFuncConstructor<R, T> func, T n) {
        return func.func(n);
    }

    public static void main(String[] args) {

        MyFuncConstructor<MyClass1<Integer>, Integer> intCons = MyClass1::new;
        var intResult = intCons.func(10);

        MyFuncConstructor<MyClass2, String> strCons = MyClass2::new;
        var strResult = strCons.func("hello");


        System.out.println(intResult.getVal());
        System.out.println(strResult.getVal());

        var doubleResult = myClassFactory(MyClass1::new, 10.0);
        System.out.println(doubleResult.getVal());
    }
}
