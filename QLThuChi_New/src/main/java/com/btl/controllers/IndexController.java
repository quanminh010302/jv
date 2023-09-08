/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;


import com.btl.service.CategoryService;
import com.btl.service.ExpensesService;
import com.btl.service.TypeService;
import com.btl.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MTriet
 */

//@PropertySource("classpath:configs.properties")
@Controller
public class IndexController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private ExpensesService expensesService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    
    
    public String index(Model model, @RequestParam Map<String, String> params){
        
        model.addAttribute("type", this.typeService.getTypes());
        model.addAttribute("expenses", this.expensesService.getExpenses(params));
        model.addAttribute("users", this.userService.getUsers(params));
        model.addAttribute("categories", this.categoryService.getCategorieses());
        return "index";


    }
}
