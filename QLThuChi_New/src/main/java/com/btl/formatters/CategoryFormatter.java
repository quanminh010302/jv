/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.formatters;

import com.btl.pojo.Categories;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author MTriet
 */
public class CategoryFormatter implements Formatter<Categories>{

    @Override
    public String print(Categories cate, Locale locale) {
        return String.valueOf(cate.getId());
    }

    @Override
    public Categories parse(String cateId, Locale locale) throws ParseException {
        int id = Integer.parseInt(cateId);
        return new Categories(id);
    }
    
}
