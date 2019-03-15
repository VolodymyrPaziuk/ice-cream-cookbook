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
    public void add(User user) {

    }

    @Override
    public void add(User user, int id) {
        //Todo: add user into users table by id(from user_credentials)
        System.out.println("adding user with id = " + id);

            System.out.println(user.toString());
            /*
            String query = "INSERT INTO users (login, password) VALUES (?,?)";
            try {
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1, userCredentials.getLogin());
                preparedStatement.setString(2, userCredentials.getPassword());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/


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
        return null;
    }

    @Override
    public User getUser(String login, String password) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
