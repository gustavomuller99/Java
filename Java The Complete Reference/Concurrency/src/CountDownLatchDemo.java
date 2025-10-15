import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable {
    CountDownLatch countDownLatch;

    MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            countDownLatch.countDown();
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        new Thread(new MyThread(countDownLatch)).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Done");
    }
}
