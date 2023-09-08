/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojo.Expenses;
import com.btl.service.ExpensesService;
import com.btl.repository.ExpensesRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MTriet
 */
@Service
public class ExpensesServiceImpl implements ExpensesService{
    @Autowired
    private ExpensesRepository expensesRepo;

//    @Override
//    public List<Expenses> getExpenses(Map<String, String> params) {
//        return this.ExpensesRepo.getExpenses(params);
//    }

    @Override
    public List<Expenses> getExpenses(Map<String, String> params) {
        return this.expensesRepo.getExpenses(params);
    }
    
}
