import java.util.concurrent.*;

class Sum implements Callable<Integer> {
    int stop;

    Sum(int stop) {
        this.stop = stop;
    }

    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}

class Hypot implements Callable<Double> {
    double side1, side2;

    Hypot(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Double call() {
        return Math.sqrt(side1*side1 + side2*side2);
    }
}

class Factorial implements Callable<Integer> {
    int stop;

    Factorial(int stop) {
        this.stop = stop;
    }

    public Integer call() {
        int factorial = 1;
        for (int i = 1; i <= stop; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> sum;
        Future<Double> hypot;
        Future<Integer> factorial;

        System.out.println("Starting");
        sum = executor.submit(new Sum(5));
        hypot = executor.submit(new Hypot(3, 4));
        factorial = executor.submit(new Factorial(5));

        try {
            System.out.println(sum.get());
            System.out.println(hypot.get());
            System.out.println(factorial.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("Finished");
    }
}
