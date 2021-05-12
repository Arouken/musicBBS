<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>帖子热区</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/index.css"/>
    <style type="text/css">
	
	</style>
</head>
<body>
<header class="ltHead">
    <div class="ltHead_cen">
        <a href=""><img src="" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser" id="indexBBS">首页</a></li>
            <li><a href="${pageContext.request.contextPath }/Music/getMusicList">音乐欣赏</a></li>
            <li><a href="${pageContext.request.contextPath }/Category/getCategoryList">帖子热区</a></li>
            <li><a href="">站内公告</a></li>
            <li><a href="">我的关注</a></li>
            <li><a href="">我的收藏</a></li>
        </ul>
        <!--未登入开始-->
        <c:if test="${userSession.userName==null}">
        <div class="ltForm appear">
            <a href=""><img src="" alt="" class="headPic2"/></a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user_login.jsp">登入</a></li>
                <li><a href="${pageContext.request.contextPath}/user_regist.jsp">注册</a></li>
            </ul>
        </div>
        </c:if>
        <!-- 未登入结束-->
        <!-- 登入开始，未登入时以下隐藏-->
        <c:if test="${userSession.userName!=null}">
        <div class="lt_login appear">
        <ul>
        <li><a href="${pageContext.request.contextPath}/bbs_front/user_home.jsp">${userSession.userName}</a></li>
        <li><a href="${pageContext.request.contextPath}/user/quite">退出</a></li>
        </ul>
        </div>
        
        <!-- 登入结束-->
        <div class="navFix">
            <!--登入开始-->
            <a href="${pageContext.request.contextPath}/bbs_front/user_home.jsp" class="navMe">${userSession.userName}</a>
            <!--登入结束-->
            <!--未登入开始-->
            <!--<a href="" class="navLogin">退出</a>-->
            <!--未登入结束-->
            <a href="${pageContext.request.contextPath }/bbs_front/newMainPost.jsp" class="navWrite">发帖</a>
        </div>
        </c:if>
    </div>
</header>
<div class="indexMain">
    <div class="indexMain_left">

        <div class="indexSearch" >
                <input type="text" style="width:75%" placeholder="请输入音乐区关键词"/>             
                <input type="submit" style="float:right;"  value="搜索"/>
        </div>
        <div class="indexMain_left_con">
                       <!--分区循环开始-->     
            <c:forEach items="${categoryList.list}" var="categoryList">
         
            <div class="indexCon_msg">          
                <div class="indexCon_msg_pic" style="border-radius:5px;">
                <c:if test="${categoryList.categoryImg!=null}">
                <a href=""><img src="/categoryImg/${categoryList.categoryImg}"/></a></c:if>
                <c:if test="${categoryList.categoryImg==null}">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a></c:if>
                </div>
                <div class="indexCon_msg_detail">
                    <a href="${pageContext.request.contextPath}/MainPost/getCategoryPostList?categoryName=${categoryList.categoryName}">
                        <div class="indexCon_msg_detail_tittle">
                            <span><li>${categoryList.categoryName}</li></span>
                          
                           
                   
                        </div>
                    </a>
                  
                    <div class="indexCon_msg_detail_other">
                        <ul>                                                  
                            <li><p>创建时间： <fmt:formatDate type="date" value="${categoryList.categoryCreatDay}"/></p></li>
                             <p>${categoryList.categoryTxt}</p>
                         
                            <li style="float:right;">
                            <input type="image" src="${pageContext.request.contextPath}/image/collect.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostLikeCount}</li>
                            <li style="float:right;">
                            <input type="image" src="${pageContext.request.contextPath}/image/comment.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostLikeCount}</li>
                            
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        
           </c:forEach>                                            
        </div>
        <div class="indexFooter">
            <div class="indexFooter_con" style="width:52%;">
                <a >共</a>
                <a >${categoryList.pages}</a> 
                <a >页</a>
                <a >${categoryList.total}</a>
                <a >条</a>
                <a><select  onchange="submitPageSize(this)" style="height:100%;border: 0; background: transparent;">
					<option selected="selected">5</option>
					<option <c:if test="${categoryList.pageSize==10}">selected="selected"</c:if>>10</option>
					<option <c:if test="${categoryList.pageSize==20}">selected="selected"</c:if>>20</option>
					</select>					
				</a>
           		<a href="${pageContext.request.contextPath }/Category/getCategoryList?page=1&size=${categoryList.pageSize}" class="on">首页</a> 
                <a href="${pageContext.request.contextPath }/Category/getCategoryList?page=${categoryList.pageNum-1}&size=${categoryList.pageSize}">前页</a>               
                <a href="${pageContext.request.contextPath }/Category/getCategoryList?page=${categoryList.pageNum+1}&size=${categoryList.pageSize}">后页</a>
                <a href="${pageContext.request.contextPath }/Category/getCategoryList?page=${categoryList.pages}&size=${categoryList.pageSize}" class="on">尾页</a>             			   			
            </div>
        </div>
    </div>
    <div class="indexMain_right">
        <div class="indexMain_rightCon">
            <a href="${pageContext.request.contextPath }/bbs_front/user_newCategory.jsp" class="newMsg">创建分区</a>
            <div class="pwfb">
                <div class="pwfbHead">音乐播放器</div>
                <div class="pwfbCon">
	                <audio controls="controls">
					  <source src="/music/test.mp3" type="audio/ogg">
					  <source src="/music/test.mp3" type="audio/mpeg">
					  <embed height="100" width="100" src="/userPhoto/test.mp3" />
					</audio>
                </div>
                <div class="pwfbFooter"></div>
            </div>
            <div class="indexSearch">
                <input type="text" placeholder="请输入关键词"/>
                <input type="submit" value="搜索"/>
            </div>
            <div class="indexPublic">
                <div class="indexPublic_head">
                    	本周热议
                </div>
                <div class="indexPublic_con">
                    <ul class="weekHot">
                        <li><a href="">关注新型音乐方面的资讯</a><span>29</span></li>
                        <li><a href="">关注新型音乐方面的资讯</a><span>29</span></li>
                        <li><a href="">关注新型音乐方面的资讯</a><span>29</span></li>
                        <li><a href="">关注新型音乐方面的资讯</a><span>29</span></li>
                        <li><a href="">关注新型音乐方面的资讯</a><span>29</span></li>
                        <li><a href="">关注新型音乐方面的资讯</a><span>29</span></li>
                        <li><a href="">关注新型音乐方面的资讯</a><span>29</span></li>                     
                    </ul>
                </div>
            </div>
            <div class="indexPublic">
                <div class="indexPublic_head">
                    	友情链接
                </div>
                <div class="indexPublic_con">
                    <ul class="indexLink">
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
            <div class="clear">
                <p></p>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<footer class="publicFooter">
    <p>Copyrigh &copy; 2021 ZhouCheng 版权所有 音乐论坛 </p>
