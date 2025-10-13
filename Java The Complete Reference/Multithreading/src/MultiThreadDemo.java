class NewThreadMulti implements Runnable {
    String name;
    Thread t;

    NewThreadMulti(String name) {
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

public class MultiThreadDemo {
    public static void main(String[] args) {
        NewThreadMulti thread1 = new NewThreadMulti("Thread1");
        NewThreadMulti thread2 = new NewThreadMulti("Thread2");
        NewThreadMulti thread3 = new NewThreadMulti("Thread3");

        thread1.t.start();
        thread2.t.start();
        thread3.t.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread exiting");
    }
}
