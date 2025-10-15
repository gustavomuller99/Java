import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumRecursive extends RecursiveTask<Double> {
    final int threshold = 500;
    double[] data;
    int start, end;

    SumRecursive(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    protected Double compute() {
        double sum = 0.0;
        if (end - start <= threshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            SumRecursive left = new SumRecursive(data, start, middle);
            SumRecursive right = new SumRecursive(data, middle, end);

            left.fork();
            right.fork();

            sum = left.join() + right.join();
        }
        return sum;
    }
}

public class RecursiveTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] data = new double[100000];

        for (int i = 0; i < data.length; i++) {
            data[i] = (i % 2) == 0 ? i : -i;
        }

        double sum = forkJoinPool.invoke(new SumRecursive(data, 0, data.length));
        System.out.println("Sum: " + sum);
    }
}
