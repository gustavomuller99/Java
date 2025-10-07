class GenCons {
    private double val;

    <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val);
    }
}

class GenConsDemo {
    public static void main(String[] args) {
        GenCons obj = new GenCons(3.14);
        GenCons obj2 = new GenCons(2);

        obj.showVal();
        obj2.showVal();
    }
}
