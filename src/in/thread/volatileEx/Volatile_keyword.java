package in.thread.volatileEx;

public class Volatile_keyword {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        //Thread 1
        new Thread(() ->{
            System.out.println("Thread 1 started");
            try {
                System.out.println("Thread 1 logic is Started");
                Thread.sleep(1000);
                System.out.println("Thread 1 logic is completed");
                sharedResource.setFlag(true);
                System.out.println("Thread 1 set flag to true");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }).start();

        //Thread 2
        new Thread(() -> {
            System.out.println("Thread 2 started");
            while(!sharedResource.getFlag()){

            }
            System.out.println("Thread 2 is completed");
        }).start();
    }

}
