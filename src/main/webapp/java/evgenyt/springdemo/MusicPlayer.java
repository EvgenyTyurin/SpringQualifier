package evgenyt.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Any ONE of this Autowired is enough to wire music to player
 * Qualifier helps Spring to choose between rockMusic and classicalMusic beans
 * during dependency injection to musicPlayer bean
 */

@Component
public class MusicPlayer {
    @Autowired
    @Qualifier("rockMusic")
    // This method is not recommended
    private Music music;

    @Autowired
    // If there is only one constructor Autowired can be skipped
    public MusicPlayer(@Qualifier("rockMusic") Music music) {
        this.music = music;
    }

    @Autowired
    @Qualifier("rockMusic")
    public void anyNameHere(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing:" + music.getSong());
    }
}
