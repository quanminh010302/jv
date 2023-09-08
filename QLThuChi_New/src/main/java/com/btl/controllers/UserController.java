/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojo.Users;
import com.btl.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author MTriet
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService; // UserService là một service/service bean để quản lý người dùng

    @GetMapping("/user")
    public String list(Model model, Map<String, String> params) {
        List<Users> userList; // Lấy danh sách người dùng từ service
        userList = userService.getUsers(params);
        model.addAttribute("users", userList); // Thêm danh sách người dùng vào model
        return "user";
    }
}
