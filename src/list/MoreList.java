package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreList {
    public static void main(String[] args) {
        String[] items = {"apples", "banana", "milk", "eggs"};

        List<String> list = List.of(items);
        items[0] = "mango";
        Arrays.sort(items);
        System.out.println(Arrays.toString(items));
        System.out.println(list);
        System.out.println(list.getClass().getName());

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);
        System.out.println(groceries.getClass().getName());

        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mustard", "cheese"));
        groceries.addAll(nextList);
        System.out.println(groceries);
        System.out.println("first item: "+ groceries.get(1));

        if(groceries.contains("mustard")){
            System.out.println("List contain mustard");
        }else {
            System.out.println("List does not contain mustard");
        }

        System.out.println(groceries.indexOf("mustard"));
        System.out.println(groceries.indexOf("thing does not exist in list"));

        groceries.removeAll(List.of("apples", "durian"));
        System.out.println(groceries);

        groceries.clear();
        System.out.println(groceries);

        groceries.addAll(List.of("apples", "milk", "mustard"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));
        groceries.sort(Comparator.naturalOrder()); // sort the array list
        System.out.println(groceries);

        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        var groceryArray = groceries.toArray();
        System.out.println(Arrays.toString(groceryArray));
        System.out.println(groceryArray.getClass().getName());

        String[] array1 = new String[]{"First","Second", "Third"};
        List<String> newArray1 = Arrays.asList(array1);
        array1[0] = "changed";
        newArray1.add("new"); // error in here
        System.out.println(newArray1);
        System.out.println(newArray1.getClass().getName());
    }
}
