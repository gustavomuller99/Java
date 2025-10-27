package carExample;

import carExample.builder.CarBuilder;
import carExample.builder.CarDirector;
import carExample.builder.SedanCarBuilder;
import carExample.builder.SportsCarBuilder;
import carExample.product.Car;

public class BuilderDemo {
    public static void main(String[] args) {
        CarBuilder carBuilder = new SedanCarBuilder();
        CarDirector director = new CarDirector(carBuilder);
        director.build();
        Car car = carBuilder.getCar();
        System.out.println(car);

        carBuilder = new SportsCarBuilder();
        director = new CarDirector(carBuilder);
        director.build();
        car = carBuilder.getCar();
        System.out.println(car);
    }
}
