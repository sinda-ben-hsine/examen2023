import java.time.LocalDate;
public class billetTaggable extends billet implements Taggable{
    private String[] LTags;
    private int  nbTags;
    public billetTaggable(LocalDate datePub, String auteur, int capacite){
        super(datePub, auteur);
        this.nbTags=0;
        this.LTags=new String[capacite];

    }
    public void ajoutTag(String tag){
        if (nbTags<LTags.length && rechercheTag(tag)==-1) {
            LTags[nbTags++]=tag;
        }

    }
    public void supprimeTag(String tag){
        int pos=rechercheTag(tag);
        if (pos!=-1) {
            LTags[pos]=LTags[--nbTags];
            LTags[nbTags]=null;
            
        }

    }
    public int nombreTags() {
        return nbTags;
    }
    public int rechercheTag(String tag){
        for(int i =0;i<nbTags;i++){
            if (LTags[i].equals(tag)) {
                return i;
                
            }

        }return -1;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(", Tags : ");
        for (int i = 0; i < nbTags; i++) {
            sb.append(LTags[i]);
            if (i < nbTags - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
}
