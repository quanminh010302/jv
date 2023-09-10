package com.btl.pojo;

import com.btl.pojo.Expenses;
import com.btl.pojo.Type;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-10T17:37:34")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile SingularAttribute<Categories, String> name;
    public static volatile SetAttribute<Categories, Expenses> expensesSet;
    public static volatile SingularAttribute<Categories, Integer> id;
    public static volatile SetAttribute<Categories, Type> typeSet;

}