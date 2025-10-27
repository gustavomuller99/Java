package carExample.builder;

import carExample.product.Car;

public class SedanCarBuilder implements CarBuilder {

    private final Car car = new Car("SEDAN");

    public void buildBodyStyle() {
        car.setBodyStyle(
                "External dimensions: overall length (inches): 202.9, overall width (inches): 76.2, overall height (inches): 60.7, wheelbase(inches):112.9, " +
                        " front track (inches): 65.3, rear track (inches): 65.5 and curb to curb turning circle(feet):39.5 ");
    }

    public void buildPower() {
        car.setPower("285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm");
    }

    public void buildEngine() {
        car.setEngine("3.5L Duramax V 6 DOHC");
    }

    public void buildBreaks() {
        car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution");
    }

    public void buildSeats() {
        car.setSeats("Front seat center armrest.Rear seat center armrest.Split-folding rear seats");
    }

    public void buildWindows() {
        car.setWindows("Laminated side windows.Fixed rear window with defroster");
    }

    public void buildFuelType() {
        car.setFuelType("Gasoline 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range");
    }

    public Car getCar() {
        return car;
    }
}
