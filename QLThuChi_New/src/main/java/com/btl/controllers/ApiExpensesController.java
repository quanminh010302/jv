/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojo.Expenses;
import com.btl.service.CategoryService;
import com.btl.service.ExpensesService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MTriet
 */
@RestController
@RequestMapping("/api")
public class ApiExpensesController {
    @Autowired
    private ExpensesService expenService;
    // xóa
    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id")int id ){
        this.expenService.deleteExpenses(id);
    
    }
   
       @RequestMapping("/expenses")
    @CrossOrigin
    public ResponseEntity<List<Expenses>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.expenService.getExpenses(params), HttpStatus.OK);
    }
    

}
