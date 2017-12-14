package devweb.dao;

import devweb.entities.Membre;

import java.util.List;

public interface MembreDao {

    public List<Membre> listMembres();

    public Membre getMembre(Integer id);

    public void addMembre(String pseudo,String nom,String email,String mdp);

    public String getMdp(String pseudo);

    public Membre deleteMembre(String pseudo);
}
