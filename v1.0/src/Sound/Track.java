package Sound;

import javax.sound.sampled.Clip;

public class Track implements Runnable{
    private Clip c;
    private boolean loop = false;

    public Track(String name, boolean loop){
        c = SoundLoader.getInstance().getClip(name);
        this.loop = loop;
    }

    public void play(){
        (new Thread(this)).start();
    }

    @Override
    public void run() {
        if (c.isRunning()) {
            c.stop();
            c.setFramePosition(0);
        }
        c.start();
        while(loop) {
            if (!c.isRunning()) {
                c.stop();
                c.setFramePosition(0);
                c.start();
            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                //do nothing
            }
        }

    }
}
