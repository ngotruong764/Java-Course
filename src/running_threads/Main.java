package running_threads;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread is running");
        try {
            System.out.println("Main thread paused for 1 second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 10 dots to run.");
            for(int i = 1; i <= 10; i++){
                System.out.print(". ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("\nWhoops!! " +tname+ " interrupted.");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + tname+ " completed.");
        });

        Thread installThead = new Thread(() -> {
            try{
                for(int i = 0; i < 3; i++){
                    Thread.sleep(250);
                    System.out.println("Installation Step " + (i + 1) +
                            " is completed.");
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }, "InstallThread");



        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            while (thread.isAlive()){
                try{
                    Thread.sleep(1000);
                    if(System.currentTimeMillis() - now > 8000){
                        // interrupt thread
                        thread.interrupt();
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        System.out.println(thread.getName() + " starting");
        thread.start();
        threadMonitor.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(!thread.isInterrupted()){
            installThead.start();
        } else{
            System.out.println("Previous thread was interrupted, "+
                    installThead.getName() + "can't run.");
        }
    }
}
