<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 2020/9/14
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加科目</title>
</head>
<style>
    .layui-table-tool-self{
        display: none;
    }
    .layui-icon-ok{
        margin-top: 6px;
    }
</style>
<link href="../../../../static/layui/css/layui.css" rel="stylesheet">
<script src="../../../../static/layui/layui.js"></script>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">欢迎来到学员跟踪管理界面</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <div style="margin-right: 20px" align="right"><span>当前用户：</span><span style="color: #ffffff">${sessionScope.uname}</span></div>
                <dl class="layui-nav-child">
                    <dd><a href="repwd">修改密码</a></dd>
                    <dd><a href="login">退出账户</a></dd>
                </dl>
            </li>
        </ul>

    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item"><a href="mindex">首页</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">基本信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="userlogin">用户登录管理</a></dd>
                        <dd><a href="courseList">学科管理</a></dd>
                        <dd><a href="workTypeList">评价项管理</a></dd>
                        <dd><a href="classList">班级管理</a></dd>
                        <dd><a href="teacherList">教师管理</a></dd>
                        <dd><a href="jobList">部门管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="selectCourseList">班级选课管理</a></li>
                <li class="layui-nav-item"><a href="studentList">学生基本信息管理</a></li>
            </ul>
        </div>
    </div>

    <div style="display: flex;justify-content: center">
        <div class="layui-form">
            <h1 align="center" style="margin: 30px 0px 20px 0px">部门职位添加</h1>
            <div class="layui-form-item">
                <label class="layui-form-label">职位名</label>
                <div class="layui-input-inline">
                    <input id="jname" type="text" name="jname" required  lay-verify="required" placeholder="请输入职位名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">部门名</label>
                <div class="layui-input-inline">
                    <input id="deptName" type="text" name="deptName" required  lay-verify="required" placeholder="请输入部门名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit" id="addJobbtn">立即提交</button>
                    <button class="layui-btn layui-btn-sm layui-btn-warm" lay-event="back" onclick="window.history.back()">返回</button>
                </div>
            </div>
        </div>
    </div>
    <div align="center">
        <c:if test="${not empty requestScope.addMsg}">
            ${requestScope.addMsg}
        </c:if>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    layui.use(['element','laydate','layer','form'], function(){
        var element = layui.element;
        var laydate = layui.laydate;
        $ = layui.jquery;
        layer = layui.layer;
        var form = layui.form;        //点击提交按钮
        $("#addJobbtn").click(function () {
            if (($("#jname").val()==null || $("#jname").val()=="") || ($("#deptName").val()==null ||$("#deptName").val()=="")){
                layer.msg("信息不能为空");
            }else {
                $.ajax({
                    url:"addJobs",
                    type:"post",
                    data:{
                        jname:$("#jname").val(),
                        deptName:$("#deptName").val(),
                    },
                    dataType:"text",//默认值为text
                    success:function (data) {

                        layer.msg(data);
                        setTimeout('closeadd()',1000)
                    },
                    error:function (data) {
                        layer.msg("执行失败")
                    }
                })
            }

        });

        //执行一个laydate实例
        laydate.render({
            elem: '#time' //指定元素
        });
    });

    var closeadd = function () {
        parent.location.reload();//刷新父页面
    }
</script>
</body>
</html>
