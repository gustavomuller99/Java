interface MinMax<T extends Comparable<T>> {
    T getMin();
    T getMax();
}

class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MinMaxImpl(T[] vals) { this.vals = vals; }

    public T getMin() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) < 0) {v = vals[i]; }
        }
        return v;
    }

    public T getMax() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) { v = vals[i]; }
        }
        return v;
    }
}

class MinMaxDemo {
    public static void main(String[] args) {
        Integer[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        MinMax<Integer> minMax = new MinMaxImpl<>(nums);

        System.out.println("nums min: " + minMax.getMin());
        System.out.println("nums max: " + minMax.getMax());
    }
}
