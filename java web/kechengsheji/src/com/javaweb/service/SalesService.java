package com.javaweb.service;

import com.javaweb.bean.Sales;
import com.javaweb.dao.SalesDao;
import flexjson.JSONSerializer;

import java.util.List;

//水果的信息
public class SalesService {
    private SalesDao salesDao = new SalesDao();

    //调用dao得到所有水果信息
    public List<Sales> findAllSales(){
        return salesDao.findAllSales();
    }

    //将数据转成json对象
    public String tojson(List<Sales> sales){
        //创建json转换器对象
        JSONSerializer serializer = new JSONSerializer();
        //排除class属性
        serializer.exclude("class");
        return serializer.serialize(sales);
    }
}
