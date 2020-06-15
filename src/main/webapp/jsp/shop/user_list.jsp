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
<body>
<form class="layui-form">
    <div class="layui-inline">
        <label class="layui-form-label">用户姓名:</label>
        <div class="layui-input-inline">
            <input type="text" id="username" class="layui-input"/>
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">创建时间:</label>
        <div class="layui-input-inline">
            <input type="text" id="createTime" class="layui-input" name="createTime"/>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <button class="layui-btn layui-btn-fluid">搜索</button>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <button style="width: 80px" type="button" class="layui-btn lay-submit" id="addBtn">添加</button>
        </div>
    </div>
</form>
<table class="layui-hide" id="jobList" lay-filter="jobList"></table>
</body>
<script type="text/html" id="rank">    {{d.LAY_TABLE_INDEX+1}}</script>
<script>

    $(document).ready(function () {
        layui.use(['layer', 'form', 'table', 'laydate'], function () {

            var layer = layui.layer,
                form = layui.form,
                table = layui.table,
                $ = layui.jquery,
                t;

            laydate = layui.laydate;
            laydate.render({
                elem: "#createTime",
                type: 'datetime',
                min: new Date().getTime()
            })
            table.render({
                elem: '#jobList'
                , url: ctx+'/user/selectUser'
                , method: 'get'
                , id: 'jobList'
                , title: ''
                , cols: [[
                    {field: '', align: 'center', title: '序号', width: '5%', templet: "#rank"}
                    , {field: 'username', title: '发布时间', width: '12%'}
                    , {field: 'password', title: '密码', width: '12%'}
                    , {field: 'createTime', title: '开始时间', width: '12%'}
                    , {
                        field: 'status', title: '操作', width: '12%', templet:
                            function (data) {
                                var edit = '<button type="button" class="layui-btn layui-btn-normal layui-btn-sm" onclick="edit(' + data.id + ')">编辑</button>';
                                // var del  ='<button type="button" cpActivityId="+d.cpActivityId+" class="layui-btn layui-btn-danger layui-btn-sm" onclick="del(this)">删除</button>';
                                // var del ='<button type="button" class="layui-btn layui-btn-danger  layui-btn-sm del" onclick="del('+d.id+')">删除</button>';
                                var del = '<button type="button" class="layui-btn layui-btn-danger  layui-btn-sm del" onclick="del(' + data.id + ')">删除</button>';
                                return edit + del;
                            }
                    }
                ]]
                , page: true

            });




        })


    })
    $("#addBtn").click(function () {
        layer.open({
            skin: 'layui-form',
            type: 2,
            title: '添加',
            area: ['500px', '650px;'],
            offset: '0px',
            background: 'rgba(215, 215, 215, 1);',
            content: ['user_add.jsp', 'yes']
        });
    });






</script>

</html>
