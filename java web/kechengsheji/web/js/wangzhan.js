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
        var bingtu = {
            chart:{
                plotBackgroundColor:null,
                plotBorderWidth:null,
                plotShadow:false,
                type:"pie"
            },
            title:{
                text:"2020年水果销售占比"
            },
            tooltip:{
                pointFormat:'{series.names}:<b>{point.percentage:.lf}%</b>',
            },
            plotOptions:{
                pie:{
                    allowPointSelect: true,
                    cursor:"pointer",
                    dataLabels:{
                        enabled:true,
                        format:"<b>{point.name}</b>:{point.percentage:.lf}%",
                        // style:{
                        //     color:(Highcharts.theme && Highcharts.theme.contrastColor) || "black"
                        // },
                    }
                },
            },
            legend:{
                data:names
            },
            series:[{
                type:"pie",
                name:"销售额",
                //销售额
                data:smoney
            }]
            };
        //绑定到div对象上,用jquery
        $("#containerbing").highcharts(bingtu);
})
})
