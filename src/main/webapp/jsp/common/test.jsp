<%@ page language="java" pageEncoding="utf-8" %>
<%@include file="/jsp/common/commonJs.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${basePath}/dist/layui/css/layui.css" media="all">
    <title>Title</title>
</head>
<body id="body">
    <button class="layui-btn" onclick="get1()">传一个map</button>
    <button class="layui-btn" onclick="selectUserByMap2()">selectUserByMap2</button>
    <button class="layui-btn" onclick="selectUserByMap3()">selectUserByMap3</button>
    <button class="layui-btn" onclick="get2()">传一个user</button>
    <button class="layui-btn" onclick="get3()">传一个user2</button>
    <button class="layui-btn" onclick="get4()">get4</button>
    <input style="width: 150px" value="ccc"   class="aaa"></input>
    <input style="width: 150px" value=""  class="aaa"></input>
    <input style="width: 150px"  value=""  class="aaa"></input>
    <input style="width: 150px"  value=""  class="aaa"></input>
    <input style="width: 150px"  value=""  class="aaa"></input>
</body>
<script type="text/html" id="rank">    {{d.LAY_TABLE_INDEX+1}}</script>
<script>

    var elementsByClassName = document.getElementsByClassName("aaa");
    console.info("elementsByClassName-->>",elementsByClassName)
   console.info( elementsByClassName[0])

    $(".aaa").each(function (data) {
        document.getElementsByClassName("aaa")[data].value = data;
    })




    layui.use(['colorpicker','layer'], function(){
        var layer = layui.layer;
        var $ = layui.$,colorpicker = layui.colorpicker;
        //常规使用
        var html = 'div id="test11" class="test11" style="margin-left: 30px;">\n' +
            '\n' +
            '    </div>';

        $("#colors").after(html)

        colorpicker.render({
            elem: '.test11' //绑定元素
            ,change: function(color){ //颜色改变的回调
                layer.tips('选择了：'+ color, this.elem, {
                    tips: 1
                });
            }
        });


    })


function get1() {
    var params = {
        "id":1867494225,
        "username":"admin"
    }
    var params1={};
    params1['aa']="aa";
    params1['bb']="bb";
    $.ajax({
        url:"http://localhost:8080/user/selectUserByMap",
        type:"post",
        contentType : 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            console.info("data--->",data)
        }
    })
}
function selectUserByMap2() {
    var params = {
        "id":1867494225,
        "username":"admin"
    }
    var params1={};
    params1['aa']="aa";
    params1['bb']="bb";
    $.ajax({
        url:"http://localhost:8080/user/selectUserByMap2",
        type:"post",
        contentType : 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            console.info("data--->",data)
        }
    })
}
function selectUserByMap3() {
    var params = {

            "id":1867494225,
            "username":"admin"
    }

    $.ajax({
        url:"http://localhost:8080/user/selectUserByMap3?password=123456",
        type:"post",
        contentType : 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            console.info("data--->",data)
        }
    })
}

function get2() {
    var params1={};
    params1['aa']="aa";
    params1['bb']="bb";
    var user = {
        id:1867494225,username:"admin"
    }

    $.ajax({
        url:"http://localhost:8080/user/selectUserByUser",
        type:"get",
        data:user,
        dataType:"json",
        success:function (data) {
            console.info("data--->",data)
        }
    })
}
function get3() {
    var params1={};
    params1['aa']="aa";
    params1['bb']="bb";
    $.ajax({
        url:"http://localhost:8080/user/selectUserByUser",
        type:"get",
        data:{id:1867494225,username:"admin"},
        success:function (data) {
            console.info("data--->",data)
        }
    })
}
function get4() {

    $.ajax({
        url:"http://localhost:8080/user/selectUserByUser4",
        type:"POST",
        data:JSON.stringify({"id":255555}),
        contentType : 'application/json',
        dataType:"json",
        success:function (data) {
            console.info("data--->",data)
        }
    })
}


</script>

</html>
