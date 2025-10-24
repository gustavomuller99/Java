package javaObservableExample;

public class ObservableDemo {
    public static void main(String[] args) {
        CommentaryObjectObservable obj = new CommentaryObjectObservable("Soccer Match[2014AUG24]");
        SmsObserver observer = new SmsObserver(obj, "Adam Warner [New York]");
        SmsObserver observer2 = new SmsObserver(obj, "Tim Ronney [London]");

        observer.subscribe();
        observer2.subscribe();

        obj.setDesc("Welcome to live Soccer match");
        obj.setDesc("Current score 0-0");

        observer.unSubscribe();

        obj.setDesc("It’s a goal!!");
        obj.setDesc("Current score 1-0");
    }
}
