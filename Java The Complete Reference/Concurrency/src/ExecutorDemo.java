import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadExecutor implements Runnable {
    String threadName;
    CountDownLatch countDownLatch;

    MyThreadExecutor(String threadName, CountDownLatch countDownLatch) {
        this.threadName = threadName;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + ": " + i);
            countDownLatch.countDown();
        }
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new MyThreadExecutor("Thread1", cd1));
        executor.execute(new MyThreadExecutor("Thread2", cd2));
        executor.execute(new MyThreadExecutor("Thread3", cd3));
        executor.execute(new MyThreadExecutor("Thread4", cd4));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("Main thread completed");
    }
}
