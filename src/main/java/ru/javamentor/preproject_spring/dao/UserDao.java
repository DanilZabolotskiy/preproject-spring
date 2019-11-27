package ru.javamentor.preproject_spring.dao;

import ru.javamentor.preproject_spring.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> getAllUsers();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteByLogin(String login);

    long findIdByLogin(String login);

    Optional<User> findUserByLogin(String login);
}
