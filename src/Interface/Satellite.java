package Interface;

public class Satellite implements OrbitEarth{
    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void achieveOrbit() {

    }

    @Override
    public FlightStages transition(FlightStages stage) {
        return OrbitEarth.super.transition(stage);
    }
}
