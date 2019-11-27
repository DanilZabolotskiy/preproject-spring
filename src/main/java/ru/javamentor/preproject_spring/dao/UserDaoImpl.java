package ru.javamentor.preproject_spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.javamentor.preproject_spring.model.User;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<User> criteria = session.getCriteriaBuilder().createQuery(User.class);
        criteria.from(User.class);
        List<User> users = session.createQuery(criteria).list();
        session.close();
        return users;
    }

    @Override
    public boolean addUser(User user) {
        Session session = sessionFactory.openSession();
        Optional<User> findUser = findUserByLogin(user.getLogin());
        if (!findUser.isPresent()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        String hql = "delete User u where u.id= :id";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery(hql).setParameter("id", id).executeUpdate();
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Optional<User> findUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        String hql = "from User u where u.login= :login";
        User user = (User) session.createQuery(hql).setParameter("login", login).uniqueResult();
        session.close();
        return Optional.ofNullable(user);
    }
}

