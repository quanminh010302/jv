/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.Impl;

import com.btl.pojo.Categories;
import com.btl.repository.CategoryRepository;
import com.btl.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MTriet
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository cateRepo;
    
    
    @Override
    public List<Categories> getCategorieses() {
        return this.cateRepo.getCategorieses();
    }
    
}
