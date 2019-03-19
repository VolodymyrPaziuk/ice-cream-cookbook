package service;

import connection.DBConnection;
import constants.Attribute;
import dao.UserCredentialsDAO;
import entity.UserCredentials;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCredentialsService implements UserCredentialsDAO {

    @Override
    public void add(UserCredentials userCredentials) {
        System.out.println(userCredentials.toString());
        String query = "INSERT INTO users_credentials (login, password) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userCredentials.getLogin());
            preparedStatement.setString(2, userCredentials.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


/*
    public void addUserCredentials(UserCredentials userCredentials, String id) {
        String query = "INSERT INTO users_credentials (login, password) VALUES (?,?)";
        String queryUser = "INSERT INTO users (id) VALUES (?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userCredentials.getLogin());
            preparedStatement.setString(2, userCredentials.getPassword());
            preparedStatement.executeUpdate();

             preparedStatement = DBConnection.getConnection().prepareStatement(queryUser);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

    @Override
    public List<UserCredentials> getAll() {

        List<UserCredentials> listUserCredentials = new ArrayList<>();
        String query = "Select * from users_credentials";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserCredentials userCredentials = new UserCredentials();
                userCredentials.setLogin(resultSet.getString(Attribute.LOGIN));
                userCredentials.setPassword(resultSet.getString(Attribute.PASSWORD));
                listUserCredentials.add(userCredentials);
                System.out.println(userCredentials.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listUserCredentials;

    }

    @Override
    public UserCredentials getUserCredentials(int id) {

        return null;
    }


    @Override
    public void add(UserCredentials userCredentials, int id) {

    }


    @Override
    public UserCredentials getUserCredentials(String login, String password) {

        UserCredentials userCredentials = null;

        String query = "Select * from users_credentials where login = ? and password = ?";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userCredentials = new UserCredentials();
                userCredentials.setId(resultSet.getInt(Attribute.ID));
                userCredentials.setLogin(resultSet.getString(Attribute.LOGIN));
                userCredentials.setPassword(resultSet.getString(Attribute.PASSWORD));
                System.out.println(userCredentials.toString() + " h");

                return userCredentials;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userCredentials;
    }


    public boolean checkUserCredentials(String login) {
        boolean flag = false;

        String query = "Select exists(select * from users_credentials where login = ?)";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            if (resultSet.getInt(1) != 0) {
                flag = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public void update(UserCredentials userCredentials) {

    }

    @Override
    public void delete(UserCredentials userCredentials) {

    }
}
