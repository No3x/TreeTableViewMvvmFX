package my.mock;

import my.util.DirectoryNode;

public abstract class AFSMock {

    public DirectoryNode getDirectoryTree() {
        final String[] list = getData();

        final DirectoryNode directoryRootNode = DirectoryNode.createDirectoryTree(list);

        return directoryRootNode;
    }

    abstract protected String[] getData();
}
