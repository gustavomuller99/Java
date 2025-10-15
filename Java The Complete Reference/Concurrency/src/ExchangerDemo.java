import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();

        new Thread(new MakeString(ex)).start();
        new Thread(new UseString(ex)).start();
    }
}

class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> ex) {
        this.ex = ex;
        this.str = "";
    }

    public void run() {
        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            str = "";

            for (int j = 0; j < 5; j++) {
                str += ch++;
            }

            try {
                ex.exchange(str);
            } catch (InterruptedException e) {
                System.out.println("Make String Interrupted");
            }
        }
    }
}

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> ex) {
        this.ex = ex;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange("");
                System.out.println("Got String: " + str);
            } catch (InterruptedException e) {
                System.out.println("Use String Interrupted");
            }
        }
    }
}
