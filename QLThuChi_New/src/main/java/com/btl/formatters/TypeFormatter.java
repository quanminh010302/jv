/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.formatters;


import com.btl.pojo.Type;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;



/**
 *
 * @author MTriet
 */
public class TypeFormatter implements Formatter<Type>{

    @Override
    public String print(Type type, Locale locale) {
        return String.valueOf(type.getId());
    }

    @Override
    public Type parse(String typeId, Locale locale) throws ParseException {
          int id = Integer.parseInt(typeId);
        return new Type(id);
    }

    
}
