
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MTriet
 */
@Repository
@Transactional
@PropertySource("classpath:config.properties")
public class TypeRepositoryImpl implements TypeRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Type> getTypes() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Type> q = b.createQuery(Type.class);
        Root<Type> root = q.from(Type.class);
        q.select(root);

        q.orderBy(b.asc(root.get("id")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateType(Type t) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (t.getId() == null) {
                session.save(t);
            } else {
                session.update(t);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public Type getTypeById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Type.class, id);
    }

    @Override
    public Long countType() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Type");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteType(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Type t = this.getTypeById(id);
        try {
            session.delete(t);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
