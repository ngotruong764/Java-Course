package Polymorphism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Movie movie = Movie.getMovie("Adventure", "Star Wars");
//        movie.watchMovie();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter Type( A for Adventure, C for Comedy, "+
                    "S for Science Friction, or Q to quit): ");
            String type = scanner.nextLine();
            if("Qq".contains(type)) break;
            System.out.print("Enter movie title: ");
            String title = scanner.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
