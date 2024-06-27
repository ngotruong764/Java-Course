package list;

import OOP_Challenge.Item;

import java.util.ArrayList;
import java.util.Arrays;

record Items(String name, String type, int count) {
    public Items(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class GroceryItem {
    public static void main(String[] args) {
        Items[] Items = new Items[3];

        Items[0] = new Items("milk");
        Items[1] = new Items("apples", "PRODUCE", 6);
        Items[2] = new Items("oranges", "PRODUCE", 5);

        System.out.println(Arrays.toString(Items));

        // Raw use of ArrayList
        ArrayList objectList = new ArrayList();
        objectList.add(new Items("butter"));
        objectList.add("yogurt");
        System.out.println(objectList);

        ArrayList<Items> groceryList = new ArrayList<>();
        groceryList.add(new Items("butter"));
        groceryList.add(new Items("milk"));
        groceryList.set(0, new Items("apples", "PRODUCE", 6));
        groceryList.remove(1);
        System.out.println(groceryList);

    }
}
