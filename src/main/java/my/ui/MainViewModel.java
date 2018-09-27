package my.ui;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.util.Callback;
import my.mock.AFSMock;
import my.mock.FSMocks;
import my.util.DirectoryNode;
import my.util.DirectoryNodeToVideoMapper;

import java.util.stream.Collectors;

public class MainViewModel implements ViewModel {

    private AFSMock fsMock;

    private ObjectProperty<TreeItem<VideoItemViewModel>> root = new SimpleObjectProperty<>();

    public MainViewModel() {
       fsMock = FSMocks.fsAMock;
       loadData();
    }

    private void loadData() {
        final VideoItemViewModel rootItemViewModel = getViewModelForDirectoryNode(fsMock.getDirectoryTree().getRoot());

        final RecursiveTreeItem<VideoItemViewModel> videoItemViewModelRecursiveTreeItem = new RecursiveTreeItem<>(rootItemViewModel, new Callback<VideoItemViewModel, ObservableList<VideoItemViewModel>>() {
            @Override
            public ObservableList<VideoItemViewModel> call(VideoItemViewModel param) {
                return param.getModel().getSourceNode().getChildren().stream()
                            .map(directoryNode -> getViewModelForDirectoryNode(directoryNode))
                            .collect(Collectors.toCollection(FXCollections::observableArrayList));
            }
        });

        this.root.set(videoItemViewModelRecursiveTreeItem);
    }

    private VideoItemViewModel getViewModelForDirectoryNode(DirectoryNode node) {
        return new VideoItemViewModel(DirectoryNodeToVideoMapper.map(node));
    }

    @FXML
    public void switchDirectory() {
        fsMock = fsMock == FSMocks.fsAMock ? FSMocks.fsBMock : FSMocks.fsAMock;
        loadData();
    }

    public ObjectProperty<TreeItem<VideoItemViewModel>> rootProperty() {
        return root;
    }
}