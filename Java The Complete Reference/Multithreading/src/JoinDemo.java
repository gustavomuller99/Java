class NewThreadJoin implements Runnable {
    String name;
    Thread t;

    NewThreadJoin(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + t.getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + t.getName());
        }
        System.out.println("Thread exiting " + t.getName());
    }
}

public class JoinDemo {
    public static void main(String[] args) {
        NewThreadJoin thread1 = new NewThreadJoin("Thread1");
        NewThreadJoin thread2 = new NewThreadJoin("Thread2");
        NewThreadJoin thread3 = new NewThreadJoin("Thread3");

        thread1.t.start();
        thread2.t.start();
        thread3.t.start();

        System.out.println("Thread " + thread1.t.getName() + " is alive: " + thread1.t.isAlive());
        System.out.println("Thread " + thread2.t.getName() + " is alive: " + thread2.t.isAlive());
        System.out.println("Thread " + thread3.t.getName() + " is alive:" + thread3.t.isAlive());

        try {
            System.out.println("Waiting to join");
            thread1.t.join();
            thread2.t.join();
            thread3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Thread " + thread1.t.getName() + " is alive: " + thread1.t.isAlive());
        System.out.println("Thread " + thread2.t.getName() + " is alive: " + thread2.t.isAlive());
        System.out.println("Thread " + thread3.t.getName() + " is alive: " + thread3.t.isAlive());

        System.out.println("Main thread exiting");
    }
}
