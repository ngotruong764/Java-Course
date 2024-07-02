package linkkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class linkedListP1 {
    public static void main(String[] args) {
//        LinkedList<String> placesToVisit = new LinkedList<>();
        var placeToVisit = new LinkedList<String>();
        placeToVisit.add("Sydney");
        placeToVisit.add(0, "Canberra");
        System.out.println(placeToVisit);

        addMoreElement(placeToVisit);
        System.out.println(placeToVisit);

//        removeElement(placeToVisit);
//        System.out.println(placeToVisit);

//        gettingElements(placeToVisit);

//        printItinerary(placeToVisit);

//        printItinerary2(placeToVisit);

//        printItinerary3(placeToVisit);

        testIterator(placeToVisit);
    }

    private static void addMoreElement(LinkedList<String> list){
        list.add("Darwin");
        list.add("Hobart");

        //Queue method
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        //Stack method
        list.push("Alice Springs");
    }

    private static void removeElement(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");
        list.remove(); // remove the first element

        list.removeFirst(); // remove the first element but in the clear way

        list.removeLast();

        list.poll(); // remove the first element
        list.pollFirst(); //remove the first element
        list.pollLast(); // remove the last element

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");

        list.pop();
    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println("Retrieve Element = "+ list.get(4));
        System.out.println("First Element: "+ list.getFirst());
        System.out.println("Last Element: "+ list.getLast());

        System.out.println("Darwin is at position: "+ list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: "+ list.lastIndexOf("Melbourne"));

        // Queue retrieval method
        System.out.println("Element from element() = "+ list.element()); // retrieve the first element

        // Stack retrieval method
        System.out.println("Element from peek() = "+ list.peek()); // retrieve the first element
        System.out.println("Element from peekFirst() = "+ list.peekFirst()); // retrieve the first element
        System.out.println("Element from peekLast() = "+ list.peekLast()); // retrieve the last element
    }

    public static void printItinerary(LinkedList<String> list){
        System.out.println("Trips starts at "+ list.getFirst());
        for(int i = 1; i < list.size(); i++){
            System.out.println("--> From: "+ list.get(i - 1) + " to "+ list.get(i));
        }
        System.out.println("Trips ends at "+ list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list){
        System.out.println("Trips starts at "+ list.getFirst());
        String previousTown = list.getFirst();
        for(String town: list){
            System.out.println("--> From: "+ previousTown+ " to "+ town);
            previousTown = town;
        }
        System.out.println("Trips ends at "+ list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list){
        System.out.println("Trips starts at "+ list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()){
            String town = iterator.next();
            System.out.println("--> From: "+ previousTown+ " to "+ town);
            previousTown = town;
        }
        System.out.println("Trips ends at "+ list.getLast());
    }

    private static void testIterator(LinkedList<String> list){
        var iterator = list.listIterator(); // create an iterator
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            if(iterator.next().equals("Brisbane")) iterator.add("Lake Wivenhone");
        }

        while (iterator.hasPrevious()){
            System.out.println(iterator.previous() );
        }

        System.out.println(list);

    }
}
