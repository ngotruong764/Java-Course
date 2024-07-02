package linkkedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

record Place(String name, int distance){
    @Override
    public String toString() {
        return String.format("%s (%d) ", name, distance);
    }
}

public class linkedListChallenge {
    public static void main(String[] args) {
        LinkedList<Place> placeToVisit = new LinkedList<>();
        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placeToVisit, adelaide);
        addPlace(placeToVisit, new Place("adelaide", 1374));
        addPlace(placeToVisit, new Place("Brisbane", 917));
        addPlace(placeToVisit, new Place("Perth", 3923));
        addPlace(placeToVisit, new Place("Alice Springs", 2771));
        addPlace(placeToVisit, new Place("Darwin", 3972));
        addPlace(placeToVisit, new Place("Melbourne", 877));
        addPlace(placeToVisit, new Place("Sydney", 0));

        ListIterator<Place> iterator = placeToVisit.listIterator();
        Scanner scanner  = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();

        while (!quitLoop){
            if(!iterator.hasPrevious()){
                System.out.println("Original place: "+ iterator.next());
                forward = true;
            }

            if(!iterator.hasNext()){
                System.out.println("Final: "+ iterator.previous());
                forward = false;
            }

            System.out.print("Enter value: ");
            String menuItem = scanner.nextLine().substring(0,1).toUpperCase();

            switch (menuItem){
                case "F" -> {
                    if(!forward){
                        forward = true;
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                }
                case "B" -> {
                    if(forward){
                        forward = false;
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                }
                case "L" -> System.out.println(placeToVisit);
                case "M" -> printMenu();
                case "Q" -> quitLoop = true;
                default -> System.out.println("Invalid key!");

            }
        }

    }

    private static void addPlace(LinkedList<Place> list, Place place){
        if(list.contains(place)){
            System.out.println("Find duplicate: "+ place);
            return;
        }

        for (Place p : list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Find duplicate: "+ place);
                return;
            }
        }

        for(int i = 0; i < list.size(); i++){
            if(place.distance() < list.get(i).distance()){
                list.add(i, place);
                return;
            }
        }
        list.add(place);
    }

    private static void printMenu(){
        System.out.println("""
                Available actions (selected word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""");

    }
}
