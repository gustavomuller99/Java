class NewThreadSuspendResume implements Runnable {
    String name;
    Thread t;
    boolean suspended;

    NewThreadSuspendResume(String name) {
        this.name = name;
        suspended = false;
        t = new Thread(this);
        System.out.println("New thread: " + name);
    }

    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println("Thread " + name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + name);
        }
        System.out.println("Thread exited " + name);
    }

    synchronized public void suspend() {
        suspended = true;
    }

    synchronized public void resume() {
        suspended = false;
        notify();
    }
}

public class SuspendResumeDemo {
    public static void main(String[] args) {
        NewThreadSuspendResume t1 = new NewThreadSuspendResume("Thread1");
        NewThreadSuspendResume t2 = new NewThreadSuspendResume("Thread2");

        t1.t.start();
        t2.t.start();

        try {
            Thread.sleep(1000);
            t1.suspend();
            System.out.println("Suspending Thread1");

            Thread.sleep(1000);
            t1.resume();
            System.out.println("Resuming Thread1");
            t2.suspend();
            System.out.println("Suspending Thread2");

            Thread.sleep(1000);
            t2.resume();
            System.out.println("Resuming Thread2");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
