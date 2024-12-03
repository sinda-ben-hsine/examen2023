import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Blog blog = new Blog("TechBlog", 5);

        try {

            Message msg1 = new Message(LocalDate.now(), "Alice", "Bienvenue sur mon blog !");
            blog.post(msg1);

            Image img1 = new Image(LocalDate.now(), "Bob", 3, "https://example.com/image1.jpg");
            img1.ajoutTag("geek");
            img1.ajoutTag("tech");
            blog.post(img1);

            Video vid1 = new Video(LocalDate.now(), "Alice", 2, "https://example.com/video1.mp4");
            vid1.ajoutTag("gaming");
            blog.post(vid1);

            Video vid2 = new Video(LocalDate.now(), "Carol", 2, "http://example.com/video2.mp4");
            blog.post(vid2);

        } catch (InvalidURLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Nombre de billets taggables : " + blog.getNombreBilletsTaggables());

        Publiable[] billetsParAlice = blog.RechercheBilletsTaggablesParAuteur("Alice");
        System.out.println("Billets taggables par Alice :");
        for (Publiable billet : billetsParAlice) {
            System.out.println(billet);
        }

        Publiable plusRecent = blog.getPlusRécentBillet();
        System.out.println("Billet le plus récent : " + plusRecent);

        String[] motsCherches = { "blog", "Bienvenue" };
        Publiable[] messagesTrouves = blog.RechercheBilletsParContenu(motsCherches);
        System.out.println("Messages contenant tous les mots :");
        for (Publiable msg : messagesTrouves) {
            System.out.println(msg);
        }
    }
}
