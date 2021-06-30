package com.service;

import com.model.UserRole;

import java.util.List;

public interface UserRoleService {

    List<String> getRoleNamesToList();

    UserRole getRoleByName(String name);

    List<UserRole> getAllRoles();
}

