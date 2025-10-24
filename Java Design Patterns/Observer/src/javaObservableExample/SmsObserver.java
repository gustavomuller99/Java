package javaObservableExample;

import java.util.Observable;
import java.util.Observer;

public class SmsObserver implements Observer {

    private String desc;
    private final String userInfo;
    private final Observable observable;

    public SmsObserver(Observable observable, String userInfo) {
        this.observable = observable;
        this.userInfo = userInfo;
    }

    public void subscribe() {
        System.out.println("Subscribing " + userInfo + " to " + ((CommentaryObjectObservable) (observable)).subjectDetails() + " ...");
        this.observable.addObserver(this);
    }

    public void unSubscribe() {
        System.out.println("Unsubscribing " + userInfo + " to " + ((CommentaryObjectObservable) (observable)).subjectDetails() + " ...");
        this.observable.deleteObserver(this);
    }

    public void update(Observable o, Object arg) {
        desc = (String) arg;
        display();
    }

    private void display() {
        System.out.println("[" + userInfo + "]: " + desc);
    }
}
