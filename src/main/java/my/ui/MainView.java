package my.ui;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;


public class MainView implements FxmlView<MainViewModel> {

    @FXML private TreeTableView<VideoItemViewModel> videoTreeTableView;
    @FXML private TreeTableColumn<VideoItemViewModel, String> uuidCol;
    @FXML private TreeTableColumn<VideoItemViewModel, String> userCol;
    @FXML private TreeTableColumn<VideoItemViewModel, String> nameCol;

    @InjectViewModel
    private MainViewModel viewModel;

    public void initialize() {
        videoTreeTableView.rootProperty().bind(viewModel.rootProperty());
        uuidCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("uuid"));
        userCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("user"));
        nameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
    }

    public void switchValues(ActionEvent actionEvent) {
        viewModel.switchDirectory();
    }
}