/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojo.Users;
import com.btl.repository.UserRepostory;
import com.btl.service.UserService;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MTriet
 */
@Service("UserDetailsService")
public class UserServiceImpl implements UserService {
        @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepostory userRepo;

    @Override
    public List<Users> getUsers(Map<String, String> params) {
        return this.userRepo.getUsers(params);
    }

    @Override
    public Long countUsers() {
        return this.userRepo.countUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users u = this.userRepo.getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");

        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRole()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public Users getUsers(String username) {
        return this.userRepo.getUserByUsername(username);
    }

      @Override
    public Users getUserByUn(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepo.authUser(username, password);
    }


   @Override
    public Users addUser(Map<String, String> params) {
        Users u = new Users();
        u.setFirstname(params.get("firstName"));
        u.setLatename(params.get("lastName"));
        
        u.setEmail(params.get("email"));
        u.setUsername(params.get("username"));
        u.setPassword(this.passwordEncoder.encode(params.get("password")));
        u.setRole("ROLE_USER");
        
        this.userRepo.addUser(u);
        return u;
    }

}
