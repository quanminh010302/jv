/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojo.Users;
import com.btl.repository.UserRepostory;
import com.btl.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MTriet
 */
@Service
public class UserServiceImpl implements UserService{
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

   
}
