package abstraction;

public abstract class ProductForSale {
    private String type;
    private double price;

    private String description;

    public ProductForSale(String type, double price, String description){
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalesPrice(int quantity){
        return quantity * price;
    }

    public void printPricedItem(int quantity){
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n", quantity , price, type, description);
    }

    public abstract void showDetails();
}
