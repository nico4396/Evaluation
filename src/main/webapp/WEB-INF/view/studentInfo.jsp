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
    <title>学员信息</title>
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
        <div class="layui-logo">学员信息</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                欢迎：<%=session.getAttribute("uname")%>
            </li>
            <li class="layui-nav-item"><a href="logout.jsp">退出</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="/stuList">学员列表</a></li>
                <%--<li class="layui-nav-item"><a href="#">主题管理</a></li>--%>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <div class="layui-collapse" lay-accordion>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">学员详细信息</h2>
                <div class="layui-colla-content layui-show" align="center">
                    <table class="layui-table" style="width: 1000px;height: 200px">
                        <tr>
                            <td width="80px">姓名</td>
                            <td><input type="text" name="sname" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="sname" style="border: hidden" readonly value="${sessionScope.student.sname}"></td>
                            <td width="80px">性别</td>
                            <td><input type="text" name="sex" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="sex" style="border: hidden" readonly value="${sessionScope.student.sex}"></td>
                            <td width="80px">民族</td>
                            <td><input type="text" name="nation" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="nation" style="border: hidden" readonly value="${sessionScope.student.nation}"></td>
                            <td rowspan="4" width="100px" align="center"></td>
                        </tr>
                        <tr>
                            <td>出生年月</td>
                            <td><input type="text" name="birthday" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="birthday" style="border: hidden" readonly value="${sessionScope.student.birthday}"></td>
                            <td>籍贯</td>
                            <td><input type="text" name="place" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="place" style="border: hidden" readonly value="${sessionScope.student.place}"></td>
                            <td>婚否</td>
                            <td><input type="text" name="marry" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="marry" style="border: hidden" readonly value="${sessionScope.student.marry}"></td>
                        </tr>
                        <tr>
                            <td>联系电话</td>
                            <td colspan="2"><input type="text" name="phone" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="phone" style="border: hidden" readonly value="${sessionScope.student.tel}"></td>
                            <td>身份证号码</td>
                            <td colspan="2"><input type="text" name="idcard" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="idcard" style="border: hidden" readonly value="${sessionScope.student.idCard}"></td>
                        </tr>
                        <tr>
                            <td>毕业学校</td>
                            <td colspan="2"><input type="text" name="school" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="school" style="border: hidden" readonly value="${sessionScope.student.school}"></td>
                            <td>专业</td>
                            <td colspan="2"><input type="text" name="major" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="major" style="border: hidden" readonly value="${sessionScope.student.major}"></td>
                        </tr>
                        <tr>
                            <td>备注</td>
                            <td colspan="6"><input type="text" name="notes" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="notes" style="border: hidden" readonly value="${sessionScope.student.notes}"></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">培训学校评价</h2>
                <div class="layui-colla-content">
                    <table class="layui-table" lay-data="{url:'GetAllSchoolEva', id:'test3'}" lay-filter="test3">
                        <thead>
                        <tr>
                            <th lay-data="{field:'id', width:80}">班期</th>
                            <th lay-data="{field:'username', width:100, edit: 'text'}">评价人</th>
                            <th lay-data="{field:'username', width:220, edit: 'text'}">培训期间测试成绩</th>
                            <th lay-data="{field:'sex', width:200, edit: 'text'}">整体评价分数</th>
                            <th lay-data="{field:'city', Width: 300, edit: 'text'}">评价（包括主要优点及缺陷）</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">鲁迅</h2>
                <div class="layui-colla-content">内容区域</div>
            </div>
        </div>
        <%--<table id="demo" lay-filter="test"></table>--%>


    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script>
    layui.use(['table','element'], function(){
        var element = layui.element;
        var table = layui.table;

        //监听单元格编辑
        table.on('edit(test3)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });
    });
</script>
</body>
</html>
