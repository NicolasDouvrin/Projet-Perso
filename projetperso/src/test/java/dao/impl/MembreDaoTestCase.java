package dao.impl;

import devweb.dao.MembreDao;
import devweb.dao.impl.DataSourceProvider;
import devweb.dao.impl.MembreDaoImpl;
import devweb.entities.Membre;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class MembreDaoTestCase {

    private MembreDao membreDao = new MembreDaoImpl();

    @Before
    public void initDb() throws Exception {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DELETE FROM membre");
            stmt.executeUpdate("INSERT INTO `membre`(`id`,`pseudo`,`nom`,`email`,`mdp`) VALUES (1,'Kevin59','Boquer Bill','bill.boquer@hei.fr','123')");
            stmt.executeUpdate("INSERT INTO `membre`(`id`,`pseudo`,`nom`,`email`,`mdp`) VALUES (2,'xKillerx','Petitgros Peter','peter.petitgros@hei.fr','voldemort')");
            stmt.executeUpdate("INSERT INTO `membre`(`id`,`pseudo`,`nom`,`email`,`mdp`) VALUES (3,'Dark12','Boulon Jacques','jacques.boulon@hei.fr','vis')");

        }
    }

    @Test
    public void shouldListMembres() {
        // WHEN
        List<Membre> membres = membreDao.listMembres();
        // THEN
        assertThat(membres).hasSize(3);
        assertThat(membres).extracting("id", "pseudo").containsOnly(tuple(3, "Dark12"), tuple(2, "xKillerx"),
                tuple(1, "Kevin59"));
    }

    @Test
    public void shouldGetMembre() {
        // WHEN
        Membre membre = membreDao.getMembre(1);
        // THEN
        assertThat(membre).isNotNull();
        assertThat(membre.getId()).isEqualTo(1);
        assertThat(membre.getNom()).isEqualTo("Boquer Bill");
        assertThat(membre.getPseudo()).isEqualTo("Kevin59");
        assertThat(membre.getEmail()).isEqualTo("bill.boquer@hei.fr");
        assertThat(membre.getMdp()).isEqualTo("123");
    }

    @Test
    public void shouldNotGetUnknownMembre() {
        // WHEN
        Membre membre = membreDao.getMembre(-1);
        // THEN
        assertThat(membre).isNull();
    }

    @Test
    public void shouldAddMembre() throws Exception {
        // WHEN
        membreDao.addMembre("test","test","test","test");
        // THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM membre WHERE nom = 'test' AND pseudo='test' AND email='test' AND mdp='test'")) {
                assertThat(rs.next()).isTrue();
                assertThat(rs.getInt("id")).isGreaterThan(0);
                assertThat(rs.getString("nom")).isEqualTo("test");
                assertThat(rs.getString("pseudo")).isEqualTo("test");
                assertThat(rs.getString("email")).isEqualTo("test");
                assertThat(rs.getString("mdp")).isEqualTo("test");
                assertThat(rs.next()).isFalse();
            }
        }
    }
}
