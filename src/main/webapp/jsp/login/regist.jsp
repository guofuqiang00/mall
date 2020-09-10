<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/jsp/common/commonJs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${basePath}/dist/layui/css/layui.css"  media="all">

</head>

<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<style>
    .layui-input-block input{
        width: 222px;
    }
</style>
<body>

<div class="productTable" >
    <div style="height: 150px"></div>

    <form class="layui-form" style="width: 400px;margin: 0px auto">

        <div class="layui-form-item">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="required|username" autocomplete="off" placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input type="text" name="password" lay-verify="required|password" autocomplete="off" placeholder="请输入密码" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" style="margin-right: 60px;margin-top: 40px;">
            <div class="layui-input-block" style="text-align: center;">
                <button style="width: 100px;margin-right: 20px;" class="layui-btn" lay-submit lay-filter="submitForm">注册
                </button>
            </div>
        </div>
    </form>
</div>

<table class="layui-hide" id="LAY_table_product" lay-filter="product">

</table>
<script src="${basePath}/dist/layui/layui.js" charset="utf-8"></script>
<script>
    $(document).ready(function () {
        layui.use(['layer', 'form', 'laydate'], function () {
            var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form ;

            laydate = layui.laydate
            laydate.render({
                elem: "#clueNectDate",
                type: 'datetime',
                min: new Date().getTime()
            })

            //自定义验证规则
            form.verify({
                cluePhone: [/^1\d{10}$/, "请输入正确的手机号"],
                clueEmail: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对'],
                number: [ /^[1-9]\d*$/,'只能是整数哦']
            });

            form.on("submit(submitForm)",function (data) {
                console.info(data)
                var that = this;
                $.ajax({
                    url:ctx+"/login/regist",
                    type:'post',
                    dataType:"json",
                    contentType:"application/json",
                    data:JSON.stringify(data.field),
                    success:function (data) {
                        console.info("resukt----->",data)
                        if(data.code==200){
                            window.top.layer.msg('注册成功！');
                            window.location.href=ctx+"/jsp/login/login.jsp"
                        }else{
                            layer.msg(data.msg,{icon:5,offset: '50px'});
                            // $(that).removeClass("layui-btn")
                        }
                    },
                    error:function (d) {
                        layer.alert("请求失败", {icon: 6},function () {
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        });
                    }

                })

                return false

            })
        });

    })

</script>
</body>
<script>
    var i = 0;
    console.info(i++)
</script>
</html>