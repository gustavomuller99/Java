package decorator;

import pizza.Pizza;

public class Broccoli extends PizzaDecorator {
    private final Pizza pizza;

    public Broccoli(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDesc() {
        return pizza.getDesc() + ", Broccoli (9.25)";
    }

    public double getPrice() {
        return pizza.getPrice() + 9.25;
    }
}
