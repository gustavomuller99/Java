import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyThreadBarrier implements Runnable {
    CyclicBarrier barrier;
    String name;

    MyThreadBarrier(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    public void run() {
        System.out.println(name + " is running");

        try {
            barrier.await();
        } catch (InterruptedException e) {
            System.out.println(name + " is interrupted");
        } catch (BrokenBarrierException e) {
            System.out.println(name + " is broken");
        }
    }
}

class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier reached.");
    }
}

public class BarDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarAction());

        System.out.println("Started");

        new Thread(new MyThreadBarrier(barrier, "Barrier Thread 1")).start();
        new Thread(new MyThreadBarrier(barrier, "Barrier Thread 2")).start();
        new Thread(new MyThreadBarrier(barrier, "Barrier Thread 3")).start();

        Thread.sleep(10);

        new Thread(new MyThreadBarrier(barrier, "Barrier Thread 4")).start();
        new Thread(new MyThreadBarrier(barrier, "Barrier Thread 5")).start();
        new Thread(new MyThreadBarrier(barrier, "Barrier Thread 6")).start();
    }
}
