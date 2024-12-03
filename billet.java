import java.time.LocalDate;

public class billet implements Publiable {
    protected LocalDate DatePublication;
    protected String auteur;

    public Billet(LocalDate datePub, String auteur){
        this.auteur=auteur;
        this.DatePublication=datePub;

    }

    public LocalDate getDatePublication() {
        return DatePublication;
    }

    public String getAuteur() {
        return auteur;
    }

    public String toString(){
        return ("billet publie le " + DatePublication + "par" + nom)
    }

}
