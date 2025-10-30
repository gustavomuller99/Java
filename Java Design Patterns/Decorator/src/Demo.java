import decorator.Broccoli;
import decorator.Cheese;
import pizza.Pizza;
import pizza.SimpyVegPizza;

import java.text.DecimalFormat;

public class Demo {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");

        Pizza pizza = new Cheese(new Broccoli(new SimpyVegPizza()));
        System.out.println(pizza.getDesc());
        System.out.println(pizza.getPrice());
    }
}
