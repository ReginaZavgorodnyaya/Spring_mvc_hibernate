package web.service;

import web.dto.SaveDto;
import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(SaveDto dto);

    void deleteUserById(long id);

    void update(long id, SaveDto dto);
}
