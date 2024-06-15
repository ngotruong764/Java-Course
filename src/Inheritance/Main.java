package Inheritance;

public class Main extends Object {
    public static void main(String[] args) {
        Animal animal = new Animal("Generic Animal", "Huge", 400);
        doAnimalStuff(animal, "slow");

        Dog yorkie = new Dog("Yourkie", 15);
        doAnimalStuff(yorkie, "fast");

        Dog retriever = new Dog("Lab Retriever", 65, "Floopy", "Swimmer");
        doAnimalStuff(retriever, "slow");
    }

    public static void doAnimalStuff(Animal animal, String speed){
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("_ _ _ _");
    }
}
