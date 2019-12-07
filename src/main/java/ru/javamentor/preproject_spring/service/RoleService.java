package ru.javamentor.preproject_spring.service;

import ru.javamentor.preproject_spring.model.Role;
import java.util.Optional;

public interface RoleService {
    Optional<Role> getRoleByName(String roleName);
}
