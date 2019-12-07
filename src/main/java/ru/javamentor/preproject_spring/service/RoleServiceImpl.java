package ru.javamentor.preproject_spring.service;

import org.springframework.stereotype.Service;
import ru.javamentor.preproject_spring.model.Role;
import ru.javamentor.preproject_spring.repository.RoleDao;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        return roleDao.findRoleByName(roleName);
    }
}