</footer>
</body>

<script src="${pageContext.request.contextPath}/bbs_front/js/jquery-1.8.3.min.js"></script>
<script>
    $(".indexMain_left_btn li a").click(function(){
        $(".indexMain_left_btn li a").removeClass("on");
        $(this).addClass("on");
    });
    window.onscroll=function(){
        var scrolls=document.body.scrollTop||document.documentElement.scrollTop;
        var slided=60;
        if(scrolls>=slided){
            $(".appear").hide();
            $(".navFix").show();
            $(".ltHead").addClass("navTop");
        }else{
            $(".appear").show();
            $(".navFix").hide();
            $(".ltHead").removeClass("navTop");
        }
    }; 
    
    

    function Format() {
    	var datetime = mainPostList.mainPostTime;
    	var fmt = "yyyy-MM-dd hh:mm:ss";
            if (parseInt(datetime)==datetime) {
                if (datetime.length==10) {
                    datetime=parseInt(datetime)*1000;
                } else if(datetime.length==13) {
                    datetime=parseInt(datetime);
                }
            }
            datetime=new Date(datetime);
            var o = {
                "M+" : datetime.getMonth()+1,                 //月份
                "d+" : datetime.getDate(),                    //日
                "h+" : datetime.getHours(),                   //小时
                "m+" : datetime.getMinutes(),                 //分
                "s+" : datetime.getSeconds(),                 //秒
              //  "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
                "S"  : datetime.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt))
                fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)
                if(new RegExp("("+ k +")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
             var d = document.getElementById('postTime');//获取div的节点
             d.innerHTML = fmt;//在div节点上显示a的值1
           // return fmt;
    };
    
    
	//每页显示条数变化
	function submitPageSize(option) {
	    /***
		 * 提交查询
         * option.value：获取select的值
         */
		location.href='${pageContext.request.contextPath }/Category/getCategoryList?size='+option.value;
    };


    $("#likepost").click(function(){
    	var like = $(this);
    	var mainPostID = like.attr("mainPostID");
    	var mainPostUserID = like.attr("mainPostUserID");
		$.ajax({
			url:"${pageContext.request.contextPath }/LikeMainPost/likePost",
			type:"post",
			dataType:"text",
			async:false,
			data:"mainPostID="+mainPostID,
			//data:{mainPostID:mainPostID,mainPostUserID:mainPostUserID},
			success:function(obj){
				if(obj=="ok"){									
					like.src="${pageContext.request.contextPath}/image/agreeRed.png";
					
				}else{					
					like.src="${pageContext.request.contextPath}/image/agree.png";
					
				}
			}			
		})	
		//return false;
	})
    
   
    
</script>




</html>