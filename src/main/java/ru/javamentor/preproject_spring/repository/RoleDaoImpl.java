package ru.javamentor.preproject_spring.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.javamentor.preproject_spring.model.Role;
import java.util.Optional;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Role> findRoleByName(String roleName) {
        Session session = sessionFactory.openSession();
        String hql = "from Role r where r.roleName= :roleName";
        Role role = (Role) session.createQuery(hql).setParameter("roleName", roleName).uniqueResult();
        session.close();
        return Optional.ofNullable(role);
    }
}
