package Engine;

public class Jumper implements Runnable, Producer{
    private double dy;
    private double vi;
    private double fg = 0.5;
    private Buffer buff;
    private int i =0;
    private volatile Thread t;
    private volatile boolean shouldRun;
    private long startTime;

    public Jumper(Buffer buffer, int vi){
        this.vi = vi;
        buff = buffer;
        buff.clear();
    }

    @Override
    public void run()
    {
        Thread thisThread = Thread.currentThread();
        while (t == thisThread) {
            while (!buff.isFull() && (t == thisThread)) {
                vi += fg;
                dy = vi;
                try {
                    buff.set((int)dy);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    Thread.sleep(20);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void start() {
        t = new Thread(this);
        shouldRun = true;
        startTime = System.nanoTime();
        t.start();
    }

    @Override
    public void stop() {

        if(((double)(System.nanoTime()-startTime)/1000000000L) > ((double)0.3)) {
            t = null;
        }
    }
}
