package carExample.car;

import carExample.product.Product;

public class Motoren extends Car {

    private final Product product;
    private final String carType;

    public Motoren(Product product, String carType) {
        super(product, carType);
        this.product = product;
        this.carType = carType;
    }

    public void assemble() {
        System.out.println("Assembling " + product.productName() + " for " + carType);
    }

    public void produceProduct() {
        product.produce();
        System.out.println("Modifying product " + product.productName() + " according to " + carType);
    }
}
