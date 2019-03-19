package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    void add(User user, int id);

    void addById(int id);

    List<User> getAll();

    User getUser(int id);

    User getUser(String name, String surname);

    void update(User user);

    void delete(User user);
}
