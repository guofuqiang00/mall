<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/jsp/common/commonJs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
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

<div class="productTable">
    <div style="height: 50px"></div>

    <form class="layui-form" style="width: 400px;">
        <div class="layui-form-item">
            <label class="layui-form-label">等级:</label>
            <div class="layui-input-block" style="width: 222px" >
                <select name="clueClientRank"  lay-filter="clueClientRank">
                    <option value="0">等级一</option>
                    <option value="1">等级二</option>
                    <option value="2">等级三</option>
                    <option value="3">等级四</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职业:</label>
            <div class="layui-input-block" style="width: 222px" >
                <select name="clueClientVocation"  lay-filter="clueClientVocation">
                    <option value="0">互联网</option>
                    <option value="1">大数据</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">Email:</label>
            <div class="layui-input-block">
                <input type="text" name="clueEmail" lay-verify="clueEmail" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">线索名称:</label>
            <div class="layui-input-block">
                <input type="text" name="clueName" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建时间:</label>
            <div class="layui-input-inline">
                <input type="text" id="clueNectDate" class="layui-input" name="createTime"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号:</label>
            <div class="layui-input-block">
                <input type="text" name="cluePhone" lay-verify="cluePhone" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <input type="text" name="clueRemark" lay-verify="clueRemark" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">来源:</label>
            <div class="layui-input-block" style="width: 222px" >
                <select name="clueSource"  lay-filter="clueSource">
                    <option value="0">来源1</option>
                    <option value="1">来源2</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">链接</label>
            <div class="layui-input-block">
                <input type="text" name="clueUrl" lay-verify="clueUrl" autocomplete="off" placeholder="请输入标题" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="margin-right: 60px;margin-top: 40px;">
            <div class="layui-input-block" style="text-align: center;">
                <button style="width: 100px;margin-right: 20px;" class="layui-btn" lay-submit lay-filter="submitForm">提交
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
                    url:"http://121.41.230.121:6001/crm/client-manage/clue/register",
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
        });

    })

</script>
</body>
<script>
    var i = 0;
    console.info(i++)
</script>
</html>