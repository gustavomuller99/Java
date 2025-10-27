package carExample.builder;

import carExample.product.Car;

public class SportsCarBuilder implements CarBuilder {
    private final Car car = new Car("SPORTS");

    public void buildBodyStyle() {
        car.setBodyStyle("External dimensions: overall length (inches): 192.3," +
                " overall width (inches): 75.5, overall height (inches): 54.2, wheelbase (inches): 112.3," +
                " front track (inches): 63.7, rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7");
    }

    public void buildPower() {
        car.setPower("323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm");
    }

    public void buildEngine() {
        car.setEngine("3.6L V 6 DOHC and variable valve timing");
    }

    public void buildBreaks() {
        car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution. StabiliTrak stability control");
    }

    public void buildSeats() {
        car.setSeats("Driver sports front seat with one power adjustments manual height, front passenger seat sports front seat with one power adjustments");
    }

    public void buildWindows() {
        car.setWindows("Front windows with one-touch on two windows");
    }

    public void buildFuelType() {
        car.setFuelType("Gasoline 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range");
    }

    public Car getCar() {
        return car;
    }

}
