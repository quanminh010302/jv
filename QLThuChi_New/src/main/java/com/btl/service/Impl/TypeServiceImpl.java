/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojo.Type;
import com.btl.repository.TypeRepository;
import com.btl.service.TypeService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MTriet
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepo;
//    @Autowired
//    private Cloudinary cloudinary;

//    @Override
//    public List<Expenses> getExpenses(Map<String, String> params) {
//        return this.ExpensesRepo.getExpenses(params);
//    }
    @Override
    public List<Type> getTypes(Map<String, String> params) {
        return this.typeRepo.getTypes(params);
    }

    @Override
    public boolean addOrUpdateType(Type t) {
        

        return this.typeRepo.addOrUpdateType(t);
    }

    @Override
    public Type getTypeById(int id) {
        return this.typeRepo.getTypeById(id);
    }

    @Override
    public Long countType() {
        return this.typeRepo.countType();
    }

    @Override
    public boolean deleteType(int id) {
      return this.typeRepo.deleteType(id);
    }

}
