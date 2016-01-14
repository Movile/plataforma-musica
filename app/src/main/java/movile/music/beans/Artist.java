package movile.music.beans;

/**
 * Created by amktechnologies on 22/12/15.
 */
public class Artist {

    private int id;
    private String name;
    private String urlImage;
    private Album album;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", album=" + album +
                '}';
    }
}
