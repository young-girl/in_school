$(function () {

    //创建两个数组
    var names = new Array();
    var smoney = new Array();

    //使用ajax方法得到服务器端数据
    $.get("salesServlet",function (data) {
        // 遍历数据库里的字段
        for(var i = 0;i<data.length;i++){
            //得到每个水果的名字和销售金额
            names[i] = data[i].name;
            smoney[i] = data[i].money;
        }
        //创建图表
        var options = {
            //指定图表的类型
            chart:{
                type:"column" //柱形图
            },
            title:{
                text:"水果销售表"
            },
            xAxis:{
                //指定x的分类
                min:0,
                title: {
                    text: "销量"
                }
            },
            //数据数列
            series:[{
                names:"销量价格",
                //指定工资的范围
                data:smoney
            }]
        };
        //绑定到div对象上
        $("#container").highcharts(options);
    });
});
