<%--
  Created by IntelliJ IDEA.
  User: rujia
  Date: 2020/9/15
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转正评议页面</title>
    <link href="../../static/layui/css/layui.css" rel="stylesheet">
    <script src="../../static/layui/layui.js"></script>
</head>
<body class="layui-layout-body" >
<div class="layui-layout layui-layout-admin" >
    <div><%--class="layui-body"用于设置偏右--%>
        <!-- 内容主体区域 -->
        <div style="display: flex;justify-content: center">
            <div class="layui-form">
                <div class="layui-form-item">
                    <h1 align="center" style="margin: 10px 0px 10px 0px">转正评价</h1>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">员工部门：</label>
                    <div class="layui-input-block">
                        <input type="text" name="deptName" required lay-verify="required" placeholder="请输入标题" autocomplete="off"
                               class="layui-input" id="deptName">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">员工职务：</label>
                    <div class="layui-input-block">
                        <input type="text" name="jname" required lay-verify="required" placeholder="请输入作者" autocomplete="off"
                               class="layui-input" id="jname">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">评价人：</label>
                    <div class="layui-input-block">
                        <input type="text" name="appraise" required lay-verify="required" placeholder="请输入摘要" autocomplete="off"
                               class="layui-input" id="appraise">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">整体评价分数：</label>
                    <div class="layui-input-block">
                        <input type="text" name="score" required lay-verify="required" placeholder="请输入内容" autocomplete="off"
                               class="layui-input" id="score">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">评价（包括主要优点及缺陷）：</label>
                    <div class="layui-input-block">
                        <textarea type="text" name="content" required lay-verify="required" placeholder="请输入内容" autocomplete="off"
                                  class="layui-input" id="content"></textarea>
                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" id="addNews" lay-submit lay-filter="formDemo">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary" onclick="location.href='turnWork'">重置</button>
                        <button type="button" class="layui-btn layui-btn-primary" onclick="window.history.back()">返回</button>
                    </div>
                </div>
            </div>
        </div>
        <div align="center">
            <c:if test="${not empty requestScope.addTitleMsg}">
                <p class="green">${requestScope.addTitleMsg}</p>
            </c:if>
        </div>
    </div>

</div>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });

    layui.use('form',function () {
        var form = layui.form;
        $=layui.$;

        //点击提交按钮
        $("#addNews").click(function () {
            $.ajax({
                url:"evaTurnWork",
                type:"post",
                data:{
                    depeName:$("#depeName").val(),
                    jname:$("#jname").val(),
                    appraise:$("#appraise").val(),
                    score:$("#score").val(),
                    content:$("#content").val()
                },
                dataType:"text",//默认值为text
                success:function (data) {
                    /*if("true"==data){
                        layer.msg("评价成功");
                        setTimeout('closeAdd()',1000);
                    } else {
                        layer.msg("评价失败");
                        setTimeout('closeAdd()',1000);
                    }*/
                    alert(data)
                },
                error:function () {
                    layer.msg("执行失败")
                }
            })
        })
    });
    function createXMLHttpRequest() {
        try{
            return new XMLHttpRequest();
        }catch (e) {//如果发生异常，说明客户端浏览器版本低
            try{
                return  new ActiveXObject();
            }catch (e) {
                layer.msg("浏览器版本太低了");
            }
        }
    }
    var closeAdd = function () {
        parent.location.reload();//刷新父页面
    }
</script>
</body>
</html>
