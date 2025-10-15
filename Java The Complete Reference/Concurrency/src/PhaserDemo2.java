import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int numParties, int numPhases) {
        super(numParties);
        this.numPhases = numPhases;
    }

    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase " + phase + " completed");

        if (phase == numPhases - 1 || registeredParties == 0) {
            return true;
        }

        return false;
    }
}

class MyThreadPhaser2 implements Runnable {
    Phaser phaser;
    String name;

    MyThreadPhaser2(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Thread " + name + " beginning phase " + phaser.getPhase());

            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Thread " + name + " interrupted");
            }
        }
    }
}

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser p = new MyPhaser(1, 4);

        System.out.println("Starting...");

        new Thread(new MyThreadPhaser2(p, "one")).start();
        new Thread(new MyThreadPhaser2(p, "two")).start();
        new Thread(new MyThreadPhaser2(p, "three")).start();

        while (!p.isTerminated()) {
            p.arriveAndAwaitAdvance();
        }

        System.out.println("All threads terminated");
    }
}
