<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>修改用户信息</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui-v2.6.1/layui/css/layui.css">
</head>
<script
		src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
<body>
<br><br>
<form class="layui-form" action="" enctype="multipart/form-data" method="">
    <%String oid =request.getParameter("userID");%>
    <input type="hidden" name="oid" value="<%=oid%>" class="layui-input">

    <div class="layui-form-item">
        <label class="layui-form-label">用户ID</label>
        <div class="layui-input-block">
            <input type="text" name="userID" style="width:200px;" autocomplete="off" value="<%=oid%>" class="layui-input">
        </div>
    </div>
    <%String password =request.getParameter("password");%>
    <div class="layui-form-item">
        <label class="layui-form-label">用户密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" style="width:200px;" autocomplete="off" value="<%=password%>" class="layui-input">
        </div>
    </div>
    <%String userName =request.getParameter("userName");
    userName = URLDecoder.decode(userName,"UTF-8");%>
    <div class="layui-form-item">
        <label class="layui-form-label">用户昵称</label>
        <div class="layui-input-block">
            <input type="text" name="userName" style="width:200px;" autocomplete="off" value="<%=userName%>" class="layui-input">
        </div>
    </div>
    <%String phoneNum =request.getParameter("phoneNum");%>
    <div class="layui-form-item">
        <label class="layui-form-label">电话号码</label>
        <div class="layui-input-block">
            <input type="text" name="phoneNum" style="width:200px;" autocomplete="off" value="<%=phoneNum%>" class="layui-input">
        </div>
    </div>
    <%String gender =request.getParameter("gender");%>
    <div class="layui-form-item">
        <label class="layui-form-label">性别修改</label>
        <div class="layui-input-block">       
			<input type="radio" name="gender" value="1"  title="男" <c:if test="${param.gender == 1}">checked="checked"</c:if> >
			<input type="radio" name="gender" value="0"  title="女" <c:if test="${param.gender == 0}">checked="checked"</c:if> >
		</div>
    </div>
    
    <%String competence = request.getParameter("competence");%>
    <div class="layui-form-item">
        <label class="layui-form-label">权限修改</label>
        <div class="layui-input-block">       
			<input type="radio" name="competence" value="1" title="管理员" <c:if test="${param.competence == 1}">checked="checked"</c:if> >
			<input type="radio" name="competence" value="0" title="用户"  <c:if test="${param.competence == 0}">checked="checked"</c:if> >
		</div>
    </div>

   
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1" type="button">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
    layui.use(['form'], function () {
        var form = layui.form;
        form.on('submit(demo1)', function (data) {
            $.ajax({
                url: "/musicBBS/Admin/updateUserById",
                type: "post",
                dataType: "json",
                data:{'oid':data.field.userID,'userID':data.field.userID,'password':data.field.password,
                        'phoneNum':data.field.phoneNum,'userName':data.field.userName,
                        'gender':data.field.gender,'competence':data.field.competence},
                success: function (res) {
                   
                    if (res.result == "1") {
                        layer.msg("编辑成功！",{icon: 6});
                        parent.a();
                    } else {
                        layer.msg("编辑失败！",{icon: 5});//失败的表情
                    }
                }
            });
        });
        return false;
    });
</script>
</body>
</html>