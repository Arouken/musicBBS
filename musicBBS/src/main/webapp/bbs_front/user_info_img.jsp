<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>修改头像</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/homeHead.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/homePublic.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/base.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/write.css"/>
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
                <li><a href="${pageContext.request.contextPath }/bbs_front/user_info_img.jsp" class="on">头像</a></li>
                <li><a href="${pageContext.request.contextPath }/bbs_front/user_info_password.jsp">密码</a></li>
            </ul>
        </div>
        <div class="baseCon">
        <form action="${pageContext.request.contextPath}/user/uploadPhoto" method="post" id="" enctype="multipart/form-data">
            <div class="upImg">
<!--                 <div class="Imgbtn">选择头像 -->
<!--                     <input type="file" class="uploadPic" name="photo" id="photo" /> -->
<!--                 </div> -->
                
                <div class="writePic">
            		<input type="file" accept=".jpeg, .jpg, .png" class="upload_file" name="photo" id="photo"/>
        		</div>
                
                <p>建议尺寸168*168，支持jpg、png、gif,最大不能超过50KB</p>
                <!--  虚拟挂载 -->
                <div class="mypic">
                    <img src="/userPhoto/${userSession.photo}" alt="" />
                </div> 
                <div class="Imgbtn">上传头像
                    <input  class="uploadPic" name="" type="submit"/>
                </div>
            </div>
        </form>
        </div>
    </div>
</div>
</body>
</html>