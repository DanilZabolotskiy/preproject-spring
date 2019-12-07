package ru.javamentor.preproject_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.javamentor.preproject_spring.repository.UserDao;
import ru.javamentor.preproject_spring.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao, BCryptPasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        String simplePassword = user.getPassword();
        String encodePassword = passwordEncoder.encode(simplePassword);
        user.setPassword(encodePassword);
        return dao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public boolean deleteUserById(long id) {
        return dao.deleteById(id);
    }

 /*   @Override
    public boolean validateUser(User user) {
        Optional<User> foundUser = repository.findUserByLogin(user.getLogin());
        return foundUser.filter(user1 ->
                user.getPassword().equals(user1.getPassword())).isPresent();
    }*/

   @Override
    public Optional<User> getUserByLogin(String login) {
        return dao.findUserByLogin(login);
    }

}
