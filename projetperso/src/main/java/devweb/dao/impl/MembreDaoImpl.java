package devweb.dao.impl;

import devweb.dao.MembreDao;
import devweb.entities.Membre;
import devweb.servlets.LoginServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao{

    @Override
    public List<Membre> listMembres(){
        String query = "SELECT * FROM membre ORDER BY id;";
        List<Membre> listofMembres = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                listofMembres.add(new Membre(resultSet.getInt("id"),resultSet.getString("pseudo"),resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("mdp")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listofMembres;
    }

    @Override
    public Membre getMembre(Integer id) {
        String query = "SELECT * FROM membre WHERE id=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Membre(resultSet.getInt("id"), resultSet.getString("pseudo"),resultSet.getString("nom"),resultSet.getString("email"),resultSet.getString("mdp"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMembre(String pseudo, String nom, String email,String mdp) {
        String query = "INSERT INTO membre(pseudo, nom, email, mdp) VALUES(?,?,?,?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pseudo);
            statement.setString(2, nom);
            statement.setString(3, email);
            statement.setString(4, mdp);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMdp(String pseudo) {
        String query = "SELECT mdp FROM membre WHERE pseudo=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, pseudo);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return new String(resultSet.getString("mdp"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Membre deleteMembre() {
        String query = "DELETE * FROM membre WHERE pseudo=utilisateurConnecte";

        return null;
    }

}
