package com.service;

import com.dao.UserDao;
import com.model.User;
import com.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ServiceSecurity implements UserDetailsService {

    private final UserDao userDao;

    public ServiceSecurity(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userDao.getByName(name);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (UserRole role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantedAuthorities);
    }

}
