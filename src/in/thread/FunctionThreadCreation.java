package in.thread;
// FunctionThreadCreation.java

// The main class where the program execution begins
public class FunctionThreadCreation {
    
    // Main method where the program starts execution
    public static void main(String[] args) {
        
        // Indicating the start of the main thread
        System.out.println("Main Thread Started");

        // ---- Thread creation using the Thread class ----
        System.out.println("--Thread creation using Thread class----");
        
        // The Thread class is a built-in class in Java that represents a thread of execution.
        // You can create a new thread by either subclassing the Thread class or passing a Runnable.
        
        // Creating and starting the first thread using the Thread class.
        Thread t1 = new Thread(
            () -> { 
                // The run() method contains the code that this thread will execute
                System.out.println("Thread 1 is running using Thread class");
            });
        
        t1.start();  // Starting Thread 1: Calls the run() method in a new thread of execution.

        // ---- Thread creation using the Runnable interface ----
        System.out.println("--Thread creation using Runnable interface----");

        // The Runnable interface represents a task that can be executed by a thread.
        // By implementing this interface, you can define the task logic in the run() method.
        
        // Creating a Runnable object that contains the code for Thread 2.
        Runnable r = () -> {
            // The run() method contains the code that Thread 2 will execute
            System.out.println("Thread 2 is running using Runnable interface");
            
            // Displaying information about Thread 2:
            // Thread's priority (default is 5)
            System.out.println("Thread 2 priority: " + Thread.currentThread().getPriority());

            // Displaying the name of the thread (set to "Runnable Thread")
            System.out.println("Thread 2 name: " + Thread.currentThread().getName());

            // Displaying the current state of the thread (RUNNABLE, WAITING, etc.)
            System.out.println("Thread 2 state: " + Thread.currentThread().getState());

            try {
                // Simulating work by putting the thread to sleep for 1 second
                Thread.sleep(1000);  // Causes the thread to pause for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                // Handling InterruptedException (if the thread is interrupted during sleep)
                throw new RuntimeException(e);
            }
            
            // Indicating that Thread 2 has completed its execution
            System.out.println("Thread 2 is completed");
        };

        // ---- Creating a new Thread using the Runnable object ----
        // The thread t2 is created with the Runnable task and given a name "Runnable Thread".
        Thread t2 = new Thread(r, "Runnable Thread");

        // Setting Thread 2 as a **daemon thread**.
        // A daemon thread is a thread that runs in the background and does not prevent the JVM from exiting.
        t2.setDaemon(true);

        // Starting Thread 2
        t2.start();

        // Indicating the end of the main thread
        System.out.println("Main Thread Ended");
    }
}
