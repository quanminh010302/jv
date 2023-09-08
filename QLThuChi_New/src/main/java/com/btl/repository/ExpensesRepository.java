/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojo.Expenses;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MTriet
 */
public interface ExpensesRepository {
    public List<Expenses> getExpenses(Map<String, String> params);
//        public List<Expenses> getExpenses();

}
