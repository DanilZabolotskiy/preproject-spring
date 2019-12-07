package ru.javamentor.preproject_spring.repository;

import ru.javamentor.preproject_spring.model.Role;
import java.util.Optional;

public interface RoleDao {

    Optional<Role> findRoleByName(String roleName);

}
