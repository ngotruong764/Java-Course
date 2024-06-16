package Composition;

public class PersonalComputer extends Product{
    private ComputerCase computerCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PersonalComputer(String model, String manufacturer, ComputerCase computerCase, Monitor monitor, Motherboard motherboard) {
        super(model, manufacturer);
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    private void drawLogo(){
        monitor.drawPixelAt(1200, 50, "yellow");
    }

    public void powerUp(){
        computerCase.pressPowerButton();
        drawLogo();
    }
//    public ComputerCase getComputerCase() {
//        return computerCase;
//    }
//
//    public void setComputerCase(ComputerCase computerCase) {
//        this.computerCase = computerCase;
//    }
//
//    public Monitor getMonitor() {
//        return monitor;
//    }
//
//    public void setMonitor(Monitor monitor) {
//        this.monitor = monitor;
//    }
//
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
//
//    public void setMotherboard(Motherboard motherboard) {
//        this.motherboard = motherboard;
//    }
}
