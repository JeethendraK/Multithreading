package in.thread.volatileEx;

public class Volatile_keyword {
    public static void main(String[] args) {
        // Create an instance of SharedResource class to be shared between threads
        SharedResource sharedResource = new SharedResource();

        // Thread 1: Sets the flag after performing some logic
        new Thread(() -> {
            System.out.println("Thread 1 started");  // Indicate that thread 1 has started
            try {
                System.out.println("Thread 1 logic is Started"); // Indicate logic execution start
                Thread.sleep(1000);  // Simulate some work by sleeping for 1 second
                System.out.println("Thread 1 logic is completed");  // Indicate logic execution completion
                
                sharedResource.setFlag(true);  // Set the flag to true
                System.out.println("Thread 1 set flag to true");  // Indicate flag setting
            } catch (InterruptedException e) {
                e.printStackTrace();  // Handle potential interrupt exception
            }
        }).start();  // Start Thread 1

        // Thread 2: Waits for the flag to become true before completing
        new Thread(() -> {
            System.out.println("Thread 2 started");  // Indicate that thread 2 has started
            while (!sharedResource.getFlag()) {
                // Wait until the flag is true; it will keep looping if the flag is false
            }
            System.out.println("Thread 2 is completed");  // Indicate thread 2 completion after flag is true
        }).start();  // Start Thread 2
    }
}
