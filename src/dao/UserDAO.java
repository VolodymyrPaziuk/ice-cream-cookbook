package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    void add(User user);

    void add(User user, int id);

    List<User> getAll();

    User getUser(int id);

    User getUser(String login, String password);

    void update(User user);

    void delete(User user);
}
