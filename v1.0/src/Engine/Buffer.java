package Engine;

import java.awt.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Buffer {
    private ArrayBlockingQueue<Integer> b =  new ArrayBlockingQueue<Integer>(5);
    private boolean canRead = false;

    public int get() throws InterruptedException{
        return b.take();
    }

    public void set(int p) throws InterruptedException{
        b.put(p);
    }

    public boolean isFull()
    {
        return (b.size()==5);
    }

    public boolean isEmpty()
    {
        return b.isEmpty();
    }

    public void clear()
    {
        b.clear();
    }
}
