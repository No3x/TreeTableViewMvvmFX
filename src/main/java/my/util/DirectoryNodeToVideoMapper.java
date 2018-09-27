package my.util;

import my.model.Video;

public class DirectoryNodeToVideoMapper {

    public static Video map(DirectoryNode directoryNode) {
        // parse all required attributes
        // if the DirectoryNode actually provides a File instead of the name only there become more attributes available
        Video v = new Video(directoryNode, directoryNode.getValue(), directoryNode.getValue());
        return v;
    }
}
