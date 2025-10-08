
// simple generic method
class GenMethDemo {
    static <T extends  Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) {
            if (x.equals(v)) {
                return true;
            }
        }
        return false;
    }
}

class GenMethDemoRunner {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};

        if (GenMethDemo.isIn(2, nums)) {
            System.out.println("2 is in");
        }

        String[] strs = {"a", "b", "c"};

        if (GenMethDemo.isIn("a", strs)) {
            System.out.println("a is in");
        }

//        if (GenMethDemo.isIn(1, strs)) {
//        }
    }
}

