package service;

import dao.UserDAO;
import entity.User;

import java.util.List;

public class UserService implements UserDAO {

    @Override
    public void add(User user) {

    }

    @Override
    public void add(User user, int id) {
        //Todo: add user into users table by id(from user_credentials)
    }

    @Override
    public List<User> getAll() {
        return null;
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
