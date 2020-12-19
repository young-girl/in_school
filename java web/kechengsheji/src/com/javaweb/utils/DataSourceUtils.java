package com.javaweb.utils;

//数据源工具类

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class DataSourceUtils {
    //创建一个连接池
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    //得到数据源对象
    public static DataSource getDataSource(){
        return ds;
    }
}
