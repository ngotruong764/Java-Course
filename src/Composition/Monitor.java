package Composition;

// Monitor got an IS-A relationship with Product, meaning that Monitor is a type of product.
public class Monitor extends Product{
    private int size;
    private String resolution;
    public Monitor(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public Monitor(String model, String manufacturer, int size, String resolution) {
        super(model, manufacturer);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color){
        System.out.printf("Drawing pixel at %d, %d in color %s%n", x, y, color);
    }
}
