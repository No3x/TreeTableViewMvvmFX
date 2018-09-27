package my.ui;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.util.Callback;
import my.model.Video;
import my.model.VideoStore;

import java.util.List;
import java.util.stream.Collectors;


public class MainViewModel implements ViewModel {

    private ObjectProperty<TreeItem<VideoItemViewModel>> root = new SimpleObjectProperty<>();
    static int i;

    public MainViewModel() {
        final Video root = VideoStore.findForLevel(0).get(0);
        final VideoItemViewModel rootItemViewModel = new VideoItemViewModel(root);

        final RecursiveTreeItem<VideoItemViewModel> videoItemViewModelRecursiveTreeItem = new RecursiveTreeItem<>(rootItemViewModel, new Callback<VideoItemViewModel, ObservableList<VideoItemViewModel>>() {
            @Override
            public ObservableList<VideoItemViewModel> call(VideoItemViewModel param) {
                i++;
                final List<VideoItemViewModel> vms = VideoStore.findForLevel(i)
                                                               .stream()
                                                               .map(VideoItemViewModel::new)
                                                               .collect(Collectors.toList());
                return FXCollections.observableArrayList(vms);
            }
        });

        this.root.set(videoItemViewModelRecursiveTreeItem);
    }

    public TreeItem<VideoItemViewModel> getRoot() {
        return root.get();
    }

    public ObjectProperty<TreeItem<VideoItemViewModel>> rootProperty() {
        return root;
    }

}