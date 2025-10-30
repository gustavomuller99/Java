package decorator;

import pizza.Pizza;

public abstract class PizzaDecorator implements Pizza {
    public String getDesc() {
        return "Toppings";
    }
}
