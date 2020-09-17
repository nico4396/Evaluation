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
        </ul>
    </div>
    <div class="layui-body" style="left: 0">
        <div style="display: flex;justify-content: center">
            <div class="layui-form" >
                <h1 align="center" style="margin: 30px 0px 20px 0px">登录界面</h1>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名:</label>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="uname" required lay-verify="required" autocomplete="off" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-inline">
                        <input type="password" id="pwd" name="pwd" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit" id="submitbtn">登录</button>
                        <button type="button" class="layui-btn layui-btn-primary" onclick="location.href='register.jsp'">注册</button>
                    </div>
                </div>
            </div>
            <div align="center">
                <c:if test="${not empty sessionScope.loginMsg}">
                    <p class="red">${sessionScope.loginMsg}</p>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script>
    //Demo
    layui.use(['table','layer','form'], function(){
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var $ = layui.jquery;
        form.verify({
            uname: function(value){
                if(value.length === 0){
                    return '用户名不能为空';
                }
            }
            ,pwd: function(value){
                if(value.length === 0){
                    return '密码不能为空';
                }
            }
        });
        $("#submitbtn").click(function () {
            $.ajax({
                url:"findUser",
                type:"get",
                data:{
                    uname:$("#uname").val(),
                    pwd:$("#pwd").val()
                },
                success:function (data) {
                    location.href=""+data+"";
                },
                error:function (data) {
                    alert("执行失败");
                }
            })
        })
        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
        });
    });
</script>
</body>
</html>