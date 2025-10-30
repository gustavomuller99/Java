package decorator;

import pizza.Pizza;

public class Cheese extends PizzaDecorator {
    private final Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDesc() {
        return pizza.getDesc() + ", Cheese (20.72)";
    }

    public double getPrice() {
        return pizza.getPrice() + 20.72;
    }
}
