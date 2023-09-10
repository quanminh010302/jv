package com.btl.pojo;

import com.btl.pojo.Categories;
import com.btl.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-10T17:37:34")
@StaticMetamodel(Expenses.class)
public class Expenses_ { 

    public static volatile SingularAttribute<Expenses, Date> date;
    public static volatile SingularAttribute<Expenses, Long> amount;
    public static volatile SingularAttribute<Expenses, String> description;
    public static volatile SingularAttribute<Expenses, Integer> id;
    public static volatile SingularAttribute<Expenses, Users> userId;
    public static volatile SingularAttribute<Expenses, Categories> categoryId;

}