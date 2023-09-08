
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojo.Type;
import com.btl.repository.TypeRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MTriet
 */
@Repository
@Transactional
    public class TypeRepositoryImpl implements TypeRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Type> getTypes() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Type");
        return q.getResultList();
    }




}
