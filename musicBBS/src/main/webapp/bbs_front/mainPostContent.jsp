<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>帖子</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/index.css"/>
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
        </c:if>
        <!-- 登入结束-->
        <!-- 登入结束-->
    </div>
</header>
<div class="indexMain">
    <div class="indexMain_left">
        <div class="tzCon">
            <div class="tzCon_head">
                <div class="tzCon_head_left">
                <c:if test="${mainpost.user.photo!=null}">
                <a href=""><img src="/userPhoto/${mainpost.user.photo}"/></a></c:if>
                <c:if test="${mainpost.user.photo==null}">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a></c:if>
                </div>
                <div class="tzCon_head_right">
                    <h1>${mainpost.user.userName}</h1>
                    <ul>
                        <li>${mainpost.user.userName}</li>
                        <li>${mainpost.mainPostTime}</li>
                        <li>${mainpost.mainPostLikeCount}</li>
                    </ul>
                </div>
                <div class="clear">${mainpost.mainPostTitle}</div>
            </div>
            <div class="tzCon_con">
               ${mainpost.mainPostContent}
            </div>
            <div class="tzCon_foot">
                <div class="tzCollect" style="width:18%">                   
                    <div class="tzCollect_right">
                           <li>
	                        <input type="image" src="${pageContext.request.contextPath}/image/likeBlack.png"
	                        id="mylikepost" mainPostID=${mainpost.mainPostID} 
	                        name="img"  style="width:15px;height:15px" />  <!--图片按钮-->	                       
	                       </li>                      									
                    </div>
                    <div class="tzCollect_right">
                    		<li>
                            <input type="image" src="${pageContext.request.contextPath}/image/collect.png"  
                            id="collectpost" mainPostID=${mainpost.mainPostID}
                            name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            </li>                       
                    </div>
                    <div class="tzCollect_right">
                    		<li>
                            <input type="image" src="${pageContext.request.contextPath}/image/comment.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            </li>
                    </div>                                                                              
                </div>
            </div>
        </div>
        <div class="newPending">
            <div class="newPending_head">
                <div class="tzHeng"></div>
                <div class="newPending_head_tittle">最新评论</div>
            </div>
            <!--楼主可以删除评论、自己可以删除自己的评论删除按钮酌情出现-->
            <c:forEach items="${secondaryPostList.list}" var="secondaryPostList">           
            <div class="newPending_son">
                <div class="pendPic">
                
                <c:if test="${secondaryPostList.user.photo!=null}">
                <a href=""><img src="/userPhoto/${secondaryPostList.user.photo}"/></a></c:if>
                <c:if test="${secondaryPostList.user.photo==null}">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a></c:if>                           
                </div>
                <div class="pendDetail">
                    <div class="pendDetail_head">                                                                  	
                        <p>${secondaryPostList.user.userName} <span>发布于：<fmt:formatDate type="both" value="${secondaryPostList.secondaryPostTime}"/></span></p>
                        <i>2楼</i>
                    </div>
                    <div class="pendDetail_con">
                        <p>${secondaryPostList.secondaryPostContent}</p>
                    </div>
                    <div class="pendDetail_btn">
                        <ul>
                            <li>${secondaryPostList.secondaryPostGoodCount}</li>
                            <li class="replayBtn">${secondaryPostList.secondaryPostGoodCount}</li>
