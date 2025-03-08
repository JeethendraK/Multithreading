package in.thread.volatileEx;

public class SharedResource {
    private boolean flag = false;
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag() {
        return flag;
    }

}
