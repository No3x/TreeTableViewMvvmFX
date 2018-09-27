package my;

import de.saxsys.mvvmfx.FluentViewLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import my.ui.MainView;

public class App extends Application {

    private Stage primaryStage;

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("App");

        final Parent parent = FluentViewLoader.fxmlView(MainView.class).load().getView();

        stage.setScene(new Scene(parent));
        stage.show();
    }

}
