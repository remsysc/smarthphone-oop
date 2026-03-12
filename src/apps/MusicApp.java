package apps;

import java.util.ArrayList;
import java.util.List;

//Plays audio tracks.

public class MusicApp extends App {

    private List<String> playlist;
    private String nowPlaying;

    public MusicApp() {
        super("Music Player", "2.1");
        this.playlist = new ArrayList<>();
        this.nowPlaying = null;

        // Default playlist
        playlist.add("Morning Vibes");
        playlist.add("Lo-fi Study");
        playlist.add("Evening Chill");
    }

    @Override
    public void open() {
        super.open();
        System.out.println("  [" + getName() + "] Playlist loaded. " + playlist.size() + " tracks available.");
    }

    public void play(int trackIndex) {
        if (!isRunning()) {
            System.out.println("  [" + getName() + "] Please open the app first.");
            return;
        }
        if (trackIndex < 0 || trackIndex >= playlist.size()) {
            System.out.println("  [" + getName() + "] Invalid track index.");
            return;
        }
        nowPlaying = playlist.get(trackIndex);
        System.out.println("  [" + getName() + "] Now playing: \"" + nowPlaying + "\" ♪");
    }

    public void stop() {
        if (nowPlaying != null) {
            System.out.println("  [" + getName() + "] Stopped: \"" + nowPlaying + "\"");
            nowPlaying = null;
        }
    }

    public String getNowPlaying() {
        return nowPlaying;
    }
}
