<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 2020/9/6
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<style>
    .layui-table-tool-self{
        display: none;
    }
    .layui-icon-ok{
        margin-top: 6px;
    }
    #di1{
        margin-top: 100px;
        color: red;
        font-size: 30px;
    }
</style>
<link href="../../../static/layui/css/layui.css" rel="stylesheet">
<script src="../../../static/layui/layui.js"></script>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">欢迎来到学员跟踪管理界面</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <div style="margin-right: 20px" align="right"><span>当前用户：</span><span style="color: #ffffff">${sessionScope.uname}</span></div>
                <dl class="layui-nav-child">
                    <dd><a href="repwd">修改密码</a></dd>
                    <dd><a href="logout">退出账户</a></dd>
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

    <div class="layui-body" style="font-size: 50px">
        <div><span>欢迎管理员</span><span style="color: #0000FF">${sessionScope.uname}</span><span>,使用学员跟踪管理系统</span></div>
    </div>
    <div class="layui-body" id="di1">
        <div><span>本系统的管理员功能使用是基于ssm实现的</span></div>
        <div><span>运用springMVC-spring-mybatis-ajax等技术进行编写</span></div>
        <div>
            <span>
                主要实现了：<br>
                &nbsp;&nbsp;&nbsp;&nbsp;登录用户的增删改查<br>
                &nbsp;&nbsp;&nbsp;&nbsp;学生学习课程的增删改查<br>
                &nbsp;&nbsp;&nbsp;&nbsp;学生入职职工位的增删改查<br>
                &nbsp;&nbsp;&nbsp;&nbsp;代课老师的增删改查<br>
                &nbsp;&nbsp;&nbsp;&nbsp;项目经理对学生评价时的评价项类型增删改查<br>
                &nbsp;&nbsp;&nbsp;&nbsp;学生基本信息的增删改查以及学生毕业的部门分配<br>
                &nbsp;&nbsp;&nbsp;&nbsp;班级的增删改查<br>
                &nbsp;&nbsp;&nbsp;&nbsp;对班级进行科目的选课的操作<br>
                &nbsp;&nbsp;&nbsp;&nbsp;修改密码<br>
            </span>
        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>
