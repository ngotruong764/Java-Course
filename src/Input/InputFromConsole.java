package Input;

// System.console can not be used in IDE because IDE disable the console
// type java src/Input/InputFromConsole.java to run in terminal
public class InputFromConsole {
    public static void main(String[] args) {
        String name = System.console().readLine("Hi, What's your name? ");
        System.out.println("Hi "+ name +" , Thanks for taking the course!");
    }
}
