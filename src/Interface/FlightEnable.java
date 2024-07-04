package Interface;

public interface FlightEnable {
    void takeOff();
    void land();
    void fly();
    default FlightStages transition(FlightStages stage){
        System.out.println("transition not implemented on "+ this.getClass().getName());
        return  null;
    }

}
