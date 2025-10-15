import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    public void run() {
        System.out.println("Thread " + name + " is running");
        try {
            System.out.println("Thread " + name + " is waiting for lock");
            lock.lock();
            System.out.println("Thread " + name + " is locked");

            SharedCounter.count++;
            System.out.println("Counter " + SharedCounter.count);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + name + " is unlocking");
            lock.unlock();
        }
    }
}

class SharedCounter {
    static int count = 0;
}

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(new LockThread("A", lock)).start();
        new Thread(new LockThread("B", lock)).start();


    }
}
