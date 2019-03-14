package dao;

import entity.UserCredentials;

import java.util.List;

public interface UserCredentialsDAO {

    void add(UserCredentials userCredentials);

    void add(UserCredentials userCredentials, int id);

    List<UserCredentials> getAll();

    UserCredentials getUserCredentials(int id);

    UserCredentials getUserCredentials(String login, String password);

    void update(UserCredentials userCredentials);

    void delete(UserCredentials userCredentials);
}
