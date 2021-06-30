package com.dao;


import com.model.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
@Repository
public class UserRoleDaoImpl implements UserRoleDao {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<String> getRoleNamesToList() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("select role from UserRole").getResultList();    }

    @Override
    @Transactional
    public UserRole getRoleByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("select role from UserRole role where role.role=:role");
        query.setParameter("role", name);
        return (UserRole) query.getSingleResult();
    }

    @Override
    @Transactional
    public List<UserRole> getAllRoles() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from UserRole").list();
    }
}

