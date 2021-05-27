<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>论坛后台管理</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui-v2.6.1/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">音乐论坛</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser">前台首页</a></li>
      <li class="layui-nav-item"><a href="">个人信息</a></li>
      <li class="layui-nav-item"><a href="">网站公告</a></li>
<!--       <li class="layui-nav-item"> -->
<!--         <a href="javascript:;">其它系统</a> -->
<!--         <dl class="layui-nav-child"> -->
<%--           <dd><a href="${pageContext.request.contextPath}/testtable.jsp">邮件管理</a></dd> --%>
<!--           <dd><a href="">消息管理</a></dd> -->
<!--           <dd><a href="">授权管理</a></dd> -->
<!--         </dl> -->
<!--       </li> -->
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="/userPhoto/${userSession.photo}" class="layui-nav-img">${userSession.userName} </a>
<!--         <dl class="layui-nav-child"> -->
<!--           <dd><a href="">基本资料</a></dd> -->
<!--           <dd><a href="">安全设置</a></dd> -->
<!--         </dl> -->
      </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/quite">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">用户管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/bbs_back/user_list.jsp" target="usermain">用户列表</a></dd>
            <dd><a href="${pageContext.request.contextPath}/bbs_back/admin_addUser.jsp" target="usermain">添加用户</a></dd>
<%--             <dd><a href="${pageContext.request.contextPath}/bbs_back/mainPost_list.jsp" target="usermain">信息修改</a></dd> --%>
<!--             <dd><a href="">超链接</a></dd> -->
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">帖子管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/bbs_back/mainPost_list.jsp">主贴列表</a></dd>
            <dd><a href="${pageContext.request.contextPath}/bbs_back/admin_report_main.jsp">主贴举报</a></dd>
            <dd><a href="javascript:;">回帖列表</a></dd>
            <dd><a href="${pageContext.request.contextPath}/bbs_back/category_list.jsp">分区列表</a></dd>
<!--             <dd><a href="">超链接</a></dd> -->
          </dl>
        </li>
         <li class="layui-nav-item">
          <a href="javascript:;">音乐管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/bbs_back/music_list.jsp">音乐列表</a></dd>
            <dd><a href="${pageContext.request.contextPath}/bbs_back/music_add.jsp">添加音乐</a></dd>
<%--             <dd><a href="${pageContext.request.contextPath}/bbs_back/music_info.jsp">音乐信息</a></dd> --%>
<!--             <dd><a href="">超链接</a></dd> -->
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">公告信息</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
   
    <div style="padding-top: 60px;">
    <iframe id="usermain" src="" style="width: 100%"; height=600px;></iframe>
  </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © 音乐论坛
  </div>
</div>
<script src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"></script>

<script>
//JavaScript代码区域
layui.use(['element','jquery'], function(){
  var $=layui.jquery;
  var element = layui.element;
  $(document).ready(function(){
  $("dd>a").click(function (e) {
      e.preventDefault();//取消事件的默认动作。
      $("#usermain").attr("src",$(this).attr("href"));
    });
  });
  // $("#cloud").click(function(){$("#main").html("jaosgoaighowg");});
});
</script>
</body>
</html>