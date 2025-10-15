import java.util.concurrent.Phaser;

public class PhaserDemo {
   public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currentPhase;

       System.out.println("Starting phaser...");

       new Thread(new MyThreadPhaser(phaser, "one")).start();
       new Thread(new MyThreadPhaser(phaser, "two")).start();
       new Thread(new MyThreadPhaser(phaser, "three")).start();

       currentPhase = phaser.getPhase();
       phaser.arriveAndAwaitAdvance();
       System.out.println("Phase " + currentPhase + " finished");

       currentPhase = phaser.getPhase();
       phaser.arriveAndAwaitAdvance();
       System.out.println("Phase " + currentPhase + " finished");

       currentPhase = phaser.getPhase();
       phaser.arriveAndAwaitAdvance();
       System.out.println("Phase " + currentPhase + " finished");

       phaser.arriveAndDeregister();

       if (phaser.isTerminated())
           System.out.println("Phaser terminated");
   }
}

class MyThreadPhaser implements Runnable {
    Phaser phaser;
    String name;

    MyThreadPhaser(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    public void run() {
        System.out.println("Thread " + name + " beginning phase one");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted");
        }

        System.out.println("Thread " + name + " beginning phase two");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted");
        }

        System.out.println("Thread " + name + " beginning phase three");
        phaser.arriveAndDeregister();
    }
}
