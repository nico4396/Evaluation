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
                    <%--<input id="sid" value="${sessionScope.student.sid}" style="display: none">--%>
                    <table class="layui-table" style="width: 1000px;height: 200px">
                        <tr>
                            <td width="80px">姓名</td>
                            <td><input type="text" name="sname" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="sname" style="border: hidden" readonly
                                       value="${sessionScope.student.sname}"></td>
                            <td width="80px">性别</td>
                            <td><input type="text" name="sex" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="sex" style="border: hidden" readonly
                                       value="${sessionScope.student.sex}"></td>
                            <td width="80px">民族</td>
                            <td><input type="text" name="nation" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="nation" style="border: hidden" readonly
                                       value="${sessionScope.student.nation}"></td>
                            <td rowspan="4" width="100px" align="center">
                                <div id="imgDiv"><img src="../../files/${sessionScope.student.imgName}">照片</div>
                            </td>
                        </tr>
                        <tr>
                            <td>出生日期</td>
                            <td><input type="text" name="birthday" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="birthday" style="border: hidden" readonly
                                       value="${sessionScope.student.birthday}"></td>
                            <td>籍贯</td>
                            <td><input type="text" name="place" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="place" style="border: hidden" readonly
                                       value="${sessionScope.student.place}"></td>
                            <td>婚否</td>
                            <td><input type="text" name="marry" required lay-verify="required" autocomplete="off"
                                       class="layui-input" id="marry" style="border: hidden" readonly
                                       value="${sessionScope.student.marry}"></td>
                        </tr>
                        <tr>
                            <td>联系电话</td>
                            <td colspan="2"><input type="text" name="tel" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="tel" style="border: hidden" readonly
                                                   value="${sessionScope.student.tel}"></td>
                            <td>身份证号码</td>
                            <td colspan="2"><input type="text" name="idcard" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="idcard" style="border: hidden" readonly
                                                   value="${sessionScope.student.idCard}"></td>
                        </tr>
                        <tr>
                            <td>毕业学校</td>
                            <td colspan="2"><input type="text" name="school" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="school" style="border: hidden" readonly
                                                   value="${sessionScope.student.school}"></td>
                            <td>专业</td>
                            <td colspan="2"><input type="text" name="major" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="major" style="border: hidden" readonly
                                                   value="${sessionScope.student.major}"></td>
                        </tr>
                        <tr>
                            <td>备注</td>
                            <td colspan="6"><input type="text" name="notes" required lay-verify="required"
                                                   autocomplete="off"
                                                   class="layui-input" id="notes" style="border: hidden" readonly
                                                   value="${sessionScope.student.notes}"></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">培训学校评价</h2>
                <div class="layui-colla-content">
                    <table id="demo" lay-filter="test"></table>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">鲁迅</h2>
                <div class="layui-colla-content">内容区域</div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
    </div>
</div>
<script>
    layui.use(['table', 'layer','element'], function () {
        var element = layui.element;
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        /*var data = obj.data;*/
        /*$.ajax({
            url: "getImg",
            type: "post",
            data: {"sid":sid},
            cache: false,//是否缓存
            //contentType必须设定为false，
            //即告诉服务器从浏览器提交过来的数据采用默认的数据格式
            //contentType: false,
            //设定为false可避免jQuery对formData的默认处理
            processData: false,
            success: function (data) {
                var img = "<img src = '../../" + data + "'>";
                $("#imgDiv").html(img);
                //$("#imgDiv").val(data);
            },
            error: function (data) {
                layer.msg("执行失败")
            }
        });*/
        /*$.ajax({
            url: "getStuEva"
            , type: "GET"
            , dataType: "JSON"
            , success: function (data) {
                //处理数据，tableDate
                //生成动态列二维数组col
                table.render({
                    elem: '#demo'
                    , cols: [[ //表头
                        /!*{type: 'checkbox'}*!/
                        {field: 'sid', title: '学号', hide: true}
                        , {field: 'classname', title: '班期', width: 100}
                        , {field: 'teacher', title: '评价人', width: 200}
                        /!*, {field: 'author', title: '作者', width: 150}*!/
                        , {field: 'summary', title: '整体评价分数', width: 250}
                        , {field: 'content', title: '评价（包括主要优点及缺陷）', width: 400}
                        /!*, {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barDemo'}*!/
                    ]]
                });
            }, error: function (data) {
                layer.msg("报个错")
            }

        });*/
    });
</script>
</body>
</html>
