<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>帖子专区</title>
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
        <div class="indexMain_left_btn" style="display:block;height:180px;">
            <div class="tzCon_head" style="padding-top: 40px;padding-left: 60px;">
                <div class="tzCon_head_left" style="height:80px;width:80px;">
<%--                 <c:if test="${mainpost.user.photo!=null}"> --%>
<%--                 <a href=""><img src="/userPhoto/${mainpost.user.photo}"/></a></c:if> --%>
<%--                 <c:if test="${mainpost.user.photo==null}"> </c:if>--%>
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png" style="height:80px;width:80px;"/></a>
                </div>
                <div class="tzCon_head_right">                 
                    	<h1>${categoryNameSession}区</h1>
	                    <ul>
	                        <li>fffff</li>
	                        <li>ceshi</li>
	                        <li>ceshi</li>
	                        <li>ceshi</li>
	                        <li>cesdi</li>
	                    </ul>                          
                </div>
            
                <div class="clear" style="padding-top: 4px;padding-left:15%;">简介</div>
            </div>
          
        </div>
        <div class="indexMain_left_con">
                       <!--帖子循环开始-->     
            <c:forEach items="${pageInfo.list}" var="mainPostList">
            <!--有主题图循环开始-->
            <c:if test="${mainPostList.mainPostImg!=null}">
            <div class="indexCon_msg">          
                <div class="indexCon_msg_pic" style="border-radius:30px;">
                <c:if test="${mainPostList.user.photo!=null}">
                <a href=""><img src="/userPhoto/${mainPostList.user.photo}"/></a></c:if>
                <c:if test="${mainPostList.user.photo==null}">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a></c:if>
                </div>
                <div class="indexCon_msg_detail">
                    <a href="${pageContext.request.contextPath}/MainPost/getMainPostContent?mainPostID=${mainPostList.mainPostID}">
                        <div class="indexCon_msg_detail_tittle">
                            <span><li>${mainPostList.user.userName}</li></span>
                            <p>${mainPostList.mainPostTitle}</p>
                           
                   
                        </div>
                    </a>
                    <div class="havePic">
                        <a href=""><div class="havePic_head">
                        <img src="/userPhoto/${mainPostList.mainPostImg}" alt="" />
                        </div></a>
                    </div>
                    <div class="indexCon_msg_detail_other">
                        <ul>                                                  
                            <li><p>发帖时间： <fmt:formatDate type="both" value="${mainPostList.mainPostTime}"/></p></li>
                            <li style="float:right;">
                            <input type="image" src="${pageContext.request.contextPath}/image/likeBlack.png"
	                        id="likepost" mainPostID=${mainpost.mainPostID} 
	                        name="img"  style="width:15px;height:15px" />  <!--图片按钮-->	  
                            </li>
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
            </c:if>
            <!--有主题图循环结束-->
            <!--无主题图循环开始-->
            <c:if test="${mainPostList.mainPostImg==null}">
            <div class="indexCon_msg">
                <div class="indexCon_msg_pic" style="border-radius:30px">
               <c:if test="${mainPostList.user.photo!=null}">
                <a href=""><img src="/userPhoto/${mainPostList.user.photo}"/></a></c:if>
                <c:if test="${mainPostList.user.photo==null}">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a></c:if>
                </div>
                <div class="indexCon_msg_detail">
                    <a href="${pageContext.request.contextPath}/MainPost/getMainPostContent?mainPostID=${mainPostList.mainPostID}">
                        <div class="indexCon_msg_detail_tittle">
                            <span><li>${mainPostList.user.userName}</li></span>
                            <p>${mainPostList.mainPostTitle}</p>
                         
                        </div>
                    </a>
                    <div class="indexCon_msg_detail_other">
                       <ul>                        
                            <li><p>发帖时间： <fmt:formatDate type="both" value="${mainPostList.mainPostTime}" /></p></li>
                            <li></li>
                            <li style="float:right;">
                            <input type="image" src="${pageContext.request.contextPath}/image/likeBlack.png"  name="img"  style="width:15px;height:15px" />  <!--图片按钮-->
                            ${mainPostList.mainPostLikeCount}</li>
                            <li style="float:right;">
                            <input type="image" src="${pageContext.request.contextPath}/image/collect.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostLikeCount}</li>
                            <li style="float:right;">
                            <input type="image" src="${pageContext.request.contextPath}/image/comment.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostLikeCount}</li>
                            <li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
               
            </div>
            </c:if>
            <!--无主题图循环结束-->
           </c:forEach>                                            
        </div>
        <div class="indexFooter">
            <div class="indexFooter_con" style="width:52%;">
                <a >共</a>
                <a >${pageInfo.pages}</a> 
                <a >页</a>
                <a >${pageInfo.total}</a>
                <a >条</a>
                <a><select  onchange="submitPageSize(this)" style="height:100%;border: 0; background: transparent;">
					<option selected="selected">5</option>
					<option <c:if test="${pageInfo.pageSize==10}">selected="selected"</c:if>>10</option>
					<option <c:if test="${pageInfo.pageSize==20}">selected="selected"</c:if>>20</option>
					</select>					
				</a>
           		<a href="${pageContext.request.contextPath }/MainPost/getCategoryPostList?page=1&size=${pageInfo.pageSize}&categoryName=${categoryNameSession}" class="on">首页</a> 
                <a href="${pageContext.request.contextPath }/MainPost/getCategoryPostList?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}&categoryName=${categoryNameSession}">前页</a>               
                <a href="${pageContext.request.contextPath }/MainPost/getCategoryPostList?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}&categoryName=${categoryNameSession}">后页</a>
                <a href="${pageContext.request.contextPath }/MainPost/getCategoryPostList?page=${pageInfo.pages}&size=${pageInfo.pageSize}&categoryName=${categoryNameSession}" class="on">尾页</a>             			   			
            </div>
        </div>
    </div>
    <div class="indexMain_right">
        <div class="indexMain_rightCon">
            <a href="${pageContext.request.contextPath }/bbs_front/newMainPost.jsp" class="newMsg">发新帖</a>
             <div class="myMsg">
            <div class="myMsg_con">
                <div class="myMsg_conPic">
                <c:if test="${mainpost.user.photo!=null}">
                <a href=""><img src="/userPhoto/${mainpost.user.photo}"/></a></c:if>
                <c:if test="${mainpost.user.photo==null}">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a></c:if>
                </div>
                <p>${mainpost.user.userName}</p>
            </div>
            <div  class="myMsg_footer">
                <ul>
                    <li><a href="">
                        <p>主题数</p>
                        <p>23</p>
                    </a></li>
                    <li><a href="">
                        <p>精华数</p>
                        <p>23</p>
                    </a></li>
                    <li><a href="">
                        <p>注册排名</p>
                        <p>23</p>
                    </a></li>
                </ul>
            </div>
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
		location.href='${pageContext.request.contextPath }/MainPost/getCategoryPostList?categoryName=${categoryNameSession}&size='+option.value;
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