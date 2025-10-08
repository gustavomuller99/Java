// a functional interface
interface MyNumber {
    double getValue();
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyNumber myNumber;

        myNumber = () -> 10;
        System.out.println(myNumber.getValue());

        myNumber = () -> Math.random() * 100;
        System.out.println(myNumber.getValue());
        System.out.println(myNumber.getValue());
    }
}