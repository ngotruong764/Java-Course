package Interface;

import java.util.Date;

interface OrbitEarth extends FlightEnable {
    void achieveOrbit();

    private static void log(String description){
        var today = new Date();
        System.out.println(today +": "+ description);
    }

    private void logState(FlightStages stage, String description){
        description  = stage + ": "+ description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage =  FlightEnable.super.transition(stage);
        logState(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}
