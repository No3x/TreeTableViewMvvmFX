package my.model;

import java.util.*;

public class VideoStore {

    public static List<Video> findForLevel(int i) {
        List<Video> videos = new ArrayList<>();
        if(0 == i) {
           videos.add(new Video("root user", "name"));
        } else if (1 == i) {
           videos.add(new Video("a", "aa"));
           videos.add(new Video("b", "bb"));
           videos.add(new Video("c", "cc"));
        } else {
            // add nothing
        }
        return videos;
    }
}
