<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 2020/9/14
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师显示界面</title>
</head>
<style>
    .layui-table-tool-self{
        display: none;
    }
    .layui-icon-ok{
        margin-top: 6px;
    }
    #teaname{
        font-size: 20px;
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
                <li class="layui-nav-item"><a href="login">班级选课管理</a></li>
                <li class="layui-nav-item"><a href="studentList">学生基本信息管理</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="font-size: 50px">
        <div align="center">
            <h4 style="margin: 10px 0 20px 0">老师列表</h4>
            <table id="demo" lay-filter="test"></table>
            <c:if test="${not empty requestScope.delMsg}">
                <p>${requestScope.delMsg}</p>
            </c:if>
        </div>
        <script type="text/html" id="toolbarDemo">
            <div align="right">
                <div class="layui-input-inline">
                    <input type="text" id="teaname" name="teaname" placeholder="请输入用户名" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <button class="layui-btn layui-btn-sm" lay-event="query">查询</button>
                    <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
                </div>
            </div>

        </script>
        <script>
            layui.use(['table','layer'], function(){
                var table = layui.table;
                var layer = layui.layer;
                var $ = layui.jquery;

                table.render({
                    elem: '#demo'
                    ,toolbar: '#toolbarDemo'//添加工具栏
                    ,height: 500
                    ,width:1005
                    ,url: '/getAllTeacher' //数据接口
                    ,page: true //分页
                    ,limit:5//每页显示几条数据
                    ,limits:[5,10,15,20]
                    ,cols: [[ //表头
                        //{type:'checkbox'}
                        {type:"numbers",title:'序号',width:80}
                        ,{field: 'teaid', title: '编号', width:80, sort: true,hide:true}
                        ,{field: 'teaname', title: '教师名', width:700}
                        ,{field: '', title: '操作',toolbar: "#bar", width:217}
                    ]]
                });

                //监听事件是lay-filter为test的员工的工具栏
                table.on('toolbar(test)', function(obj){
                    switch(obj.event){
                        case 'query':
                            //获取查询条件
                            var filter = $("#teaname").val();
                            table.reload("demo",{//demo对应的是table的id
                                where:{teaname:filter},//where对应的是过滤条件
                                page:{
                                    curr:1
                                }
                            });
                            break;
                        case 'add':
                            location.href="addTeacher";
                            /*  layer.open({
                                  type:2,//弹出完整jsp，弹出隐藏div
                                  title:'添加学生',
                                  url:'addStudent',
                                  shadeClose:true,//点击遮罩，关闭弹窗
                                  area:['480px','660px']
                              });*/
                            break;
                    };
                });

                table.on('tool(test)',function (obj) {
                    var data = obj.data; //获得当前行数据
                    var teaid = data.teaid;
                    var layEvent = obj.event;
                    if(layEvent == 'delete'){
                        //获取选中行
                        var checkStatus = table.checkStatus('demo'); //demo为table的id 即为基础参数 id 对应的值;
                        //获取选中行的数据
                        var date = checkStatus.data;
                            layer.confirm('确定要删除吗？','删除命令',function () {
                                $.ajax({
                                    url:"deleteTeacherByid",
                                    type:"post",
                                    data:{
                                        teaid:teaid
                                    },
                                    success:function (data) {
                                        if (data){
                                            layer.msg("删除成功")
                                        }else {
                                            layer.msg("删除失败")
                                        }
                                        //重新加载表格
                                        table.reload("demo",function () {
                                            url:"getAllTeacher"
                                        })
                                    },
                                    error:function (data) {
                                        layer.msg("执行失败")
                                    }
                                })
                            })

                    }else if (layEvent == 'edit'){
                        //获取选中行
                        var checkStatus = table.checkStatus('demo'); //demo为table的id 即为基础参数 id 对应的值;
                        //获取选中行的数据
                        var date = checkStatus.data;
                        /*if (date.length < 1){
                            layer.msg("请选择一条要编辑的数据")
                        }else if(date.length > 1){
                            layer.msg("只能选择一条编辑的数据")
                        }else {*/
                            //获取要编辑的编号
                            //var couid = date[0].couid;
                            $.ajax({
                                url: "getByTeaid",
                                type: "post",
                                data: {
                                   teaid: teaid
                                },
                                success: function (data) {
                                    layer.open({
                                        type: 2,//弹出完整jsp，如果是1代表弹出隐藏div
                                        title: '修改信息',
                                        shadeClose: true,
                                        content: 'editTeacher',
                                        area: ['480px', '500px'],
                                        end: function () {
                                            $(".layui-laypage-btn").click();
                                        }
                                    });
                                },
                                error: function (data) {
                                    alert("执行失败")
                                }
                            })

                        }
                    //}
                });
            });
        </script>
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
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="edit" id="edit" name="edit">修改</a>
    <a class="layui-btn layui-bg-green layui-btn-xs" lay-event="delete" id="delete" name="delete">删除</a>
</script>
</body>
</html>
