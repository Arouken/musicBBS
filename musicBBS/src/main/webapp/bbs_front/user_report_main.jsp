<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>举报帖子</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/write.css"/>
    <link rel="stylesheet" type="text/css" href="https://www.huangwx.cn/css/sweetalert.css">
</head>
<body>
<header class="ltHead">
    <div class="ltHead_cen">
        <a href=""><img src="" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser" id="indexBBS">首页</a></li>
            <li><a href="${pageContext.request.contextPath }/Music/getMusicList">音乐欣赏</a></li>
            <li><a href="${pageContext.request.contextPath }/Category/getCategoryList">帖子专区</a></li>
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
<div class="writeCon" style="width:30%;height:350px;">

    <div class="writeCon_head">
        <p>举报帖子</p>
    </div>
    <form action="${pageContext.request.contextPath}/ReportMain/addReport" method="post" id="addReport" enctype="multipart/form-data">
    <div class="writeCon_cen" style="width:100%;" >
      
	    <div class="writeCon_head" style="width:60%;height:60px;">
	           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   感谢您对社区所做的贡献！
	    </div>
	    
	    <div class="writeDown" id="writePost"  style="width:90%; padding-left:40px;">
	        <textarea style="OVERFLOW:hidden;width:100%;height:100%;font-size:20px;border-style:none;" 
	        id="reportTxt" name="reportTxt" autocomplete="off" placeholder="请输入举报原因" ></textarea>       
	    </div>
	    
        <input type="submit" class="reform" style="float:right;" id="addReportSub" value="确认举报"/>
    </div>
    </form>
   </div>

</body>

<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
<script type="text/javascript"
  src="${pageContext.request.contextPath}/bbs_front/js/wangEditor.min.js"></script>
 <script type="text/javascript" src="https://www.huangwx.cn/js/sweetalert-dev.js"></script>
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
  
 
	
	
	//判断是否登录，非空验证
	$("#addReportSub").click(function(){
		
		
		
		var uname=$("#reportTxt").val();
		if($.trim(uname).length==0){//去掉字符串的前后空格之后的长度是否为0
			//提示不能为空
			swal("举报内容不能为空！");
			//跳出方法
			return false;
		}		
	
		$.ajax({
			url:"${pageContext.request.contextPath }/user/checkIsLogin",  //请求的目标地址路径：目标servlet的映射路径以及对应的增删改查的方法
			type:"post",  //请求后台的方式：get/post
			async:false,
			success:function(obj){//根据服务器响应的参数进行处理：成功的回调函数
				//obj是ok或者是no
				console.log(obj);
				if(obj=="ok"){
					$("#addReport").submit();
					alert("举报成功！感谢您为社区所做的贡献！请点击确认，返回上一页");
					window.history.go(-1);
					return false;
				}else{
					//没有登录
					swal("请登录后再进行操作！");
					return false;
				}
			}			
				
		})
		
		return false;
		
	
	})
	
    
</script>


</html>