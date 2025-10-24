package sportsExample;

import java.util.ArrayList;

public class ObserverDemo {
    public static void main(String[] args) {

        Subject subject = new CommentarySubject(new ArrayList<>(), "soccer match");

        Observer observer = new SmsObserver(subject, "Adam");
        observer.subscribe();

        Observer observer2 = new SmsObserver(subject, "Tim");
        observer2.subscribe();

        ((CommentarySubject) subject).setDesc("Game is starting!!");
        ((CommentarySubject) subject).setDesc("0-0");

        observer2.unSubscribe();

        ((CommentarySubject) subject).setDesc("Goal!");
        ((CommentarySubject) subject).setDesc("1-0");
    }
}
