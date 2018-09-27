package my.ui;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import my.model.Video;


public class VideoItemViewModel implements ViewModel  {

    StringProperty uuid = new SimpleStringProperty(this,"uuid");
    StringProperty name = new SimpleStringProperty(this, "name");
    StringProperty user = new SimpleStringProperty(this, "user");

    public VideoItemViewModel(Video video) {
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

}