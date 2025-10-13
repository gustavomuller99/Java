class NewThread implements Runnable {
    Thread t;

    public NewThread() {
        t = new Thread(this, "New Thread");
        System.out.println("New Thread instantiated");
    }

    public void run() {
        try {
            for (int i = 1; i < 5; i++) {
                System.out.println("Child thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Child terminated");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        NewThread t1 = new NewThread();

        t1.t.start();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main thread " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread terminated");
    }
}
