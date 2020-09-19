<%--
  Created by IntelliJ IDEA.
  User: sd
  Date: 2020/9/16
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理页面</title>
</head>
<style>
    .layui-table-tool-self {
        display: none;
    }

    .layui-icon-ok {
        margin-top: 6px;
    }

    #sname, #classname {
        font-size: 20px;
    }
</style>
<link href="../../../../static/layui/css/layui.css" rel="stylesheet">
<script src="../../../../static/layui/layui.js"></script>
<script src="../../static/js/jquery-3.3.1.js"></script>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">欢迎来到学员跟踪管理界面</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <div style="margin-right: 20px" align="right"><span>当前用户：</span><span
                        style="color: #ffffff">${sessionScope.uname}</span></div>
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
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
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
        <div align="center">
            <h4 style="margin: 10px 0 20px 0">学生列表</h4>
            <form method="post" enctype="multipart/form-data" id="uploadForm">
                <input type="file" name="upload" id="upload" style="display: none">
            </form>
            <input type="text" id="imgname" value="${sessionScope.imgName}" style="display: none">
            <table id="demo" lay-filter="test"></table>
            <c:if test="${not empty requestScope.delMsg}">
                <p>${requestScope.delMsg}</p>
            </c:if>
        </div>
        <script type="text/html" id="toolbarDemo">
            <div align="right">
                <div class="layui-input-inline">
                    <input type="text" id="sname" name="sname" placeholder="请输入学生名称" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="classname" name="classname" placeholder="请输入班级名称" class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <button class="layui-btn layui-btn-sm" lay-event="query">查询</button>
                    <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
                </div>
            </div>

        </script>
        <script>
            layui.use(['table', 'layer', 'form'], function () {
                var table = layui.table;
                var layer = layui.layer;
                var $ = layui.jquery;
                var form = layui.form;

                table.render({
                    elem: '#demo'
                    , toolbar: '#toolbarDemo'//添加工具栏
                    , height: 500
                    , width: 1450
                    , url: '/getAllStudentAmd' //数据接口
                    , page: true //分页
                    , limit: 10//每页显示几条数据
                    , limits: [5, 10, 15, 20]
                    , cols: [[ //表头
                        //{type:'checkbox'},
                        {type: "numbers", title: '序号', width: 50}
                        , {field: 'sid', title: '编号', width: 50, sort: true, hide: true}
                        , {field: 'sname', title: '姓名', width: 80}
                        , {field: 'sex', title: '性别', width: 80}
                        , {field: 'nation', title: '民族', width: 80}
                        , {field: 'birthday', title: '出生日期', width: 120}
                        , {field: 'place', title: '籍贯', width: 100}
                        , {field: 'marry', title: '婚否', width: 120}
                        , {field: 'tel', title: '电话', width: 120}
                        , {field: 'idcard', title: '身份证号码', width: 160, hide: true}
                        , {field: 'school', title: '毕业学校', width: 100}
                        , {field: 'major', title: '专业', width: 150}
                        , {field: 'notes', title: '备注', width: 120, hide: true}
                        , {field: 'jid', title: '职工编号', width: 40, hide: true}
                        , {field: 'classid', title: '班级编号', width: 40, hide: true}
                        , {field: 'classname', title: '班级名称', sort: true, width: 120}
                        , {field: '', title: '操作', toolbar: "#bar", width: 300}
                    ]]
                });
                //监听事件是lay-filter为test的员工的工具栏
                table.on('toolbar(test)', function (obj) {
                    switch (obj.event) {
                        case 'query':
                            //获取查询条件
                            var filter = $("#sname").val();
                            var filter1 = $("#classname").val();
                            table.reload("demo", {//demo对应的是table的id
                                where: {sname: filter, classname: filter1},//where对应的是过滤条件
                                page: {
                                    curr: 1
                                }
                            });
                            break;
                        case 'add':
                            location.href = "addStudent";
                            break;
                    }
                });

                table.on('tool(test)', function (obj) {
                    var data = obj.data; //获得当前行数据
                    var sid = data.sid;
                    var layEvent = obj.event;

                    if (layEvent == 'uploadImg') {
                        $("#upload").change(function () {
                            //获取要上传的数据
                            //使用FormData可以实现ajax的文件提交
                            var formData = new FormData($("#uploadForm")[0]);
                            $.ajax({
                                url: "uploadFile",
                                type: "post",
                                data: formData,
                                cache: false,//是否缓存
                                //contentType必须设定为false，
                                //即告诉服务器从浏览器提交过来的数据采用默认的数据格式
                                contentType: false,
                                //设定为false可避免jQuery对formData的默认处理
                                processData: false,
                                success: function (data) {
                                    layer.msg("上传成功");
                                },
                                error: function (data) {
                                    alert("上传失败")
                                }
                            });
                        });
                    }else if(layEvent == 'save'){
                        var imgName = $("#imgname").val();
                        $.ajax({
                            url:"upload",
                            type:"post",
                            data:{
                                sid:sid,
                                imgName:imgName
                            },
                            success:function (data) {
                                layer.msg("保存成功")
                            },
                            error:function (data) {
                                layer.msg("保存失败")
                            }
                        });
                    }

                    else if (layEvent == 'delete') {
                        //获取选中行
                        var checkStatus = table.checkStatus('demo'); //demo为table的id 即为基础参数 id 对应的值;
                        //获取选中行的数据
                        var date = checkStatus.data;
                        layer.confirm('确定要删除吗？', '删除命令', function () {
                            $.ajax({
                                url: "checkStudent",
                                type: "post",
                                data: {
                                    sid: sid
                                },
                                success: function (data) {
                                    if (data == '可以删除') {
                                        $.ajax({
                                            url: "deleteStudentByid",
                                            type: "post",
                                            data: {
                                                sid: sid
                                            },
                                            success: function (data) {
                                                if (data) {
                                                    layer.msg("删除成功")
                                                } else {
                                                    layer.msg("删除失败")
                                                }
                                                //重新加载表格
                                                table.reload("demo", function () {
                                                    url:"getAllStudentAmd"
                                                })
                                            },
                                            error: function (data) {
                                                layer.msg("执行失败")
                                            }
                                        })
                                    } else {
                                        layer.msg("该学生已入职不能删除")
                                    }

                                },
                                error: function (data) {
                                    $.ajax({
                                        url: "deleteStudentByid",
                                        type: "post",
                                        data: {
                                            sid: sid
                                        },
                                        success: function (data) {
                                            if (data) {
                                                layer.msg("删除成功")
                                            } else {
                                                layer.msg("删除失败")
                                            }
                                            //重新加载表格
                                            table.reload("demo", function () {
                                                url:"getAllStudentAmd"
                                            })
                                        },
                                        error: function (data) {
                                            layer.msg("执行失败")
                                        }
                                    })
                                }
                            })
                        })

                    } else if (layEvent == 'edit') {
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
                        var classid = data.classid;
                        var classname = data.classname;
                        $.ajax({
                            url: "getBySid",
                            type: "post",
                            data: {
                                sid: sid
                            },
                            success: function (data) {
                                location.href = "editStudent?classid=" + classid + "&classname=" + classname
                            },
                            error: function (data) {
                                alert("执行失败")
                            }
                        })
                    }
                });
            })
        </script>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
</script>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="edit" id="edit" name="edit">查看</a>
    <a class="layui-btn layui-bg-green layui-btn-xs" lay-event="delete" id="delete" name="delete">删除</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="uploadImg" href="javascript:$('#upload').click()">上传照片</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="save" >保存</a>
</script>
</body>
</html>
