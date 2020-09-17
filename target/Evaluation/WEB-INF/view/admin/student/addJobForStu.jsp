<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 2020/9/17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工入职</title>
    <link rel="stylesheet" href="../../../../static/layui/css/layui.css">
    <script src="../../../../static/layui/layui.js"></script>
</head>
<style>
    .layui-table-tool-self{
        display: none;
    }
    .layui-icon-ok{
        margin-top: 6px;
    }
    #jname,#deptname{
        font-size: 20px;
    }
</style>
<body>
<div style="display: flex;justify-content: center">
    <div class="layui-form">
        <h1 align="center" style="margin: 30px 0px 20px 0px">员工入职</h1>
        <table id="demo" lay-filter="test"></table>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit" id="addBtn">立即提交</button>
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
<script>
    layui.use(['table','layer'], function(){
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        table.render({
            elem: '#demo'
            ,toolbar: '#toolbarDemo'//添加工具栏
            ,height: 400
            ,width:380
            ,url: '/getAllJob' //数据接口
            ,page: true //分页
            ,limit:5//每页显示几条数据
            ,limits:[5,10,15,20]
            ,cols: [[ //表头
                {type:'checkbox'}
                ,{type:"numbers",title:'序号',width:80,hide:true}
                ,{field: 'jid', title: '编号', width:80, sort: true}
                ,{field: 'jname', title: '职位', width:100}
                ,{field: 'deptName', title: '部门', width:100}
            ]]

        });
        $("#addBtn").click(function () {
            //获取选中行
            var checkStatus = table.checkStatus('demo'); //demo为table的id 即为基础参数 id 对应的值;
            //获取选中行的数据
            var date = checkStatus.data;
            var jid = date[0].jid;
            var sid = ${sessionScope.student.sid};
            if (date.length < 1){
                layer.msg("请选择一条数据")
            }else if(date.length > 1){
                layer.msg("只能选择一条数据")
            }else {
                $.ajax({
                    url:"CheckMark",
                    type:"post",
                    data:{
                        jid:jid,
                        sid:sid,
                    },
                    dataType:"text",//默认值为text
                    success:function (data) {
                        if (data === '可以入职'){
                            $.ajax({
                                url:"addJobToStudent",
                                type:"post",
                                data:{
                                    jid:jid,
                                    sid:sid,
                                },
                                dataType:"text",//默认值为text
                                success:function (data) {
                                    layer.msg(data);
                                    setTimeout('closeadd()',1000)
                                },
                                error:function (data) {
                                    layer.msg("该学生未完成课程，不能入职")
                                }
                            })
                        }else {
                            layer.msg("该学生还未完成课程，不能入职")
                        }

                        setTimeout('closeadd()',1000)
                    },
                    error:function (data) {
                        layer.msg("该学生未完成课程，不能入职")
                    }
                })
            }
        })
        table.on('tool(test)', function(obj){


    });
    });
</script>
</body>
</html>
