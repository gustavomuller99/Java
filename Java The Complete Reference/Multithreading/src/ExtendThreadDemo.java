class NewThreadExtend extends Thread {
    NewThreadExtend() {
        super("Child Thread");
        System.out.println("Child Thread " + this);
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted");
        }
        System.out.println("Exiting Child Thread");
    }
}

public class ExtendThreadDemo {
    public static void main(String[] args) {
        NewThreadExtend thread = new NewThreadExtend();

        thread.start();

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
