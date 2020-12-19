package com.javaweb.servlet;

import com.javaweb.bean.Sales;
import com.javaweb.service.SalesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/salesServlet")
public class SalesServlet extends HttpServlet {
    //调用业务层
    private SalesService salesService = new SalesService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //指定输出到浏览器上的类型
        response.setContentType("text/json;charset=utf-8");
        //得到打印流进行输出
        PrintWriter out = response.getWriter();
        //得到数据库中所有的员工对象
        List<Sales> sales = salesService.findAllSales();
        //将数据转成json对象后输出到浏览器上
        String json = salesService.tojson(sales);
        out.print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
