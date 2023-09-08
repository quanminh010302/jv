/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojo.Expenses;
import com.btl.pojo.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MTriet
 */
public interface ExpensesService {
//        public List<Expenses> getExpenses(Map<String, String> params);
     public List<Expenses> getExpenses(Map<String, String> params);
     Long countExpenses();
     Expenses getExpensesById(int id);
     boolean deleteExpenses(int id);
     List<Expenses> getExpensesByUser(Users userId);
}
