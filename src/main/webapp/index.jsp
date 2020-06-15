
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/jsp/common/commonJs.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>xx888x</title>
</head>
<script type="text/javascript" src="${basePath}/dist/js/jquery.min.js"></script>
<body>
<form class="layui-form">
    <button class="layui-btn" onclick="show(this)"></button>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">开始时间:</label>
            <div class="layui-input-inline">
                <input id="startTime" type="text" class="layui-input"  placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">开始时间:</label>
            <div class="layui-input-inline">
                <input id="endTime" type="text" class="layui-input"  placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
    </div>
</form>
</body>
<style>
    .layui-layer-btn{
        text-align: center;

    }
</style>
<script>
    $(function () {
        // $(".layui-form").closest(".layui-form-item").css({"color":"red","border":"2px solid red"});

        layui.use(['laydate'],function () {
            var laydate = layui.laydate;
            laydate.render({
                elem: '#startTime', //指定元素
                format:'yyyy-MM-dd HH:mm:ss',
                min: 0,
                type:'datetime',
                done:function (value) {
                    var endDate = new Date($('#endTime').val()).getTime();
                    var startDate = new Date(value).getTime();
                    if (startDate >= endDate) {
                        layer.msg('开始时间不能大于等于结束时间', {
                            icon: 2,
                            time: 2000
                        });
                        $('#startTime').val($('#endTime').val());
                    }
                }
            });

            <!-- 结束时间 -->
            laydate.render({
                elem: '#endTime',
                type: 'datetime',
                min: 0 ,
                done: function (value) {
                    var startDate = new Date($('#startTime').val()).getTime();
                    var endDate = new Date(value).getTime();
                    if (endDate <= startDate) {
                        layer.msg('结束时间不能小于等于开始时间', {
                            icon: 2,
                            time: 2000
                        });
                        $('#endTime').val($('#startTime').val());
                    }
                }
            });


        })
    })

    function show(btn) {

    }

    layui.use(['form','layer','laydate','laytpl'],function () {
        var laydate = layui.laydate;
        var laytpl = layui.laytpl;
        var form = layui.form;
        var layer = layui.layer;


        // layer.confirm('is not?', {icon: 3, btn:['<div id="btn" class="layui-layer-btn btn" style="width: 220px;" >确定</div>']},
        //     function(index){
        //     console.info("true")
        //   },function (index) {
        //         console.info("false")
        //     }
        //
        // );



    })





</script>
</html>
