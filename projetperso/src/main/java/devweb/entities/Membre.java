package devweb.entities;

public class Membre {

        private Integer id;
        private String nom;
        private String pseudo;
        private String email;
        private String mdp;


    public Membre(Integer id, String pseudo, String nom, String email,String mdp) {
        this.id = id;
        this.pseudo = pseudo;
        this.nom = nom;
        this.email = email;
        this.mdp=mdp;
    }


    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() { return mdp; }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}
