public class Blog {
    private String titre;
    private Publiable[] lBillets;
    private int nbBillets;

    public Blog(String titre, int nbBillets) {
        this.titre = titre;
        this.lBillets = new Publiable[capacite];
        this.nbBillets = 0;

    }

    public void post(Publiable billet) throws InvalidURLException {
        if (billet instanceof Video) {
            Video video = (Video) billet;
            if (!video.getUrl().startsWith("https")) {
                throw new InvalidURLException("L'URL de la vidéo doit utiliser HTTPS.");
            }
        }

        if (nbBillets < LBillets.length) {
            LBillets[nbBillets++] = billet;
        }
    }

    public int getNombreBilletsTaggables() {
        int count = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof BilletTaggable) {
                count++;
            }
        }
        return count;
    }

    public Publiable[] RechercheBilletsTaggablesParAuteur(String auteur) {
        Publiable[] resultat = new Publiable[nbBillets];
        int index = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof BilletTaggable && LBillets[i].getAuteur().equals(auteur)) {
                resultat[index++] = LBillets[i];
            }
        }
        return java.util.Arrays.copyOf(resultat, index);
    }

    public Publiable getPlusRécentBillet() {
        Publiable plusRecent = LBillets[0];
        for (int i = 1; i < nbBillets; i++) {
            if (LBillets[i].getDatePublication().isAfter(plusRecent.getDatePublication())) {
                plusRecent = LBillets[i];
            }
        }
        return plusRecent;
    }

    public Publiable[] RechercheBilletsParContenu(String[] mots) {
        Publiable[] resultat = new Publiable[nbBillets];
        int index = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof Message) {
                Message msg = (Message) LBillets[i];
                boolean tousLesMotsPresent = true;
                for (String mot : mots) {
                    if (msg.getContenu().indexOf(mot) == -1) {
                        tousLesMotsPresent = false;
                        break;
                    }
                }
                if (tousLesMotsPresent) {
                    resultat[index++] = msg;
                }
            }
        }
        return java.util.Arrays.copyOf(resultat, index);
    }
}
