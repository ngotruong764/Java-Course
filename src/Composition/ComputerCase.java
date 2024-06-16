package Composition;

//ComputerCase got an IS-A relationship with Product, meaning that ComputerCase is a type of product.
public class ComputerCase extends Product{
    private String powerSupply;
    public ComputerCase(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public ComputerCase(String model, String manufacturer, String powerSupply) {
        super(model, manufacturer);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton(){
        System.out.println("Power Button Pressed");
    }

}
