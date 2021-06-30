package com.service;

import com.dao.UserRoleDao;
import com.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDao roleDao;
    @Autowired
    public UserRoleServiceImpl(UserRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<String> getRoleNamesToList() {
        return roleDao.getRoleNamesToList();
    }

    @Override
    @Transactional
    public UserRole getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional
    public List<UserRole> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
