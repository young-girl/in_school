package com.javaweb.test;

import com.javaweb.bean.Sales;
import com.javaweb.dao.SalesDao;
import com.javaweb.service.SalesService;
import com.javaweb.utils.DataSourceUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;


public class TestSalesDao {
    SalesDao salesDao = new SalesDao();
    SalesService salesService = new SalesService();

    @Test
    public void testGetDataSource(){
        DataSource ds = DataSourceUtils.getDataSource();
        System.out.println(ds);
    }

    @Test
    public void testFindSales(){
        List<Sales> shuiguo = salesDao.findAllSales();
        for(Sales sales : shuiguo){
            System.out.println(sales);
        }
    }

    @Test
    public void testToJson(){
        List<Sales> sales = salesService.findAllSales();
        String toJSon = salesService.tojson(sales);
        System.out.println(toJSon);
    }
}
