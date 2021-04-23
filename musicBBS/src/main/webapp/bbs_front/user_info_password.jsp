<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/homeHead.css"/>
    <link rel="stylesheet" href="css/homePublic.css"/>
    <link rel="stylesheet" href="css/base.css"/>
</head>
<body>
<header class="zyHead">
    <div class="zyHead_cen">
        <a href=""><img src="" alt="" class="headPic1"/></a>
        <a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser" class="backIndex">返回首页</a>
        <!--未登入开始-->
        <!--<div class="ltForm">-->
        <!--<a href=""><img src="img/indexForm_bg.png" alt="" class="headPic2"/></a>-->
        <!--<ul>-->
        <!--<li><a href="">登入</a></li>-->
        <!--<li><a href="">注册</a></li>-->
        <!--</ul>-->
        <!--</div>-->
        <!-- 未登入结束-->
        <!-- 登入开始，未登入时以下隐藏-->
        <div class="lt_login">
            <ul>
                <li><a href="">${userSession.userName}</a></li>
                <li><a href="${pageContext.request.contextPath}/user/quite">退出</a></li>
            </ul>
        </div>
        <!-- 登入结束-->
    </div>
</header>
<div class="homeCen">
    <div class="homeCen_left">
        <ul>
            <li><a href="${pageContext.request.contextPath}/bbs_front/user_home.jsp">我的主页</a></li>
            <li  class="on"><a href="${pageContext.request.contextPath}/bbs_front/user_info.jsp">基本设置</a></li>
            <li><a href="${pageContext.request.contextPath}/bbs_front/user_post.jsp">我的贴子</a></li>
        </ul>
    </div>
    <div class="homeCen_right">
        <div class="baseHead">
            <ul>
                <li><a href="${pageContext.request.contextPath }/bbs_front/user_info.jsp">我的资料</a></li>
                <li><a href="${pageContext.request.contextPath }/bbs_front/user_info_img.jsp">头像</a></li>
                <li><a href="${pageContext.request.contextPath }/bbs_front/user_info_password.jsp" class="on">密码</a></li>
            </ul>
        </div>
        <div class="baseCon">
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    当前密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text"/>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    新密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text"/>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    确认密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text"/>
                </div>
            </div>
            <input type="submit" value="确认修改" class="upload_sure"/>
        </div>
    </div>
</div>
</body>
</html>