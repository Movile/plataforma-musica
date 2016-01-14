package movile.music.beans;

/**
 * Created by amktechnologies on 22/12/15.
 */
public class Song {

    private String title;
    private String duration;
    private String number;
    private String rating;
    private String urlSong;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", number='" + number + '\'' +
                ", rating='" + rating + '\'' +
                ", urlSong='" + urlSong + '\'' +
                '}';
    }
}
