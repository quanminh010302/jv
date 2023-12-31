/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojo.Type;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MTriet
 */
public interface TypeRepository {
        public List<Type> getTypes( Map<String, String> params);
        boolean addOrUpdateType(Type t);
        Type getTypeById(int id);
        Long countType(); 
        boolean deleteType (int id);
}
