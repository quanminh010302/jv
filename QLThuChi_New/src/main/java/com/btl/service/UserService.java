/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojo.Users;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author MTriet
 */
public interface UserService extends UserDetailsService{
    
        Users getUserByUn(String username);
    boolean authUser(String username, String password);
    Users addUser(Map<String, String> params);
           
    Users getUsers(String username);
            public List<Users> getUsers(Map<String, String> params);
            Long countUsers();
            
}
