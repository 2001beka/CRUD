package com.dao;

import com.model.UserRole;

import java.util.List;

public interface UserRoleDao {

    List<String> getRoleNamesToList();

    UserRole getRoleByName(String name);

    List<UserRole> getAllRoles();
}