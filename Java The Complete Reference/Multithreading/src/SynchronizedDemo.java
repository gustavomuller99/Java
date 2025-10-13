class Callme {
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + Thread.currentThread().getName());
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(String msg, Callme target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
    }

    public void run() {
        target.call(msg);
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        Callme target = new Callme();

        Caller c1 = new Caller("Hello", target);
        Caller c2 = new Caller("Synchronized", target);
        Caller c3 = new Caller("World", target);

        c1.t.start();
        c2.t.start();
        c3.t.start();

        try {
            c1.t.join();
            c2.t.join();
            c3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + Thread.currentThread().getName());
        }
    }
}
