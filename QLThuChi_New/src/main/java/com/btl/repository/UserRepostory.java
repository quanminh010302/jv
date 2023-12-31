/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojo.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MTriet
 */
public interface UserRepostory {

    Users getUserByUsername(String username);

    boolean authUser(String username, String password);

    Users addUser(Users user);

    public List<Users> getUsers(Map<String, String> params);

    Long countUsers();
}
