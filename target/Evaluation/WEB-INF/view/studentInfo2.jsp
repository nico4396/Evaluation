<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lancer
  Date: 2020/8/26
  Time: 下午 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>经理评价</title>
    <link href="../../static/layui/css/layui.css" rel="stylesheet">
    <script src="../../static/layui/layui.js"></script>
    <style>
        .layui-table-tool-self {
            display: none;
        }

        .layui-icon-ok {
            margin-top: 6px; /*上边距*/
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">金桥学员成长跟踪</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                欢迎：<%=session.getAttribute("uname")%>
            </li>
            <li class="layui-nav-item"><a href="logout">退出</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="#">新闻管理</a></li>
                <li class="layui-nav-item"><a href="#">主题管理</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <div class="layui-collapse" <%--lay-accordion--%>>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">转正工作评价</h2>
                <div class="layui-colla-content <%--layui-show--%>" align="center">
                    <table class="layui-table" lay-data="{url:'/test/table/demo1.json', id:'test3'}" lay-filter="test3">
                        <thead>
                        <tr>
                            <th lay-data="{field:'id', width:100}">员工部门</th>
                            <th lay-data="{field:'id', width:100}">员工职务</th>
                            <th lay-data="{field:'username', width:100, edit: 'text'}">评价人</th>
                            <th lay-data="{field:'username', width:220, edit: 'text'}">评价分项</th>
                            <th lay-data="{field:'sex', width:150, edit: 'text'}">整体评价分数</th>
                            <th lay-data="{field:'city', Width: 300, edit: 'text'}">评价（包括主要优点及缺陷）</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                        <tfoot>
                            <th lay-data="{field:'city', Width: 100%, edit: 'text'}">评价（包括主要优点及缺陷）</th>
                        </tfoot>
                    </table>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">工作1年工作评价</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" lay-data="{url:'/test/table/demo1.json', id:'test3'}" lay-filter="test3">
                        <thead>
                        <tr>
                            <th lay-data="{field:'id', width:100}">员工部门</th>
                            <th lay-data="{field:'id', width:100}">员工职务</th>
                            <th lay-data="{field:'username', width:100, edit: 'text'}">评价人</th>
                            <th lay-data="{field:'username', width:220, edit: 'text'}">评价分项</th>
                            <th lay-data="{field:'sex', width:150, edit: 'text'}">整体评价分数</th>
                            <th lay-data="{field:'city', Width: 300, edit: 'text'}">评价（包括主要优点及缺陷）</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">工作2年工作评价</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" lay-data="{url:'/test/table/demo1.json', id:'test3'}" lay-filter="test3">
                        <thead>
                        <tr>
                            <th lay-data="{field:'id', width:100}">员工部门</th>
                            <th lay-data="{field:'id', width:100}">员工职务</th>
                            <th lay-data="{field:'username', width:100, edit: 'text'}">评价人</th>
                            <th lay-data="{field:'username', width:220, edit: 'text'}">评价分项</th>
                            <th lay-data="{field:'sex', width:150, edit: 'text'}">整体评价分数</th>
                            <th lay-data="{field:'city', Width: 300, edit: 'text'}">评价（包括主要优点及缺陷）</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">工作3年工作评价</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" lay-data="{url:'/test/table/demo1.json', id:'test3'}" lay-filter="test3">
                        <thead>
                        <tr>
                            <th lay-data="{field:'id', width:100}">员工部门</th>
                            <th lay-data="{field:'id', width:100}">员工职务</th>
                            <th lay-data="{field:'username', width:100, edit: 'text'}">评价人</th>
                            <th lay-data="{field:'username', width:220, edit: 'text'}">评价分项</th>
                            <th lay-data="{field:'sex', width:150, edit: 'text'}">整体评价分数</th>
                            <th lay-data="{field:'city', Width: 300, edit: 'text'}">评价（包括主要优点及缺陷）</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
        <%--<table id="demo" lay-filter="test"></table>--%>


    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //监听单元格编辑
        table.on('edit(test3)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });
    });
    layui.use('element', function () {
        var element = layui.element;
    });
</script>
</body>
</html>
