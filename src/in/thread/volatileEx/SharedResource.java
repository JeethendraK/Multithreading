package in.thread.volatileEx;

public class SharedResource {
    //using Volatile keyword to make sure that the flag is visible to all threads
    //private boolean flag = false;
    //private volatile boolean flag = false;

    //using synchronized keyword to make sure that the flag is visible to all threads
    private boolean flag = false;
    public synchronized void  setFlag(boolean flag) {
        this.flag = flag;
    }
    public synchronized boolean getFlag() {
        return flag;
    }

}
