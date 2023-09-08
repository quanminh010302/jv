/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojo.Type;
import com.btl.repository.TypeRepository;
import com.btl.service.TypeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MTriet
 */
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeRepository typeRepo;

//    @Override
//    public List<Expenses> getExpenses(Map<String, String> params) {
//        return this.ExpensesRepo.getExpenses(params);
//    }

    @Override
    public List<Type> getTypes() {
        return this.typeRepo.getTypes();
    }


}
