package Interface;

public class InterfaceP1 {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnable flier = bird;
        Trackable tracked = bird;

//        animal.move();
//
//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();

        inFLight(flier);
        inFLight(new Jet());
        Trackable truck = new Truck();
        truck.track();
    }

    private static void inFLight(FlightEnable flier){
        flier.takeOff();
        flier.fly();
        if( flier instanceof Trackable trackable){
            trackable.track();
        }
        flier.land();
    }
}