<!--                             <li class="delateBtn">删除</li> -->
                        </ul>
                    </div>
                    <div class="pendDetail_action">
                    <form action="${pageContext.request.contextPath}/SecondaryPost/writeToSecondaryPost?replyUserID=${secondaryPostList.user.userID}" 
            			  method="post" autocomplete="off">
                        <input type="text" name="secondaryPostContent" value="@${secondaryPostList.user.userName}      "/>
                        <button type="submit" style="color:red;">评论</button>                      
                    </form>
                    <button >取消</button>
                    </div>
                </div>
                <div class="clear"></div>
            </div>          
        </c:forEach>   
        </div>
        <div class="indexFooter">
            <div class="indexFooter_con">
                <a href="${pageContext.request.contextPath}/SecondaryPost/getSecondaryPostList?page=${secondaryPostList.pageNum-1}&size=${secondaryPostList.pageSize}&mainPostID=${mainpost.mainPostID}"><</a>
                <a href="${pageContext.request.contextPath}/SecondaryPost/getSecondaryPostList?page=${secondaryPostList.pageNum+1}&size=${secondaryPostList.pageSize}&mainPostID=${mainpost.mainPostID}">></a>
            </div>
        </div>
        <div class="writePending">
            <div class="newPending_head">
                <div class="tzHeng"></div>
                <div class="newPending_head_tittle">评论</div>
            </div>
            <form action="${pageContext.request.contextPath}/SecondaryPost/writeSecondaryPost" 
            method="post" autocomplete="off">
            <div class="writePending_con">
                <input type="text" placeholder="写下你的评论..." name="secondaryPostContent" id="secondaryPostContent"/>
                <input type="submit" value="评论"/>
            </div>
            </form>
        </div>
    </div>
    <div class="indexMain_right">
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
                    <li><a href="">关注音乐方面的资讯</a><span>29</span></li>
                    <li><a href="">关注音乐方面的资讯</a><span>29</span></li>
                    <li><a href="">关注音乐方面的资讯</a><span>29</span></li>
                    <li><a href="">关注音乐方面的资讯</a><span>29</span></li>
                    <li><a href="">关注音乐方面的资讯</a><span>29</span></li>
                    <li><a href="">关注音乐方面的资讯</a><span>29</span></li>                
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
      
    </div>
    <div class="clear"></div>
</div>
<footer class="publicFooter">
    <p>Copyrigh &copy; 2021 ZhouCheng 版权所有 音乐论坛 </p>
</footer>
</body>
<script src="${pageContext.request.contextPath}/bbs_front/js/jquery-1.8.3.min.js"></script>
<script src="${pageContext.request.contextPath}/bbs_front/js/tiezi.js"></script>
<script>

$("#mylikepost").click(function(){
	var like = $(this);
	var mainPostID = like.attr("mainPostID");
	//var mainPostUserID = like.attr("mainPostUserID");
	$.ajax({
		url:"${pageContext.request.contextPath}/LikeMainPost/likePost",
		type:"post",
		dataType:"text",
		async:false,
		data:"mainPostID="+mainPostID,
		//data:{mainPostID:mainPostID,mainPostUserID:mainPostUserID},
		success:function(obj){
			if(obj=="ok"){									
				//this.src="${pageContext.request.contextPath}/image/agreeRed.png";
				$("#mylikepost").attr("src", "${pageContext.request.contextPath}/image/likeRed.png");
			}else{					
				//this.src="${pageContext.request.contextPath}/image/agree.png";
				$("#mylikepost").attr("src", "${pageContext.request.contextPath}/image/likeBlack.png");
			}
		}			
	})	
	//return false;
})


$("#collectpost").click(function(){
	var collect = $(this);
	var mainPostID = collect.attr("mainPostID");
	//var mainPostUserID = like.attr("mainPostUserID");
	$.ajax({
		url:"${pageContext.request.contextPath}/Collect/collectPost",
		type:"post",
		dataType:"text",
		async:false,
		data:"mainPostID="+mainPostID,
		//data:{mainPostID:mainPostID,mainPostUserID:mainPostUserID},
		success:function(obj){
			if(obj=="ok"){									
				//this.src="${pageContext.request.contextPath}/image/agreeRed.png";
				$("#collectpost").attr("src", "${pageContext.request.contextPath}/image/collect_red.png");
			}else{					
				//this.src="${pageContext.request.contextPath}/image/agree.png";
				$("#collectpost").attr("src", "${pageContext.request.contextPath}/image/collect_black.png");
			}
		}			
	})	
	//return false;
})

</script>
</html>
