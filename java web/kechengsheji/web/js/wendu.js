$(function () {

    //创建两个数组
    var names = new Array();
    var smoney = new Array();

    //使用ajax方法得到服务器端数据
    $.get("salesServlet",function (data) {
        // 遍历数据库里的字段
        for (var i = 0; i < data.length; i++) {
            //得到每个水果的名字和销售金额
            names[i] = data[i].name;
            smoney[i] = data[i].money;
        }
        var zhexiantu = {
            title:{
                text:"水果销售折线图"
            },
            subtitle:{
                text: "数据来源：吴洁定制"
            },
            yAxis:{
                title: {
                    text:"销售额"
                }
            },
            legend:{
                layout: "vertical",
                align:"right",
                verticalAlign:"middle"
            },
            series:[{
                name:"销售价格",
                //指定工资的范围
                data:smoney
            }]
        }
        //绑定到div对象上
        $("#container1").highcharts(zhexiantu);
    })
})
