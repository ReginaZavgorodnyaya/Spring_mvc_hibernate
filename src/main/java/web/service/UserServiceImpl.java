package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dto.SaveDto;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public void save(SaveDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        userDao.save(user);
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userDao.delete(id);
    }



    @Transactional
    @Override
    public void update(long id, SaveDto dto) {
        User user = new User();
        user.setId(id);
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        userDao.findById(id);
        userDao.update(user);
    }


}
