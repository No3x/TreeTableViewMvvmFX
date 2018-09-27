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
import my.model.Video;
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
        final Video root = DirectoryNodeToVideoMapper.map(fsMock.getDirectoryTree().getRoot());
        final VideoItemViewModel rootItemViewModel = new VideoItemViewModel(root);

        final RecursiveTreeItem<VideoItemViewModel> videoItemViewModelRecursiveTreeItem = new RecursiveTreeItem<>(rootItemViewModel, new Callback<VideoItemViewModel, ObservableList<VideoItemViewModel>>() {
            @Override
            public ObservableList<VideoItemViewModel> call(VideoItemViewModel param) {
                return param.getModel().getSourceNode().getChildren().stream()
                            .map(DirectoryNodeToVideoMapper::map)
                            .map(VideoItemViewModel::new)
                            .collect(Collectors.toCollection(FXCollections::observableArrayList));
            }
        });

        this.root.set(videoItemViewModelRecursiveTreeItem);
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