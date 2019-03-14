package dao;

import entity.UserCredentials;

import java.sql.SQLException;
import java.util.List;

public interface UserCredentialsDAO {

    void add(UserCredentials userCredentials);

    List<UserCredentials> getAll();

    UserCredentials getUserCredentials(int id);

    UserCredentials getUserCredentials(String login, String password);

    void update(UserCredentials userCredentials);

    void delete(UserCredentials userCredentials);
}
