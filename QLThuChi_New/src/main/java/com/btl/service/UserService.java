/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojo.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MTriet
 */
public interface UserService {
            public List<Users> getUsers(Map<String, String> params);
            Long countUsers();
            
}