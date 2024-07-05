package generic;

public class ChallengeMain {
    public static void main(String[] args) {
        var nationalUSParks = new Park[]{
                new Park("Yellowstone", "33.47, -1234.3"),
                new Park("Grand Canyon", "33.47, -1234.3")
        };

        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        var majorUSRivers  = new River[]{
                new River("Mississipi", "12.321, 12312","1212.231, -21390.23"),

        };

        Layer<River> riverLayer = new Layer<>(majorUSRivers);
        riverLayer.addElements(new River("Colorado", "12.113, -1923.1212", "123.123, 12304.23"));
        riverLayer.renderLayer();
    }
}
