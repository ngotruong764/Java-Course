package Inheritance;

public class Animal {
    private String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void move(String speec){
        System.out.println(type + " move"+ speec);
    }

    public void makeNoise(){
        System.out.println(type+ " make some kind of noise");
    }
}
