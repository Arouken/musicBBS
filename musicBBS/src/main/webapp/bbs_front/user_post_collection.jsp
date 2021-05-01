<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我收藏的贴</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/homeHead.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/homePublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/myWrite.css"/>
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
            <li><a href="${pageContext.request.contextPath}/bbs_front/user_info.jsp">基本设置</a></li>
            <li class="on"><a href="${pageContext.request.contextPath}/bbs_front/user_post.jsp">我的贴子</a></li>
            <li><a href="${pageContext.request.contextPath}/bbs_front/user_info_msg.jsp">我的回复</a></li>
        </ul>
    </div>
    <div class="homeCen_right">
        <div class="baseHead">
            <ul>
                <li><a href="${pageContext.request.contextPath}/bbs_front/user_post.jsp" >我的发帖</a></li>
                <li><a href="${pageContext.request.contextPath}/bbs_front/user_post_collection.jsp" class="on">我收藏的贴</a></li>
            </ul>
        </div>
        <div class="myWrite_con">
            <div class="writeHead">
                <div class="writeHead1">帖子标题</div>
                <div class="writeHead2">发表时间</div>
                <div class="writeHead3">浏览量</div>
                <div class="writeHead4">操作</div>
            </div>
            <div class="writeFoot">
                <div class="writeFoot1"><p><a href="">今天天气怎么样？</a></p></div>
                <div class="writeFoot2">2018.02.23 14:36:24</div>
                <div class="writeFoot3">2601</div>
                <div class="writeFoot4"><a href="javascript:">取消收藏</a></div>
            </div>
        </div>
        <div class="indexFooter">
            <div class="indexFooter_con">
                <a href="javascript:"><</a>
                <a href="" class="on">1</a>
                <a href="">2</a>
                <a href="">3</a>
                <a href="javascript:">></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>