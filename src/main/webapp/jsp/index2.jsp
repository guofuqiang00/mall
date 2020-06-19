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
<body>

<div class="productTable">
    <div style="height: 50px"></div>

    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">请选择：</label>
            <div class="layui-input-block" style="width: 220px;">
                <select id="meta"  name="meta"   lay-filter="meta">
                    <option value="1">01</option>
                    <option value="2">02</option>
                    <option value="3">03</option>
                </select>
            </div>
        </div>


        <div id="versionId" class="layui-form-item" style="display: none;">
            <label class="layui-form-label">版本:</label>
            <div class="layui-input-block" style="width: 220px;">
                <select id="version"   name="version"  lay-filter="version">
                </select>
            </div>
        </div>


    </form>

</div>

<table class="layui-hide" id="LAY_table_product" lay-filter="product">

</table>
<script src="${basePath}/dist/layui/layui.js" charset="utf-8"></script>
<script>
    $(document).ready(function () {
        layui.use(['layer', 'form', 'table' ,'laydate'], function () {
            var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                table = layui.table;

            form.on("select(meta)", function(data){

                var value = data.value;
                if(value==2){
                    //去重
                    $("#versionId").find("option").remove();
                    document.getElementById("versionId").style.display="inline";
                    $("#version").append("<option value=\""+(0)+"\">"+'Android'+"</option>");
                    $("#version").append("<option value=\""+(1)+"\">"+'IOS'+"</option>");
                    form.render('select');
                }else{
                    document.getElementById("versionId").style.display="none";
                    $("#versionId").find("option").remove();
                }
            });
        });

    })

</script>
</body>
<script>
   var i = 0;
console.info(i++)
</script>
</html>