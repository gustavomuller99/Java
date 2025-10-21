package carExample.product;

public class GearLocking implements Product{

    private final String productName;

    public GearLocking(String productName){
        this.productName = productName;
    }

    public String productName() {
        return productName;
    }

    public void produce() {
        System.out.println("Producing Gear Locking System");
    }
}
