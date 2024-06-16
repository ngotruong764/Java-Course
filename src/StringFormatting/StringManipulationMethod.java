package StringFormatting;

public class StringManipulationMethod {
    public static void main(String[] args) {
        String dob = "20/09/2003";
        int startingIndex = dob.indexOf("2003");
        System.out.println("startingIndex = "+ startingIndex);
        System.out.println("Birth year = "+ dob.substring(startingIndex));

        String newDate = String.join("/", "15", "06", "2024");
        System.out.println("newDate = "+ newDate);

        newDate = "15";
        newDate = newDate.concat("/");
        newDate = newDate.concat("06");
        newDate = newDate.concat("/");
        newDate = newDate.concat("2024");
        System.out.println("newDate = "+ newDate);

        // method chaining
        newDate = "25".concat("/").concat("11").concat("/").concat("2024");
        System.out.println("newDate = "+ newDate);

        System.out.println(newDate.replace("/", "-"));
        System.out.println(newDate.replace("2", "00"));

        System.out.println(newDate.replaceFirst("/", "-"));
        System.out.println(newDate.replaceAll("/", "--"));

        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));

        System.out.println("     ABC\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));

    }
}
