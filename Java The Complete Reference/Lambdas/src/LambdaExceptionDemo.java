interface DoubleNumberArrayFunc {
    double func(double[] arr) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Empty array");
    }
}

public class LambdaExceptionDemo {
    public static void main(String[] args) {
        double[] arr = {1, 2, 3, 4, 5};

        DoubleNumberArrayFunc avg = (in) -> {
            double sum = 0;

            if (in.length == 0) {
                throw new EmptyArrayException();
            }

            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }

            return sum / arr.length;
        };

        try {
            System.out.println(avg.func(arr));
            avg.func(new double[0]);
        }
        catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
        }

    }
}
