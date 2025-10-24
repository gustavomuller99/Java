package sportsExample;

public class SmsObserver implements Observer {

    private final Subject subject;
    private String desc;
    private String userInfo;

    public SmsObserver(Subject subject, String userInfo) {
        this.subject = subject;
        this.userInfo = userInfo;
    }

    public void update(String desc) {
        this.desc = desc;
        display();
    }

    private void display() {
        System.out.println("[" + userInfo + "] " + desc);
    }

    public void subscribe() {
        System.out.println("[" + userInfo + "] subscribed to " + subject.subjectDetails());
        subject.subscribeObserver(this);
    }

    public void unSubscribe() {
        System.out.println("[" + userInfo + "] unsubscribed to " + subject.subjectDetails());
        subject.unSubscribeObserver(this);
    }
}
