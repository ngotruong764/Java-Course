package threads;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();

        System.out.println(currentThread.getClass().getName());
        printThreadState(currentThread);

        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);

        // This CustomThread class is our class that extends
        // Thread class
        CustomThread customThread = new CustomThread();
        customThread.start();

        // This lambda expression represent the code in
        // run() method in Runnable interface
        Runnable myRunnable = () -> {
            for(int i = 1; i < 8; i++){
                System.out.print(" 2 ");
                try {
                    TimeUnit.MICROSECONDS.sleep(250000000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        // put in Thread constructor
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        for(int i = 1; i <= 3; i++){
            System.out.print(" 0 ");
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void printThreadState(Thread thread){
        System.out.println("-".repeat(40));
        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread name: "+thread.getName());
        System.out.println("Thread Priority: "+ thread.getPriority());
        System.out.println("Thread State: "+ thread.getState());
        System.out.println("Thread Group: "+ thread.getThreadGroup());
        System.out.println("Thread Is Alive: "+ thread.isAlive());
        System.out.println("-".repeat(40));
    }
}
