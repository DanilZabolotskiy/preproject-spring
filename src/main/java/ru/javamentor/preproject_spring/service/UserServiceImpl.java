package ru.javamentor.preproject_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.preproject_spring.dao.UserDao;
import ru.javamentor.preproject_spring.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public long getIdByLogin(String login) {
        return dao.findIdByLogin(login);
    }

    @Override
    public boolean deleteUserByLogin(String login) {
        return dao.deleteByLogin(login);
    }

    @Override
    public boolean validateUser(User user) {
        Optional<User> foundUser = dao.findUserByLogin(user.getLogin());
        return foundUser.filter(user1 ->
                user.getPassword().equals(user1.getPassword())).isPresent();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return dao.findUserByLogin(login);
    }

}
