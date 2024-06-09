package Switch;

public class Switch {
    public static void main(String[] args) {
        int switchValue = 1;

        // enhanced switch statement
        switch (switchValue){
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("value was 2");
            default-> System.out.println("Was not 1 or 2");
        }

        System.out.println(getMonth("Jan"));

        getNATO_words('A');
    }

    public static String getMonth(String month){
        // tradition switch statement
//        switch(month){
//            case "Jan":
//            case"Feb":
//            case "Mar":
//                return "1st";
//            case"Apr":
//            case"May":
//            case"Jun":
//                return "2nd";
//
//            case "Jul":
//            case "Aug":
//            case "Sep":
//                return "3rd";
//
//            case "Oct":
//            case "Nov":
//            case"Dec":
//                return "4th";
//        }
//        return "Bad";


        // enhance statement
        return switch (month){
            case "Jan", "Feb", "Mar" -> "1st";
            case "Apr", "May", "Jun" -> "2nd";
            default -> {
                String badResponse = month + " is bad";
                yield badResponse;
            }
        };
    }

    public static void getNATO_words(char letter){
        String str = switch (letter){
            case 'A':
                yield "Able";
            case 'B':
                yield "Barker";
            default:
                yield "Bad character";
        };
        System.out.println(str);
    }
}
