package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            System.out.println("Error");
        }
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void findById(long id) {
        Optional.ofNullable(entityManager.find(User.class, id))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
