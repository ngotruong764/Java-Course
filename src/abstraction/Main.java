package abstraction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Wolf", "Big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Dog("Goldfish", "small", 1));
        animals.add(new Dog("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));

        for(Animal animal : animals){
            doAnimalStuff(animal);
            System.out.println("-".repeat(30));
        }

        ArrayList<String> newArray = new ArrayList<>();
        newArray.add("New");
        newArray.set(0, "10");

    }

    private static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
    }
}
