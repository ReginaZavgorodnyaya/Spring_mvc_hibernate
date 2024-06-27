package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    void save(User user);

    void delete(long id);


    void update(User user);

    void findById(long id);
}
