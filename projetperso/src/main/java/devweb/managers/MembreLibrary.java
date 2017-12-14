package devweb.managers;

import devweb.dao.MembreDao;
import devweb.dao.impl.MembreDaoImpl;
import devweb.entities.Membre;

import java.util.List;

public class MembreLibrary {

    public List<Membre> listMembres() {
        return membreDao.listMembres();
    }

    private static class MembreLibraryHolder {
        private final static MembreLibrary instance = new MembreLibrary();
    }

    public static MembreLibrary getInstance() {

        return MembreLibraryHolder.instance;
    }

    private MembreDao membreDao = new MembreDaoImpl();

    public void addMembre(String pseudo,String nom,String email,String mdp) {
        if (pseudo == null || "".equals(pseudo)) {
            throw new IllegalArgumentException("The pseudo of the membre should not be empty.");
        }
        membreDao.addMembre(pseudo,nom,email,mdp);
    }

    public String getMdp(String pseudo) {
        if (pseudo == null || "".equals(pseudo)) {
            throw new IllegalArgumentException("The pseudo of the membre should not be empty.");
        }
        return membreDao.getMdp(pseudo);
    }

    public Membre deleteMembre() {
        return membreDao.deleteMembre();
    }


}
