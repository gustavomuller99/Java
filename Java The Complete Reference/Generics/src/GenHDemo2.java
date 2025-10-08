class NonGen {
    int num;

    NonGen(int num) {
        this.num = num;
    }
}

class GenNonGen<T> extends NonGen {
    T ob;

    GenNonGen(T ob, int num) {
        super(num);
        this.ob = ob;
    }

    T getObj() {
        return ob;
    }
}

class GenHDemo2 {
    public static void main(String[] args) {
        GenNonGen<String> obj = new GenNonGen<>("a", 3);

        System.out.println(obj.getObj());
    }
}
