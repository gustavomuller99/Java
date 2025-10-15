import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// ForkJoinTask that transforms double -> sqrt
class SqrtTransform extends RecursiveAction {
    final int seqThreshold = 1000;

    double[] data;
    int start, end;

    SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (end - start <= seqThreshold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int mid = (start + end) / 2;
            invokeAll(
                    new SqrtTransform(data, start, mid),
                    new SqrtTransform(data, mid, end)
            );
        }
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        double[] data = new double[100000];
        for (int i = 0; i < data.length; i++) {
            data[i] = Math.random() * 100000;
        }

        System.out.println("Original data: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        SqrtTransform sqrt = new SqrtTransform(data, 0, data.length);
        pool.invoke(sqrt);

        System.out.println("Sqrt transformed: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
