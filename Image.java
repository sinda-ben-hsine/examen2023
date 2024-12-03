import java.time.LocalDate;

public class Image extends BilletTaggable {
    private String url;

    public Image(LocalDate datePub, String auteur, int capacite, String url) {
        super(datePub, auteur, capacite);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Image [" + super.toString() + ", URL=" + url + "]";
    }
}
