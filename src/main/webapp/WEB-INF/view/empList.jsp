<%--
  Created by IntelliJ IDEA.
  User: rujia
  Date: 2020/9/14
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理界面</title>
    <link href="../../static/layui/css/layui.css" rel="stylesheet">
    <script src="../../static/layui/layui.js"></script>
    <style>
        .layui-table-tool-self {
            display: none;
        }
        .layui-table-tool-self {
            display: none;
        }
        .layui-icon-ok{
            margin-top: 6px;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">员工列表</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <%=session.getAttribute("uname")%>
                </a>
            </li>
            <li class="layui-nav-item"><a href="logout">退出</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="#">管理新闻</a></li>
                <li class="layui-nav-item"><a href="#">管理主题</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body" style="background-color: #FFFFFF">
        <!-- 内容主体区域 -->
        <div align="center">
            <h1 style="margin: 30px 0px 20px 0px">员工列表</h1>
            <table id="demo" lay-filter="test"></table>
            <c:if test="${not empty requestScope.delMsg}">
                <p>${requestScope.delMsg}</p>
            </c:if>
        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script type="text/html" id="toolbarDemo">
    <div align="right">
        <div class="layui-input-inline">
            <input id="filter" type="text" placeholder="请输入员工名字" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input id="filter1" type="text" placeholder="请输入职务编号" class="layui-input">
        </div>
        <div class="layui-input-inline">
            <button class="layui-btn layui-btn-warm layui-btn-sm" lay-event="query">查询</button>
            <button class="layui-btn layui-btn-warm layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-warm layui-btn-sm" lay-event="delete">删除</button>
            <button class="layui-btn layui-btn-warm layui-btn-sm" lay-event="update">编辑</button>
        </div>
    </div>
    <div class="layui-form-item" style="width: 200px">
        <label class="layui-form-label">班期：</label>
        <div class="layui-input-block">
            <select id="classname" name="classname">
                <c:forEach var="classes" items="${requestScope.list}">
                    <option value="${classes.classname}"><c:out value="${classes.classname}"/></option>
                </c:forEach>
            </select>
        </div>
    </div>
</script>
<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        //第一个实例
        table.render({
            elem: '#demo'
            , toolbar: '#toolbarDemo'//添加工具栏
            , height: 500
            , width: 1100
            , url: 'getAllStudent' //数据接口
            , page: true //开启分页
            ,limit:5//每页显示几条数据
            ,limits:[5,10,15,20]
            , parseData: function (data) {
                console.log(data);
                return {
                    'code': 0,
                    'mag': '',
                    'count': 1000,
                    data: data
                }
            }
            , cols: [[ //表头
                {type: 'checkbox'}
                , {field: 'sid', title: '员工编号', width: 150, sort: true ,hide:true}
                ,{type:'numbers',title:'序号',width:50,align:"center"}
                , {field: 'sname', title: '姓名', width: 100,align:"center"/*,templet:"#usernameTpl"*/}
                , {field: 'sex', title: '性别', width: 50,align:"center"}
                , {field: 'school', title: '学校', width: 100,align:"center"}
                , {field: 'place', title: '籍贯', width: 100,align:"center"}
                , {field: 'score', title: '转正评价', width: 100,align:"center"}
                , {field: 'score_One', title: '一年评价', width: 100,align:"center"}
                , {field: 'score_Two', title: '两年评价', width: 100,align:"center"}
                , {field: 'score_Three', title: '三年评价', width: 100,align:"center"}
                /*, {field: 'place', title: '籍贯', width: 150}
                , {field: 'content', title: '内容', width: 302}*/
                , {field: '', title: '操作', toolbar: "#bar", width:240,align:"center"}
            ]]
        });
        //监听事件，监听lay-filter为test的元素的工具栏
        table.on('toolbar(test)', function (obj) {
            //var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'query':
                    var filter = $("#filter").val();
                    var filter1 = $("#filter1").val();
                    table.reload("demo",{//demo对应的是table的id
                        where:{sname:filter,jid:filter1},//where对应的是过滤条件
                        page:{
                            curr:1
                        }
                    });
                    break;
                case 'view':
                    location.href="login";
                    break;
                case 'add':
                    //location.href = "addEmp.jsp";
                    layer.open({
                        type:2,//弹出完整jsp，   type=1弹出完整div
                        title:'主题新增',
                        content:'GetTitleToAddServlet',
                        shadeClose:true,//点击遮罩，关闭弹窗
                        area:['580px','560px']
                    })
                    break;
                case 'delete':
                    //获取选择行
                    var checkStatus = table.checkStatus('demo'); //demo 为表格的 id
                    //获取选择行的数据
                    var date = checkStatus.data;
                    if (date.length < 1) {
                        layer.msg("请选择要删除的数据");
                    } else {
                        layer.confirm('确定要删除吗？','删除新闻',function () {
                            var newsIds = "";
                            for (var i = 0; i < date.length; i++) {
                                newsIds += date[i].newsId + ",";
                            }
                            newsIds = newsIds.substring(0, newsIds.length - 1);
                            $.ajax({
                                url:"DeleteNewsServlet",
                                type:"post",
                                data:{
                                    newsIds:newsIds
                                },
                                success:function (data) {
                                    if(data){
                                        layer.msg('删除成功');
                                    } else {
                                        layer.msg('删除失败');
                                    }
                                    //重新加载表格
                                    table.reload("demo",function () {
                                        url:"GetAllNewsServlet"
                                    })
                                },
                                error:function () {
                                    layer.msg('执行失败')
                                }
                            })
                        })
                    }
                    break;
                case 'update':
                    //获取选择行
                    var checkStatus = table.checkStatus('demo'); //demo 为表格的 id
                    //获取选择行的数据
                    var date = checkStatus.data;
                    if(date.length<1){
                        layer.msg("请选择一条要编辑的数据");
                    } else if(date.length>1){
                        layer.msg("只能选择一条数据进行编辑");
                    } else {
                        //获取要编辑的员工编号
                        var newsId = date[0].newsId;
                        //根据员工编号获取员工信息
                        //location.href="GetEmpByEmpnoServlet?empno="+empno;
                        layer.open({
                            type:2,//弹出完整jsp，   type=1弹出完整div
                            title:'编辑',
                            content:'GetTitleToEditNewsServlet?newsId='+newsId,
                            shadeClose:true,//点击遮罩，关闭弹窗
                            area:['680px','660px'],
                            end:function () {
                                //刷新当前页
                                $(".layui-laypage-btn").click();
                            }
                        })
                    }
                    break;
            };
        });
        table.on('tool(test)',function (obj) {
            var data = obj.data; //获得当前行数据
            var sid = data.sid;
            var layEvent = obj.event;
            if(layEvent == 'detail'){
                location.href="GetToReadServlet?sid="+sid;
            }else if(layEvent == 'eva'){
                location.href = "turnWork?sid="+sid;
            }
        });
    });
</script>

<%--<script type="text/html" id="usernameTpl">
    <a href="studentInfo2&lt;%&ndash;/?table-demo-id={{d.sid}}&ndash;%&gt;" class="layui-table-link" target="_self">{{ d.uname }}</a>
</script>--%>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
<script type="text/html" id="bar">
    <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="detail">查看</button>
    <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="eva">转正评价</button>
</script>
</body>
</html>
