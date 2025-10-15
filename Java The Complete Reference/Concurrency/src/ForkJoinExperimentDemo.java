import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {
    int threshold;
    double[] data;
    int start, end;

    Transform(int threshold, double[] data,  int start, int end) {
        this.threshold = threshold;
        this.data = data;
        this.start = start;
        this.end = end;
    }

    protected void compute() {
        if (end - start <= threshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            int mid = (start + end) / 2;
            invokeAll(
                    new Transform(threshold, data, start, mid),
                    new Transform(threshold, data, mid, end));
        }
    }
}

public class ForkJoinExperimentDemo {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if (args.length != 2) {
            System.out.println("Args missing");
            return;
        }

        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        long beginT, endT;
        ForkJoinPool pool = new ForkJoinPool(pLevel);

        double[] data = new double[10000000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (double) i;
        }

        beginT = System.nanoTime();
        pool.invoke(new Transform(threshold, data, 0, data.length));
        endT = System.nanoTime();

        System.out.println("Level of parallelism: " + pLevel);
        System.out.println("Threshold of parallelism: " + threshold);
        System.out.println("Elapsed time: " + (endT - beginT) / 1000000 + "ms");
        System.out.println();
    }
}
