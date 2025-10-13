class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }

        System.out.println(name + " is trying to call b.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println(Thread.currentThread().getName() + " entered A last");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered bar");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }

        System.out.println(name + " is trying to call a.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println(Thread.currentThread().getName() + " entered B last");
    }
}

public class DeadlockDemo implements Runnable {

    A a = new A();
    B b = new B();
    Thread t;

    DeadlockDemo() {
        t = new Thread(this, "Racing thread");
    }

    public void run() {
        b.bar(a);
    }

    public void deadlock() {
        t.start();
        a.foo(b);
    }

    public static void main(String[] args) {
        DeadlockDemo d = new DeadlockDemo();
        d.deadlock();
    }
}
