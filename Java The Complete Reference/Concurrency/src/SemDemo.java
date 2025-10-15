import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new Thread(new IncThread("A", semaphore)).start();
        new Thread(new DecThread("B", semaphore)).start();
    }
}

class Shared {
    static int counter = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore semaphore;

    public IncThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for semaphore");
            semaphore.acquire();
            System.out.println(name + " semaphore acquired");

            for (int i = 0; i < 10; i++) {
                Shared.counter++;
                System.out.println(name + " counter: " + Shared.counter);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }

        System.out.println(name + " exiting");
        semaphore.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore semaphore;

    public DecThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    public void run() {
        System.out.println("Starting " + name);

        try {
            System.out.println(name + " is waiting for semaphore");
            semaphore.acquire();
            System.out.println(name + " semaphore acquired");

            for (int i = 0; i < 10; i++) {
                Shared.counter--;
                System.out.println(name + " counter: " + Shared.counter);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }

        System.out.println(name + " exiting");
        semaphore.release();
    }
}
