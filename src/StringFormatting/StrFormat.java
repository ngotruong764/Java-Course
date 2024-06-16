package StringFormatting;

public class StrFormat {
    public static void main(String[] args) {
        // "\u2022" represent a bullet list
        String bulletIt = "Print a Bulleted List:\n"+
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";
        System.out.println(bulletIt);

        String textBlock = """
               Print a Bulleted List:
                    \u2022 First Point
                        \u2022 Sub Point""";
        System.out.println(textBlock);

        int age = 21;
        int currentYear = 2024;
        System.out.printf("Current year: %d - My age is %d\n",currentYear, age);

        String foramttedString = String.format("My age is %d", age); // this is a static method

        foramttedString = "My age is %d".formatted(age);
    }
}
