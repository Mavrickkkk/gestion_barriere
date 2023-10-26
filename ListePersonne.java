import java.util.*;

public class ListePersonne {
    private ArrayList<Personne> listeP;

    public ListePersonne() {
        listeP = new ArrayList<>();
    }

    public boolean estVide() {
        return (listeP.size() == 0);
    }

    public void add(String n, String prn) {
        Personne p = new Personne(n, prn);
        listeP.add(p);
    }

    public void add(Personne p) {
        listeP.add(p);
    }

    public boolean search(String n, String prn) {
        for (Personne element : listeP) {
            if (element.nom.equals(n) && element.prenom.equals(prn)) {
                System.out.println("Trouvé!");
                return true;
            }
        }
        System.out.println("Pas trouvé!");
        return false;
    }
}
