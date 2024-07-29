package threads;

public class CustomThread extends Thread{
    @Override
    public void run() {
        // write our code here
        for (int i = 1; i <= 5; i++){
            System.out.print(" 1 ");
            try{
                Thread.sleep(500); // mili-seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

