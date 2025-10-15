import java.util.concurrent.atomic.AtomicInteger;

class SharedAtomic {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
}

class AtomThread implements Runnable {
    String name;
    public AtomThread(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " started");
        for (int i = 0; i < 5; i++) {
            System.out.println("Atomic integer got: " + SharedAtomic.atomicInteger.getAndSet(i));
        }
    }
}

public class AtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("B")).start();
        new Thread(new AtomThread("C")).start();
    }
}
