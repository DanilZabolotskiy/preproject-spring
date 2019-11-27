package ru.javamentor.preproject_spring.service;

import ru.javamentor.preproject_spring.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUserById(long id);

//  boolean validateUser(User user);

//  Optional<User> getUserByLogin(String login);

}
