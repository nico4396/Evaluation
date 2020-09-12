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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>金桥学员成长跟踪</title>
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
                当前用户：<%=session.getAttribute("uname")%>
            </li>
            <li class="layui-nav-item"><a href="SignOut.jsp">退出</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll" >
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="newsList.jsp">新闻管理</a></li>
                <li class="layui-nav-item"><a href="TopicList.jsp">主题管理</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <div align="center">
            <div style="margin: 60px 0px 0px 0px"></div>
            <table id="demo" lay-filter="test"></table>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        ©
    </div>
</div>
<script type="text/html" id="toolbarDemo">
    <div style="margin-left: 600px">
        <div class="layui-input-inline" style="width: 300px">
            <input type="text" placeholder="请输入标题关键字" class="layui-input" id="filter">
        </div>
        <div class="layui-input-inline" style="margin: 0 -312px 0 0">
            <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="query">查询</button>
            <button class="layui-btn  layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="delete">删除</button>
        </div>
    </div>
</script>
<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-sm" lay-event="edit">编辑</button>
    <button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</button>
</script>
<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        //第一个实例
        table.render({
            elem: '#demo'
            , toolbar: '#toolbarDemo'
            , height: 760
            , width: 1306
            , url: '/GetNewsServlet' //数据接口
            , page: true //开启分页
            , limit: 10//每页显示几条数据
            , limits: [10, 15, 20]
            , cols: [[ //表头
                {type: 'checkbox'}
                , {field: 'newid', title: 'newid', hide: true}
                , {field: 'topic', title: '主题', width: 100, sort: true}
                , {field: 'title', title: '标题', width: 200}
                , {field: 'author', title: '作者', width: 150}
                , {field: 'summary', title: '摘要', width: 250}
                , {field: 'content', title: '内容', width: 400}
                , {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barDemo'}
            ]]
        });
        table.on('toolbar(test)', function (obj) {
            switch (obj.event) {
                case 'query':
                    var filter = $("#filter").val();
                    table.reload("demo", {  //demo 对应tableid
                        where: {title: filter},
                        page: {
                            curr: 1
                        }
                    });
                    break;
                case 'add':
                    layer.open({
                        type: 2,//弹出完整jsp,type=1弹出隐藏div
                        title: '添加新闻',
                        content: 'GetAllTopicServlet',
                        area: ['700px', '700px'],
                        shadeClose: true
                    });
                    break;
                case 'delete':
                    var checkStatus = table.checkStatus('demo'); //demo为table的id
                    var data = checkStatus.data; //获取选中行的数据
                    if (data.length < 1) {
                        layer.msg("请选择要删除的数据");
                    } else {
                        layer.confirm("确定要删除吗？", function () {
                            var newids = "";
                            for (var i = 0; i < data.length; i++) {
                                newids += data[i].newid + ",";
                            }
                            newids = newids.substring(0, newids.length - 1);
                            $.ajax({
                                url: "DeleteNewsByIdServlet",
                                type: "post",
                                data: {
                                    newids: newids
                                },
                                success: function (data) {
                                    if (data) {
                                        layer.msg("删除成功！")

                                    } else {
                                        layer.msg("删除失败！")
                                    }
                                    //重新加载表格
                                    table.reload("demo", function () {
                                        url:"GetNewsServlet"
                                    })
                                },
                                error: function () {
                                    layer.msg("执行失败！");
                                }
                            })
                        })
                    }
                    break;
            }
        });
        table.on('tool(test)', function (obj) {
            var data = obj.data; //获得当前行数据
            var newid = data.newid;
            var layEvent = obj.event;

            if (layEvent == 'edit') { //修改
                //location.href = "GetNewsByIdServlet?newid=" + newid;
                layer.open({
                    type: 2,//弹出完整jsp,type=1弹出隐藏div
                    title: '编辑新闻',
                    content: 'GetNewsByIdServlet?newid=' + newid,
                    area: ['700px', '700px'],
                    shadeClose: true,
                    end: function () {
                        $(".layui-laypage-btn").click()
                    }
                });
            } else if (layEvent == 'del') { //删除
                layer.confirm('确定要删除？', function () {
                    //location.href = "DeleteNewsServlet?newid=" + newid;
                    $.ajax({
                        url: "DeleteNewsServlet",
                        type: "post",
                        data: {
                            newid: newid
                        },
                        success: function (data) {
                            if (data) {
                                layer.msg("删除成功！")

                            } else {
                                layer.msg("删除失败！")
                            }
                            //重新加载表格
                            table.reload("demo", function () {
                                url:"GetNewsServlet"
                            })
                        },
                        error: function () {
                            layer.msg("执行失败！")
                        }
                    })
                });
            }
        });
    });
</script>
</body>
</html>
