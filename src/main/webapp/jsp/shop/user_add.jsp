<%@ page language="java" pageEncoding="utf-8" %>
<%@include file="/jsp/common/commonJs.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${basePath}/dist/layui/css/layui.css" media="all">
    <title>Title</title>
</head>
<style>
  .inputWidth{
      width: 220px;
  }
</style>
<body>
<form class="layui-form" action="" id="formTest">
    <div style="margin-top: 20px;"></div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:</label>
        <div class="layui-input-block">
            <input type="text" id="username" name="username" class="layui-input inputWidth"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码:</label>
        <div class="layui-input-block">
            <input type="text" id="password" name="password" class="layui-input inputWidth"/>
        </div>
    </div>
<%--    <div class="layui-inline">--%>
<%--        <label class="layui-form-label">创建时间:</label>--%>
<%--        <div class="layui-input-inline">--%>
<%--            <input type="text" id="createTime" class="layui-input" name="createTime"/>--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="layui-form-item" style="margin-right: 60px;margin-top: 40px;">
        <div class="layui-input-block" style="text-align: center;">
            <button style="width: 100px;margin-right: 20px;" class="layui-btn" lay-submit lay-filter="submitForm">确定
            </button>
        </div>
    </div>
</form>

</body>
<script>

    $(document).ready(function () {

        layui.use(['layer','form','laydate'],function () {

            var layer  = layui.layer,
                form = layui.form,

            laydate = layui.laydate
            laydate.render({
                elem: "#createTime",
                type: 'datetime',
                min: new Date().getTime()
            })




            form.on("submit(submitForm)",function (data) {
                /*data.createTime = '2020-05-25 00:00:00'*/
                var that = this;
                $.ajax({
                    url:ctx+"user/insertUser",
                    type:'post',
                    dataType:"json",
                    contentType:"application/json",
                    data:JSON.stringify(data.field),
                    success:function (data) {
                       console.info("resukt----->",data)
                        if(data.code==0){
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                            window.parent.layui.table.reload('jobList');
                            window.top.layer.msg('新增成功！');

                        }else{
                            layer.msg(data.msg,{icon:5,offset: '50px'});
                            $(that).removeClass("layui-btn")
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

        })
    })
</script>
</html>
