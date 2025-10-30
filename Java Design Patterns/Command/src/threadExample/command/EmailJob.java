package threadExample.command;

import threadExample.actions.Email;

public class EmailJob implements Job {
    private Email email;

    public void setEmail(Email email) {
        this.email = email;
    }

    public void run() {
        System.out.println("Job ID: " + Thread.currentThread() + " executing email jobs.");
        if (email != null) {
            email.sendEmail();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
