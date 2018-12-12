package restServer.request;

import models.Actor;
import models.Genre;

import java.util.ArrayList;

public class FrontendMovie {

    String Name;
    String Description;

    public String getBgImage() {
        return BgImage;
    }

    public void setBgImage(String bgImage) {
        BgImage = bgImage;
    }

    String BgImage;
    Double Duration;
    ArrayList<Integer> Actors;
    ArrayList<Integer> Genres;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getDuration() {
        return Duration;
    }

    public void setDuration(Double duration) {
        Duration = duration;
    }

    public ArrayList<Integer> getActors() {
        return Actors;
    }

    public void setActors(ArrayList<Integer> actors) {
        Actors = actors;
    }

    public ArrayList<Integer> getGenres() {
        return Genres;
    }

    public void setGenres(ArrayList<Integer> genres) {
        Genres = genres;
    }

}
