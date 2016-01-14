package movile.music.beans;

/**
 * Created by amktechnologies on 22/12/15.
 */
public class Album {

    private String title;
    private String description;
    private String duration;
    private String year;
    private String numberOfSong;
    private String urlImageAlbum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumberOfSong() {
        return numberOfSong;
    }

    public void setNumberOfSong(String numberOfSong) {
        this.numberOfSong = numberOfSong;
    }

    public String getUrlImageAlbum() {
        return urlImageAlbum;
    }

    public void setUrlImageAlbum(String urlImageAlbum) {
        this.urlImageAlbum = urlImageAlbum;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", year='" + year + '\'' +
                ", numberOfSong='" + numberOfSong + '\'' +
                ", urlImageAlbum='" + urlImageAlbum + '\'' +
                '}';
    }
}
