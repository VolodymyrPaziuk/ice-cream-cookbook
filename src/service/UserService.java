package service;

import connection.DBConnection;
import constants.Attribute;
import dao.UserDAO;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDAO {

    @Override
    public void add(User user, int credId) {
        String query = "INSERT INTO users (name, surname, users_credentials_id) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)){

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, credId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void addById( int credId) {//rename to add User id

            String query = "INSERT INTO users (users_credentials_id) VALUES (?)";

            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);){

                preparedStatement.setInt(1, credId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }



    @Override
    public List<User> getAll() {
        List<User> listUsers = new ArrayList<>();
        String query = "Select * from users";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString(Attribute.NAME));
                user.setSurname(resultSet.getString(Attribute.SURNAME));
                listUsers.add(user);
                System.out.println(listUsers.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listUsers;
    }

    @Override
    public User getUser(int id) {
        String query = "Select * from users where users_credentials_id = ? ";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));

                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUser(String name, String surname) {
        return null;
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users SET name = ?, surname = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)){

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(User user) {

    }
}
