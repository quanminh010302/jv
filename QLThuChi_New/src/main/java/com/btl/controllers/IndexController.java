/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojo.Expenses;
import com.btl.pojo.Type;
import com.btl.pojo.Users;
import com.btl.service.CategoryService;
import com.btl.service.ExpensesService;
import com.btl.service.TypeService;
import com.btl.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MTriet
 */
@PropertySource("classpath:config.properties")
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private ExpensesService expensesService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("categories", this.categoryService.getCategorieses());
    }

    @RequestMapping("/")

    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("type", this.typeService.getTypes(params));
        model.addAttribute("expenses", this.expensesService.getExpenses(params));
        model.addAttribute("users", this.userService.getUsers(params));

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.expensesService.countExpenses();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));

        return "index";

    }

    @GetMapping("/list_type")
    public String list_type(Model model, Map<String, String> params) {
        List<Type> types = this.typeService.getTypes(params);
        model.addAttribute("type", types);

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.typeService.countType();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "list_type";
    }

}
