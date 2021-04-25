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
        <form action="${pageContext.request.contextPath}/user/updatePassword" method="post" id="updateNewPassword">
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    		当前密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text" id="oldPassword" name="oldPassword"/>
                    <span id="oldPassword_mess"></span> 	
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                   			新密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text" id="newPassword" name="newPassword"/>
                </div>
            </div>
            <div class="baseCon_son">
                <div class="baseCon_son_left">
                    		确认密码
                </div>
                <div class="baseCon_son_right">
                    <input type="text" id="newSePassword" name="newSePassword" onkeyup="passwordSame()"/>
                    <span id="newSePassword_mess"></span> 
                </div>
            </div>
            <input type="submit" value="确认修改" id="updatePassword" name="updatePassword" class="upload_sure"/>
            <input type="button" value="忘记密码" class="upload_sure"/>
        </form>
        </div>   
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
	  <script>
	  
	//判断两次密码是否一致
		function passwordSame(){		
		var password = document.getElementById("newPassword").value;
  		var repassword = document.getElementById("newSePassword").value;	    		
  		if(password == repassword) {
  			 $("#newSePassword_mess").html("").css("color","green");
  			 document.getElementById("updatePassword").disabled = false;
  			
			 }else {
				 $("#newSePassword_mess").html("两次输入的密码不一致").css("color","red");
	    		 document.getElementById("updatePassword").disabled = true; 
			 }			
		}
	  
         //点击修改密码
		$("#updatePassword").click(function(){	
		var oldPassword=$("#oldPassword").val();	
		//原密码是否正确：ajax		
		$.ajax({
			url:"${pageContext.request.contextPath }/user/checkOldPassword",
			type:"post",
			dataType:"text",
			async:false,
			data:"oldPassword="+oldPassword,
			success:function(obj){
				if(obj=="ok"){
					//原密码正确，提交表单根据账号密码验证登录
					$("#updateNewPassword").submit();		
				}else{
					//验证码错误
					$("#oldPassword_mess").html("当前密码错误！").css("color","red");
					return;
				}
			   }			
			})	
			return false;
		})
				
				
				
		
					
	 </script>
</body>
</html>