<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>发表帖子</title>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/write.css"/>
</head>
<body>
<header class="ltHead">
    <div class="ltHead_cen">
        <a href=""><img src="" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser">首页</a></li>
            <li><a href="">音乐交流</a></li>
            <li><a href="">心情分享</a></li>
            <li><a href="">站内公告</a></li>
            <li><a href="">我的关注</a></li>
            <li><a href="">我的收藏</a></li>
        </ul>
        <!--未登入开始-->
        <c:if test="${userSession.userName==null}">
        <div class="ltForm">
            <a href=""><img src="img/indexForm_bg.png" alt="" class="headPic2"/></a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user_login.jsp">登入</a></li>
                <li><a href="${pageContext.request.contextPath}/user_regist.jsp">注册</a></li>
            </ul>
        </div>
        </c:if>
        <!-- 未登入结束-->
        <!-- 登入开始，未登入时以下隐藏-->
        <c:if test="${userSession.userName!=null}">
        <div class="lt_login">
        <ul>
	        <li><a href="">${userSession.userName}</a></li>
	        <li><a href="${pageContext.request.contextPath}/user/quite">退出</a></li>
        </ul>
        </div>
        </c:if>
        <!-- 登入结束-->
    </div>
</header>
<div class="writeCon">

    <div class="writeCon_head">
        <p>发新帖</p>
    </div>
    <form action="${pageContext.request.contextPath}/MainPost/writeMainPost" method="post" id="" enctype="multipart/form-data">
    <div class="writeCon_cen">
        <div class="writePic" style="width:46%">
            <input  type="file" accept=".jpeg, .jpg, .png" 
            class="upload_file" id="mainPostImg" name="mainPostImg"/>
<!--             <div class="writePic"><img id="imgLook" src="" alt="" /></div> -->
        </div>
         <div  style="width:28%;height:180px;position:absolute;left:780px;top:160px;">          
			<img id="imgLook" style="width:240px;height:180px;" src="" alt="" />
        </div>
        <div class="writeMsg">
            <input type="text" name="mainPostTitle" placeholder="请输入标题"/>
        </div>
        <div class="chooseDevide">
            <div class="chooseDevide_left">
                                    所在分类
            </div>
            <div class="chooseDevide_right">
                <div class="nice-select" name="nice-select">
                    <input type="text" value="请选择" readonly>
                    <ul>
                       <li><a href="">网易云音乐</a></li>
                       <li><a href="">QQ音乐</a></li>
                       <li><a href="">酷狗音乐</a></li>
                       <li><a href="">哔哩哔哩</a></li>
                       <li><a href="">QQ音乐</a></li>
                       <li><a href="">酷狗音乐</a></li>
                       <li><a href="">哔哩哔哩</a></li>
                    </ul>
                </div>
            </div>
        </div>
<!--         style="height:300px;" -->
        <div class="writeDown" id="writePost" >
        <textarea style="OVERFLOW:hidden;width:100%;height:100%;font-size:20px;border-style:none;" 
        id="write" name="mainPostContent" autocomplete="off"></textarea>
        
        </div>
        <input type="submit" class="reform" value="发布"/>
    </div>
    </form>
   </div>

</body>

<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
<script type="text/javascript"
  src="${pageContext.request.contextPath}/bbs_front/js/wangEditor.min.js"></script>
<script>
    $('[name="nice-select"]').click(function(e){
        $('[name="nice-select"]').find('ul').hide();
        $(this).find('ul').show();
        e.stopPropagation();
    });
    $('[name="nice-select"] li').hover(function(e){
        $(this).toggleClass('on');
        e.stopPropagation();
    });
    $('[name="nice-select"] li').click(function(e){
        var val = $(this).text();
        var dataVal = $(this).attr("data-value");
        $(this).parents('[name="nice-select"]').find('input').val(val);
        $('[name="nice-select"] ul').hide();
        e.stopPropagation();
    });
    $(document).click(function(){
        $('[name="nice-select"] ul').hide();
    });
    
  //判断两次密码是否一致
	function picIsNull(){
		var mainPostImg = document.getElementById("mainPostImg").value;	    		
		if(mainPostImg == null) {			
			 document.getElementById("mainPostImg").disabled = false;			
		 }else {			 
    		 document.getElementById("mainPostImg").disabled = true; 
		 }			
	}
    
  //预览上传图片
	$(document).ready(function() {
	    //alert("nihao1");
	    $("#mainPostImg").change(function() {
	        var current_pic=this.files[0];
	        preview_picture(current_pic);
	    });
	    
	});
	 
	function preview_picture(pic) {
	    //alert("你好！");
	    var r=new FileReader();
	    r.readAsDataURL(pic);
	    r.onload=function (){
	        //alert("你好123！");
	        $("#imgLook").attr("src",this.result).show();
	        //alert("你好321！");
	    };
	    
	}
    
</script>


</html>