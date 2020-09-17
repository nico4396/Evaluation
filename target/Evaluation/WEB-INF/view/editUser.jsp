<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: luoxue
  Date: 2020/9/5
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
    <script src="../../static/layui/layui.js"></script>
</head>
<body>
<div style="display: flex;justify-content: center">
    <div method="get" class="layui-form">
        <!--主题内容-->
        <h3 align="center">编辑权限</h3>
        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">编号：</label>
            <div class="layui-input-block">
                <input type="text" name="uid" id="uid" lay-verify="title" readonly autocomplete="off" placeholder="请输入编号"
                       class="layui-input" value="${sessionScope.userlogin.uid}" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input type="text" name="uname" id="uname" lay-verify="title" readonly autocomplete="off" placeholder="请输入姓名"
                       class="layui-input" value="${sessionScope.userlogin.uname}">
            </div>
        </div>
        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-block">
                <input type="password" name="pwd" id="pwd" lay-verify="title"  autocomplete="off" placeholder="请输入密码"
                       class="layui-input" value="${sessionScope.userlogin.pwd}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限</label>
            <div class="layui-input-block">
                <c:if test="${sessionScope.userlogin.power=='管理员'}">
                    <input type="radio" name="power" value="管理员" title="管理员" checked="">
                    <input type="radio" name="power" value="教师" title="教师">
                    <input type="radio" name="power" value="项目经理" title="项目经理">
                </c:if>
                <c:if test="${sessionScope.userlogin.power=='教师'}">
                    <input type="radio" name="power" value="管理员" title="管理员">
                    <input type="radio" name="power" value="教师" title="教师" checked="">
                    <input type="radio" name="power" value="项目经理" title="项目经理">
                </c:if>
                <c:if test="${sessionScope.userlogin.power=='项目经理'}">
                    <input type="radio" name="power" value="管理员" title="管理员">
                    <input type="radio" name="power" value="教师" title="教师">
                    <input type="radio" name="power" value="项目经理" title="项目经理" checked="">
                </c:if>
            </div>
        </div>
        <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" id="update" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
        <div class="layui-footer">
        </div>
    </div>
</div>
</div>
<script>
    layui.use(['element', 'form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , element = layui.element
            , $ = layui.jquery;

        $("#update").click(function () {
            $.ajax({
                url: "editUserLogin",
                type: "post",
                data: {
                    uid:$("#uid").val(),
                    uname: $("#uname").val(),
                    pwd: $("#pwd").val(),
                    power: $("[name=power]:checked").val(),

                },
                dataType: "text",
                success: function (data) {
                    layer.msg(data);
                    //重新加载表格
                    setTimeout('close()', 1000)
                },
                error: function (data) {
                    layer.msg("执行失败")
                }
            })
        })
    });
    var close = function () {
        var index = parent.layer.getFrameIndex(window.name);//获取当前页索引
        parent.layer.close(index);
    }
</script>
</body>
</html>
