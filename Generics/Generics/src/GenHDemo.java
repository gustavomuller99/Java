class GenH<T> {
    T ob;

    GenH(T ob) {
        this.ob = ob;
    }

    T getOb() {
        return ob;
    }
}

class GenH2<T, V> extends GenH<T> {
    V ob;

    GenH2(T ob, V ob2) {
        super(ob);
        this.ob = ob2;
    }

    V getOb2() {
        return ob;
    }
}

class GenHDemo {
    public static void main(String[] args) {
        GenH<Integer> gen = new GenH2<>(3, "a");
        System.out.println(gen.getOb());
    }
}
