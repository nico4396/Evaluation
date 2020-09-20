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
    <title>选课界面</title>
</head>
<style>
    .layui-table-tool-self{
        display: none;
    }
    .layui-icon-ok{
        margin-top: 6px;
    }
    #classname{
        font-size: 20px;
    }
    #a1{
        font-size: 20px;
        color: #FFB800;
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
        <form class="layui-form" lay-filter="layui-form" action="" style="margin: 1.5rem 3rem">
            <input type="hidden" name="id" id="id" value="${entity.id }">
            <input type="hidden" id="ids1" value="${ids1 }">
            <input type="hidden" id="ids2" value="${ids2 }">

            <div class="layui-fluid" style="margin-top: 15px;">
                <div class="layui-row layui-col-space10">
                    <div class="layui-col-md5">
                        <table class="layui-hide" id="left_tab" lay-filter="left"></table>
                    </div>
                    <div class="layui-col-md2 btn-height">
                        <div style="margin-bottom: 10px;">
                            <button class="layui-btn  layui-btn-disabled left-btn" type="button">
                                <i class="layui-icon">&#xe602;</i>
                            </button>
                        </div>
                        <div >
                            <button class="layui-btn layui-btn-disabled right-btn" type="button">
                                <i class="layui-icon">&#xe603;</i>
                            </button>
                        </div>
                    </div>
                    <div class="layui-col-md5">
                        <table class="layui-hide" id="right_tab" lay-filter="right"></table>
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button id="addCoursebtn" type="button" class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
                    <a href="selectCourseList" id="a1">返回选课界面</a>
                </div>
            </div>
        </form>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    layui.use(['table','transfer', 'layer', 'form'], function(){
        var table = layui.table,
            $ = layui.$;
        var height = 490; //固定表格高度
        var form = layui.form;
        //计算按钮的高度
        var btn_height = height /2 -44;
        $('.btn-height').css('padding-top',btn_height).css('text-align','center');

        //左边表格
        table.render({
            elem: '#left_tab'
            ,url: 'getAllCourse'
            ,page: true //分页
            ,limit:5//每页显示几条数据
            ,limits:[5,10,15,20]
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{field:'couid', title: '编号', width:80, sort: true, fixed: true}
                ,{field:'couname', title: '科目名'}

            ]]
            ,height: height
        });
        //右边表格
        table.render({
            elem: '#right_tab'
            ,url: 'getAllClass'
            ,page: true //分页
            ,limit:5//每页显示几条数据
            ,limits:[5,10,15,20]
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{type:"numbers",title:'序号',width:80,sort: true, fixed: true}
                ,{field:'classid', title: '编号', width:80, sort: true, fixed: true,hide:true}
                ,{field:'classname', title: '班级名'}
            ]]
            ,height: height
        });
            $("#addCoursebtn").click(function () {
                var checkStatus = table.checkStatus('left_tab');
                var date=checkStatus.data;
                //var list=$("#left_tab:checkbox:checked").val();
                //获取选中行
                var checkStatus1 = table.checkStatus('right_tab');
                //获取选中行的数据
                var date1 = checkStatus1.data;
                if (date1.length < 1){
                    layer.msg("请选择一个班级选课")
                }else if(date1.length > 1){
                    layer.msg("只能选择一个班级")
                }else {
                    var lists="";
                    for (var i = 0 ;i < date.length; i++){
                        lists+=date[i].couname+",";
                    }
                    lists = lists.substring(0,lists.length-1);
                    var classid = date1[0].classid;
                    //console.log(list);
                    $.ajax({
                        url: "addByBatchClass",
                        type: "post",
                        data: {
                            classid: classid,
                            //list:JSON.stringify(list)
                            lists:lists
                        },
                        dataType: "text",//默认值为text
                        success: function (data) {
                            layer.msg(data);
                            setTimeout('closeadd()', 1000)
                        },
                        error: function (data) {
                            layer.msg("执行失败")
                        }
                    })
                }
            })
    });
</script>
</body>
</html>
