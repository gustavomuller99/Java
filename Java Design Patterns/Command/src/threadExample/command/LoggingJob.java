package threadExample.command;

import threadExample.actions.Logging;

public class LoggingJob implements Job {
    private Logging logging;

    public void setLogging(Logging logging) {
        this.logging = logging;
    }

    public void run() {
        System.out.println("Job ID: " + Thread.currentThread() + " executing logging jobs.");
        if (logging != null) {
            logging.log();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
