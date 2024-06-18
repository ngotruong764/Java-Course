package OOP_Challenge;

public class Item {
    private String name;
    private String type;
    private double price;
    private String size = "MEDIUM";

    public Item(String name, String type, double price) {
        this(name.toUpperCase(), type.toUpperCase(), price, "MEDIUM");
    }

    public Item(String name, String type, double price, String size) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        if(type.equals("SIDES")|| type.equals("DRINK")){
            return size+ " "+ name;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBasePrice(){
        return price;
    }

    public double getAdjustPrice(){
        return switch (size){
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }
    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public void setSize(String size){
        this.size = size;
    }

    public void printItem(){
        printItem(getName(), getAdjustPrice());
    }
}
