package carExample;

import carExample.car.BigWheel;
import carExample.car.Car;
import carExample.car.Motoren;
import carExample.product.CentralLocking;
import carExample.product.GearLocking;
import carExample.product.Product;

public class BridgeDemo {
    public static void main(String[] args) {

        Product cl = new CentralLocking("Central Locking");
        Product gl = new GearLocking("Gear Locking");

        Car car = new BigWheel(cl, "Big Wheel");
        car.produceProduct();
        car.assemble();
        car.produceProduct();

        System.out.println();

        car = new BigWheel(gl, "Big Wheel");
        car.produceProduct();
        car.assemble();
        car.produceProduct();

        System.out.println();

        car = new Motoren(cl, "Motoren");
        car.produceProduct();
        car.assemble();
        car.produceProduct();

        System.out.println();

        car = new Motoren(gl, "Motoren");
        car.produceProduct();
        car.assemble();
        car.produceProduct();
    }
}
