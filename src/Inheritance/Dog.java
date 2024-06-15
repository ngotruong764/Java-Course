package Inheritance;

public class Dog extends Animal {
    private String earShape;
    private String tailShape;

    public Dog(String type, double weight){
        this(type, weight, "Perky", "Curled");
    }

    public Dog(String type, double weight,String earShape, String tailShape) {
        super( type,  weight < 15 ? "small" :( weight < 35 ? "medium" : "large"),  weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    public String getEarShape() {
        return earShape;
    }

    public void setEarShape(String earShape) {
        this.earShape = earShape;
    }

    public String getTailShape() {
        return tailShape;
    }

    public void setTailShape(String tailShape) {
        this.tailShape = tailShape;
    }

    @Override
    public void makeNoise() {
        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        super.move(speed);
//        System.out.println("Dogs walks, runa dn wag their tails");
        if(speed.equals("slow")) {
            walk();
            wagTail();
        }
        else {
            run();
            bark();
        }
    }

    private void bark(){
        System.out.println("Woof !");
    }

    private void run() {
        System.out.println("Dog running");
    }

    private void walk(){
        System.out.println("Dog walking");
    }

    private void wagTail(){
        System.out.println("Tail Wagging");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }
}
