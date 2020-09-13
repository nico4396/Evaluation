<%--
  Created by IntelliJ IDEA.
  User: Lancer
  Date: 2020/8/23
  Time: 上午 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link href="../../static/layui/css/layui.css" rel="stylesheet">
    <script src="../../static/layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><h2>金桥工程学员跟踪</h2></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="login.jsp">登录</a></li>
            <%--<li class="layui-nav-item"><a href="Register.jsp">注册</a></li>--%>
            <li class="layui-nav-item"><a href="SignOut.jsp">退出</a></li>
        </ul>
    </div>
    <div class="layui-body" style="left: 0">
        <div style="display: flex;justify-content: center">
            <form class="layui-form" action="LoginServlet" method="post">
                <div class="layui-form-item">
                    <h1 align="center" style="margin: 40px 0px 20px 0px">登录</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="uname" required lay-verify="required" placeholder="请输入用户名"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                        <input type="password" name="pwd" required lay-verify="required" placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                        <%--<button class="layui-btn layui-btn-normal" type="button" class="layui-btn layui-btn-primary" onclick="location.href='Register.jsp'">注册</button>--%>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <%--<div class="layui-footer" style="left: 0">
        <label style="margin-left: 520px">© 不忘初心，牢记使命，认真贯彻践行社会主义核心价值观。富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善。</label>
    </div>--%>
</div>
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;
    });
</script>
</body>
</html>