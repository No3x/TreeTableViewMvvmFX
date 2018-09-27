package my.model;

import my.util.DirectoryNode;

import java.util.UUID;

public class Video {

    private UUID id;
    private String user;
    private String name;
    private DirectoryNode sourceNode;

    public Video(DirectoryNode sourceNode, String user, String name) {
        this.sourceNode = sourceNode;
        this.id = UUID.randomUUID();
        this.user = user;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DirectoryNode getSourceNode() {
        return sourceNode;
    }
}