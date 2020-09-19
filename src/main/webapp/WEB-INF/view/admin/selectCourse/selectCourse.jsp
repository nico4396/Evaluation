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
                    <button class="layui-btn" lay-submit="" lay-filter="demo">立即提交</button>
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
    layui.use('table', function(){
        var table = layui.table,$ = layui.$;
        var height = 490; //固定表格高度
        //计算按钮的高度
        var btn_height = height /2 -44;
        $('.btn-height').css('padding-top',btn_height).css('text-align','center');

        //左边表格
        table.render({
            elem: '#left_tab'
            ,url: 'getAllCourse'
            ,where:{couids:$("#couids1").val()}
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{field:'couid', title: '编号', width:80, sort: true, fixed: true}
                ,{field:'couname', title: '科目名'}

            ]]
            ,response: {
                statusName: 'flag' //数据状态的字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,msgName: 'message' //状态信息的字段名称，默认：msg
                ,countName:'totalCount' //数据总数的字段名称，默认：count
            }
            ,request: {
                pageName: 'page.pageNo' //页码的参数名称，默认：page
                ,limitName: 'page.pageSize' //每页数据量的参数名，默认：limit
            }
            ,id: 'left_table_id'
            ,page: true
            ,height: height
        });
        //右边表格
        table.render({
            elem: '#right_tab'
            ,url: 'getAllClass'
            ,where:{classids:$("#classids2").val()}
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{field:'classid', title: '编号', width:80, sort: true, fixed: true}
                ,{field:'classname', title: '班级名'}

            ]]
            ,method:'post'
            ,response: {
                statusName: 'flag' //数据状态的字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,msgName: 'message' //状态信息的字段名称，默认：msg
                ,countName:'totalCount' //数据总数的字段名称，默认：count
            }
            ,request: {
                pageName: 'page.pageNo' //页码的参数名称，默认：page
                ,limitName: 'page.pageSize' //每页数据量的参数名，默认：limit
            }
            ,data: []
            ,id: 'right_table_id'
            ,page: true
            ,height: height
        });

        layui.sessionData('tabData',{ key: 'couids1',value: $("#couids1").val().split(",") })
        layui.sessionData('tabData',{ key: 'classids2',value: $("#classids2").val().split(",") })
        var couids1 = layui.sessionData('tabData').couids1;
        var classids2 = layui.sessionData('tabData').classids2;
        console.log(couids1);
        console.log(classids2);

        //监听左表格选中
        table.on('checkbox(left)', function(obj){
            btnIf(getTableData('left_table_id'),'.left-btn')
        });
        //监听右表格选中
        table.on('checkbox(right)', function(obj){
            btnIf(getTableData('right_table_id'),'.right-btn')
        });
        //移动按钮是否隐藏显示
        function btnIf(data,btn){
            if(data && data.length){
                $(btn).removeClass('layui-btn-disabled')
            }else{
                $(btn).addClass('layui-btn-disabled')
            }
        }
        //公共方法
        function getTableData(id){
            var checkStatus = table.checkStatus(id)
                ,data = checkStatus.data;
            return data;
        }
        //重载左边表格
        function reloadTable() {debugger
            var couids1 = layui.sessionData('tabData').couids1;
            var id_str1 = couids1.join(',');
            var classids2 = layui.sessionData('tabData').classids2;
            var id_str2 = classids2.join(',');
            table.reload('left_table_id', {
                page:{curr:1}
                ,method:'post'
                ,where: {
                    ids: id_str1
                }
            });
            table.reload('right_table_id', {
                page:{curr:1}
                ,method:'post'
                ,where: {
                    ids: id_str2
                }
            });
        }
        //左按钮点击移动数据
        $('.left-btn').on('click',function(){
            if(!$(this).hasClass('layui-btn-disabled')){
                $('.left-btn,.right-btn').addClass('layui-btn-disabled')
                var data = getTableData('left_table_id');debugger
                //查询缓存2是否存在数据
                var classids2 = layui.sessionData('tabData').classids2;
                //查询缓存1存在的数据
                var couids1 = layui.sessionData('tabData').couids1;
                $.each(data,function(k,v){
                    classids2.push(v.id)
                });
                $.each(data,function(k,v){
                    couids1.splice($.inArray(v.id.toString(),couids1),1) //删除选中的
                });
                //存储缓存2
                layui.sessionData('tabData',{key: 'classids2',value: classids2});
                //存储缓存1
                layui.sessionData('tabData',{key: 'couids1',value: couids1});
                reloadTable();
            }
        })
        //右按钮点击移动数据
        $('.right-btn').on('click',function () {
            if(!$(this).hasClass('layui-btn-disabled')){
                $('.left-btn,.right-btn').addClass('layui-btn-disabled')
                var data = getTableData('right_table_id');
                //查询缓存2是否存在数据
                var classids2 = layui.sessionData('tabData').classids2;
                //查询缓存1存在的数据
                var couids1 = layui.sessionData('tabData').couids1;
                $.each(data,function(k,v){
                    couids1.push(v.id)
                });
                $.each(data,function(k,v){
                    classids2.splice($.inArray(v.id,classids2),1) //删除选中的
                });
                //存储缓存2
                layui.sessionData('tabData',{key: 'classids2',value: classids2});
                //存储缓存1
                layui.sessionData('tabData',{key: 'couids1',value: couids1});
                reloadTable();
            }
        })
        //左表双击事件
        table.on('rowDouble(left)', function(obj){
            var couids1 = layui.sessionData('tabData').couids1;
            var classids2 = layui.sessionData('tabData').classids2;
            ids2.push(obj.data.id)
            ids1.splice($.inArray(obj.data.id,ids1),1) //删除选中的
            layui.sessionData('tabData',{ key: 'couids1',value: couids1 })
            layui.sessionData('tabData',{ key: 'classids2',value: classids2 })
            reloadTable()
        });
        //右表双击事件
        table.on('rowDouble(right)', function(obj){
            var couids1 = layui.sessionData('tabData').couids1;
            var classids2 = layui.sessionData('tabData').classids2;
            couids1.push(obj.data.id)
            classids2.splice($.inArray(obj.data.id,classids2),1) //删除选中的
            layui.sessionData('tabData',{ key: 'couids1',value: couids1 })
            layui.sessionData('tabData',{ key: 'classids2',value: classids2 })
            reloadTable()
        });
    });
</script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="edit" id="edit" name="edit">修改</a>
    <a class="layui-btn layui-bg-green layui-btn-xs" lay-event="delete" id="delete" name="delete">删除</a>
</script>
</body>
</html>
