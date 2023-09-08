///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.btl.repository.Impl;
//
//
//import com.btl.pojo.Categories;
//import com.btl.pojo.Expenses;
//import com.btl.repository.StatsRepository;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author admin
// */
//@Repository
//@Transactional
//public class StatsRepositoryImpl implements StatsRepository {
//    @Autowired
//    private LocalSessionFactoryBean factory;
//    @Autowired
//    private SimpleDateFormat f;
//
//    
//    @Override
//    public List<Object[]> countExpensesByCate() {
//        try ( Session session = this.factory.getObject().getCurrentSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//            Root rE = q.from(Expenses.class);
//            Root rC = q.from(Categories.class);
//
//            q.multiselect(rC.get("id"), rC.get("name"), b.count(rE.get("id")));
//
//            q.where(b.equal(rE.get("category"), rC.get("id")));
//            q.groupBy(rC.get("id"));
//
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }
//    }
//
//    @Override
//    public List<Object[]> statsRevenue(Map<String, String> params){
//        try ( Session session = this.factory.getObject().getCurrentSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//            Root rE = q.from(Expenses.class);
////            Root rC = q.from(Categories.class);
//            
//
//            q.multiselect(rE.get("id"), rE.get("name"), b.sum(rE.get("amount")));
////
////            List<Predicate> predicates = new ArrayList<>();
////            predicates.add(b.equal(rD.get("productId"), rP.get("id")));
////            predicates.add(b.equal(rD.get("orderId"), rO.get("id")));
////
////            String fd = params.get("fromDate");
////            if (fd != null && !fd.isEmpty()) {
////                predicates.add(b.greaterThanOrEqualTo(rO.get("createdDate"), f.parse(fd)));
////            }
////
////            String td = params.get("toDate");
////            if (td != null && !td.isEmpty()) {
////                predicates.add(b.lessThanOrEqualTo(rO.get("createdDate"), f.parse(td)));
////            }
////
////            String quarter = params.get("quarter");
////            if (quarter != null && !quarter.isEmpty()) {
////                String year = params.get("year");
////                if (year != null && !year.isEmpty()) {
////                    predicates.addAll(Arrays.asList(
////                            b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), Integer.parseInt(year)),
////                            b.equal(b.function("QUARTER", Integer.class, rO.get("createdDate")), Integer.parseInt(quarter))
////                    ));
////                }
////            }
//
////            q.where(predicates.toArray(Predicate[]::new));
////            q.where(b.equal(rC, rC));
//            q.groupBy(rE.get("id"));
//
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }
//    }
//
//}
