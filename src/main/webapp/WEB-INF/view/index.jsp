<%--
  Created by IntelliJ IDEA.
  User: Lancer
  Date: 2020/8/27
  Time: 下午 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link href="layui/css/layui.css" rel="stylesheet">
    <script src="layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><h2>静读天下新闻</h2></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="login.jsp">登录</a></li>
            <li class="layui-nav-item"><a href="Register.jsp">注册</a></li>
        </ul>
    </div>
    <div class="layui-body" style="left: 0">
        <div align="center">
            <div style="margin: 60px 0px 0px 0px"></div>
            <table id="demo" lay-filter="test"></table>
            要查看详细内容，请<a href="login.jsp" style="color: dodgerblue">登录</a>
        </div>
    </div>

    <div class="layui-footer" style="left: 0">
        <label style="margin-left: 520px">© 不忘初心，牢记使命，认真贯彻践行社会主义核心价值观。富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善。</label>
    </div>
</div>
<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        //第一个实例
        table.render({
            elem: '#demo'
            /*, toolbar: '#toolbarDemo'*/
            , height: 760
            , width: 1456
            , url: '/GetNewsServlet' //数据接口
            , page: true //开启分页
            , limit: 15//每页显示几条数据
            , limits: [10, 15, 20]
            , cols: [[ //表头
                /*{type: 'checkbox'}
                ,*/ {field: 'newid', title: 'newid', hide: true}
                , {field: 'topic', title: '主题', width: 100, sort: true}
                , {field: 'author', title: '作者', width: 150}
                , {field: 'title', title: '标题', width: 500}
                , {field: 'summary', title: '摘要', width: 700}
                /*, {field: 'content', title: '内容', width: 400}*/
                /*, {fixed: 'right', title: '', width: 100, align: 'center', toolbar: '#barDemo'}*/
            ]]
        });
    });
</script>
</body>
</html>