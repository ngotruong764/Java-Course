package Polymorphism;

public class ScienceFiction extends Movie{
    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("... %s\n".repeat(3),
                "Bad ALiens do Bad Stuff",
                "Space Guys Chase Aliens",
                "Planet BLows Up");
    }
}
