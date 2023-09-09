/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojo.Users;
import com.btl.repository.UserRepostory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
public class UserRepostoryImpl implements UserRepostory {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Users> getUsers(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Users> q = b.createQuery(Users.class);
        Root<Users> root = q.from(Users.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) 
                predicates.add(b.like(root.get("username"), String.format("%%%s%%", kw)));

           
            
            String fromDateStr = params.get("fromDate");
            String toDateStr = params.get("toDate");

            if (fromDateStr != null && !fromDateStr.isEmpty() && toDateStr != null && !toDateStr.isEmpty()) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fromDate = dateFormat.parse(fromDateStr);
                    Date toDate = dateFormat.parse(toDateStr);
                    
                    // Thêm điều kiện tìm kiếm theo ngày tháng năm
                    predicates.add(b.between(root.get("date"), fromDate, toDate));
                } catch (ParseException e) {
                    // Xử lý nếu có lỗi xảy ra khi chuyển đổi ngày
                }
            }

            q.where(predicates.toArray(new Predicate[0]));
        }

        q.orderBy(b.asc(root.get("role")));

        Query query = session.createQuery(q);
        
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public Long countUsers() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Users");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Users getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q= s.createQuery("FROM Users WHERE username:un");
        q.setParameter("un", username);
        return (Users) q.getSingleResult();
    }

}
