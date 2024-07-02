package enumeration;

public class EnumSwitch {
    public static void main(String[] args) {
        switchDayOfWeek(DayOfTheWeek.TUES);
    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay){
        int weekDayInt = weekDay.ordinal()+ 1;
        switch(weekDay){
            case SUN -> System.out.println("1");
            case MON -> System.out.println("2");
            case TUES -> System.out.println("3");
            case WED -> System.out.println("4");
            case THUR -> System.out.println("5");
            case FRI -> System.out.println("6");
            case SAT -> System.out.println("7");
            default -> System.out.println("Not a day");
        }
    }
}
