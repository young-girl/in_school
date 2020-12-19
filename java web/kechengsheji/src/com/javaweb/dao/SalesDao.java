package com.javaweb.dao;

import com.javaweb.bean.Sales;
import com.javaweb.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

//数据访问类，访问数据库的
public class SalesDao {
    //通过jar包中的工具类得到数据源对象，传递给QueryRunner
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    //查询所有的信息
    public List<Sales> findAllSales(){
        try {
           return runner.query("SELECT * FROM sales",new BeanListHandler<>(Sales.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
