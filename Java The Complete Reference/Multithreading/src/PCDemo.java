class Queue {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted " + Thread.currentThread().getName());
            }

        System.out.println("Got value: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int i) {
        while(valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted " + Thread.currentThread().getName());
            }

        n = i;
        System.out.println("Put value: " + n);
        valueSet = true;
        notify();
    }


}

class Producer implements Runnable {
    Queue q;
    Thread t;

    Producer(Queue q) {
        this.q = q;
        this.t = new Thread(this, "Producer");
    }

    public void run() {
        int i = 0;

        while(true) {
            q.put(++i);
        }
    }
}

class Consumer implements Runnable {
    Queue q;
    Thread t;

    Consumer(Queue q) {
        this.q = q;
        this.t = new Thread(this, "Consumer");
    }

    public void run() {
        while(true) {
            q.get();
        }
    }
}


public class PCDemo {
    public static void main(String[] args) {
        Queue q = new Queue();
        Consumer c = new Consumer(q);
        Producer p = new Producer(q);

        c.t.start();
        p.t.start();

        System.out.println("Press CTRL C to exit the program");
    }
}
