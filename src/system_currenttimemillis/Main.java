package system_currenttimemillis;

public class Main {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++){
            currentTime = System.currentTimeMillis();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
