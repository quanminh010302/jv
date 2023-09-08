/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.Impl;

import com.btl.pojo.Expenses;
import com.btl.repository.ExpensesRepository;
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
 * @author admin
 */
//@Repository
//@Transactional
//public class ExpensesRepositoryImpl implements ExpensesRepository {
//
//    @Autowired
//    private LocalSessionFactoryBean factory;
//
//    @Override
//    public List<Expenses> getExpenses(Map<String, String> params) {
//        try (Session session = this.factory.getObject().getCurrentSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Expenses> q = b.createQuery(Expenses.class);
//            Root root = q.from(Expenses.class);
//            q.select(root);
//            
//            if (params != null) {
//                List<Predicate> predicates = new ArrayList<>();
//                
//                String kw = params.get("kw");
//                if (kw != null && !kw.isEmpty()) 
//                    predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
//                
//                String fromAmount = params.get("fromAmount");
//                if (fromAmount != null && !fromAmount.isEmpty()) 
//                    predicates.add( b.greaterThanOrEqualTo(root.get("amount"), Double.parseDouble(fromAmount)));
//                
//                String toAmount = params.get("toAmount");
//                if (toAmount != null && !toAmount.isEmpty()) 
//                    predicates.add( b.lessThanOrEqualTo(root.get("amount"), Double.parseDouble(toAmount)));
//                
//                String cateId = params.get("cateId");
//                if (cateId != null && !cateId.isEmpty()) 
//                    predicates.add( b.lessThanOrEqualTo(root.get("categoriesId"), Integer.parseInt(cateId)));
//                
//                q.where(predicates.toArray(Predicate[]::new));
//            }
//            
//            q.orderBy(b.desc(root.get("id")));
//            
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }
//    }
//    @Override
//    public List<Expenses> getExpenses() {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Expenses");
//
//        return q.getResultList();
//    }
//    @Override
//    public List<Expenses> getExpenses() {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Expenses");
//
//        return q.getResultList();
//    }
//    @Override
//    public List<Expenses> getExpenses() {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Expenses");
//
//        return q.getResultList();
//    }
//    @Override
//    public List<Expenses> getExpenses() {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Expenses");
//
//        return q.getResultList();
//    }
//}

@Repository
@Transactional
@PropertySource("classpath:config.properties")
public class ExpensesRepositoryImpl implements ExpensesRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Override
    public List<Expenses> getExpenses(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Expenses> q = b.createQuery(Expenses.class);
        Root<Expenses> root = q.from(Expenses.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) 
                predicates.add(b.like(root.get("description"), String.format("%%%s%%", kw)));

            String fromAmount = params.get("fromAmount");
            if (fromAmount != null && !fromAmount.isEmpty()) 
                predicates.add(b.greaterThanOrEqualTo(root.get("amount"), Double.parseDouble(fromAmount)));

            String toAmount = params.get("toAmount");
            if (toAmount != null && !toAmount.isEmpty()) 
                predicates.add(b.lessThanOrEqualTo(root.get("amount"), Double.parseDouble(toAmount)));

            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) 
                predicates.add(b.equal(root.get("categoryId"), Integer.parseInt(cateId)));

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

        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }
}

