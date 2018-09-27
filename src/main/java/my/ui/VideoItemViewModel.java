package my.ui;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import my.model.Video;


public class VideoItemViewModel implements ViewModel  {

    private final StringProperty uuid = new SimpleStringProperty(this,"uuid");
    private final StringProperty name = new SimpleStringProperty(this, "name");
    private final StringProperty user = new SimpleStringProperty(this, "user");
    private final Video model;

    public VideoItemViewModel(Video video) {
        model = video;
        uuid.set(video.getId().toString());
        name.set(video.getName());
        user.set(video.getUser());
    }

    public StringProperty uuidProperty() {
        return uuid;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty userProperty() {
        return user;
    }

    public Video getModel() {
        return model;
    }
}