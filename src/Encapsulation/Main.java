package Encapsulation;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Tim", 200, "Sword");
        System.out.println("Initial health is "+ player.healthRemaining());
    }
}
