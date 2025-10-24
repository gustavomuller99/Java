package sportsExample;

import java.util.ArrayList;
import java.util.List;

public class CommentarySubject implements Subject, Commentary {

    private final List<Observer> observers;
    private String desc;
    private final String subjectDetails;

    public CommentarySubject(List<Observer> observers, String subjectDetails) {
        this.observers = observers;
        this.subjectDetails = subjectDetails;
    }

    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    public void unSubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(desc);
        }
    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyObservers();
    }

    public String subjectDetails() {
        return subjectDetails;
    }
}
