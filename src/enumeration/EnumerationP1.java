package enumeration;

import java.util.Random;

public class EnumerationP1 {
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.TUES;

        System.out.println(weekDay);

        System.out.printf("Name is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());

        System.out.println(getRandomDay());

        // loop through an enum
        for(DayOfTheWeek item: DayOfTheWeek.values()){
            System.out.printf("Name is %s, Ordinal Value = %d%n", item.name(), item.ordinal());

            if( item == DayOfTheWeek.SAT){
                System.out.println("Today is Saturday");
            }
        }

    }

    public static DayOfTheWeek getRandomDay(){
        int randomInt = new Random().nextInt(7);

        //get an array of all enum constant
        DayOfTheWeek[] allDay = DayOfTheWeek.values();


        return allDay[randomInt];
    }
}
