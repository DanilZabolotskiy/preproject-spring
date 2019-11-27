package ru.javamentor.preproject_spring.service;

import ru.javamentor.preproject_spring.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public long getIdByLogin(String login);

    public boolean deleteUserByLogin(String login);

    public boolean validateUser(User user);

    public Optional<User> getUserByLogin(String login);
}
