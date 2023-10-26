import java.util.*;

public class Personne {
    protected String nom, prenom;
    protected Connexion connexion;

    public Personne(String n, String prn) {
        this.nom = n;
        this.prenom = prn;
        this.connexion = null;
    }

    public Personne(String n, String prn, String l, String pw) {
        this.nom = n;
        this.prenom = prn;
        this.connexion = new Connexion(l, pw);
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getLogin() throws NullPointerException {
        if (this.connexion != null)
            return this.connexion.login;
        else {
            throw new NullPointerException("Cette personne n'a pas de compte.");
        }
    }

    public String getPassword() throws NullPointerException {
        if (this.connexion != null)
            return this.connexion.password;
        else {
            throw new NullPointerException("Cette personne n'a pas de compte.");
        }
    }

    public Boolean seConnecter(String l, String p) {
        try {
            if (this.getLogin().equals(l) && this.getPassword().equals(p)) {
                System.out.println("Connexion effectuée.");
                return true;
            } else {
                System.out.println("Login et/ou password incorrecte.");
                return false;
            }
        } catch (NullPointerException npe) {
            System.out.println("Erreur de connexion : " + npe.getMessage());
            return false;
        }

    }

    public static void main(String args[]) {
        Personne p1 = new Personne("Gouix", "Mavrick", "gouix.mavrick", "Mavrick2003");
        Personne p2 = new Personne("Berton", "Carl");
        ListePersonne l = new ListePersonne();

        l.add(p1);
        l.add(p2);

        l.search("Gouix", "Mavrick");
        p1.seConnecter("gouix.mavrick", "Mavrick2003");
    }

}