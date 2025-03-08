package in.thread;
public class TraditionalThreadCreation {
    public static void main(String[] args)  {
        System.out.println("Hello World from main thread!");
        MyThread t1 = new MyThread();
        t1.start();
    }
}
class MyThread extends Thread {
    public void run() {
        System.out.println("Hello World from new thread!");
    }
}
