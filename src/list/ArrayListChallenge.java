package list;

import java.util.*;

/*
* 0: to shutdown
* 1: to add item(s) to list(comma delimited)
* 2: to remove any items( comma delimited list)
*/
public class ArrayListChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceriesList = new ArrayList<>();
        int action = -1;

        while (action != 0){
            System.out.print("Action: ");

            action = scanner.nextInt();

            switch (action){
                case 0 -> {
                    break;
                }
                case 1 -> addItems(groceriesList,scanner);
                case 2 -> removeItems(groceriesList,scanner);
                default -> System.out.println("Invalid action");
            }
        }
        scanner.close();
        System.out.println("-".repeat(30));
        System.out.println("Exit program");
    }

    public static void addItems(ArrayList<String> groceriesList, Scanner scanner){
        System.out.print("Enter list( add): ");
        scanner.nextLine();
        String list = scanner.nextLine();
        groceriesList.addAll(List.of(parseInput(list)));
        groceriesList.sort(Comparator.naturalOrder());
        System.out.println(groceriesList);
    }

    public static void removeItems(ArrayList<String> groceriesList, Scanner scanner){
        System.out.print("Enter list (remove): ");
        scanner.nextLine();
        String list = scanner.nextLine();
        groceriesList.removeAll(List.of(parseInput(list)));
        groceriesList.sort(Comparator.naturalOrder());
        System.out.println(groceriesList);
    }

    public static String[] parseInput(String list){
        return list.split(",");
    }

}
