class Gen<T> {
    T ob;

    Gen(T ob) {
        this.ob = ob;
    }
}

class RawDemo {
    public static void main(String[] args) {

        Gen raw = new Gen(Integer.valueOf(3));
        Integer value = (Integer) raw.ob;

        System.out.println(value);
    }
}
