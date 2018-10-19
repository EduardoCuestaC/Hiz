package Sound;

public class SoundPlayer {
    private static SoundPlayer instance;

    public static SoundPlayer getInstance(){
        if(instance == null)
            instance = new SoundPlayer();
        return instance;
    }
    public void playSound(String name, boolean toLoop){
        Track track = new Track(name, toLoop);
        track.play();
    }
}
