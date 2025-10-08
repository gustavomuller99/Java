interface MyFuncCons {
    MyClassCons func(int n);
}

class MyClassCons {
    private int val;

    MyClassCons(int val) {
        this.val = val;
    }

    MyClassCons() {
        this.val = 0;
    }

    int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {

    public static void main(String[] args) {

        MyFuncCons func = MyClassCons::new;

        MyClassCons number = func.func(5);

        System.out.println(number.getVal());
    }


}
