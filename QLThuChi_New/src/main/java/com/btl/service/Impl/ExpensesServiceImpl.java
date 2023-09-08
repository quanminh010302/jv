/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojo.Expenses;
import com.btl.pojo.Users;
import com.btl.service.ExpensesService;
import com.btl.repository.ExpensesRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MTriet
 */
@Service
@Transactional
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepo;
    @Autowired
    public ExpensesServiceImpl(ExpensesRepository expenseRepository) {
        this.expensesRepo = expenseRepository;
    }

//    @Override
//    public List<Expenses> getExpenses(Map<String, String> params) {
//        return this.ExpensesRepo.getExpenses(params);
//    }
    @Override
    public List<Expenses> getExpenses(Map<String, String> params) {
        return this.expensesRepo.getExpenses(params);
    }
    
    @Override
    public Long countExpenses() {
        return this.expensesRepo.countExpenses();
    }
    
    @Override
    public Expenses getExpensesById(int id) {
        return this.expensesRepo.getExpensesById(id);
    }

    @Override
    public boolean deleteExpenses(int id) {
        return this.expensesRepo.deleteExpenses(id);
    }

    @Override
    public List<Expenses> getExpensesByUser(Users userId) {
        return this.expensesRepo.findByUserId(userId);
    }
}

