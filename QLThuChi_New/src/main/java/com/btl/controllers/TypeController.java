/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojo.Type;
import com.btl.service.TypeService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author MTriet
 */
@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;
    
    @GetMapping("/type")
    public String list(Model model){
        model.addAttribute("type", new Type());
        
        return "type";
    }
    @GetMapping("/type/{id}")
    public String update(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("type", this.typeService.getTypeById(id));
        return "type";
    }
    
    @PostMapping("/type")
    public String addType(@ModelAttribute(value = "type") @Valid Type t, BindingResult rs) {
        if(!rs.hasErrors())
            if (typeService.addOrUpdateType(t) == true)
                return "redirect:/list_type";
        
        return "type";
    }
    
}
