<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>论坛首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/reset.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bbs_front/css/index.css"/>
</head>
<body>
<header class="ltHead">
    <div class="ltHead_cen">
        <a href=""><img src="" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser" id="indexBBS">首页</a></li>
            <li><a href="">音乐交流</a></li>
            <li><a href="">心情分享</a></li>
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
        <div class="indexMain_left_btn">
            <ul>
                <li><a href="javascript:">最新</a></li>
                <li><a href="javascript:" class="on">最热</a></li>
            </ul>
        </div>
        <div class="indexMain_left_con">
                       <!--帖子循环开始-->     
            <c:forEach items="${pageInfo.list}" var="mainPostList">
            <!--有主题图循环开始-->
            <c:if test="${mainPostList.mainPostImg!=null}">
            <div class="indexCon_msg">
                <div class="indexCon_msg_pic">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a>
                </div>
                <div class="indexCon_msg_detail">
                    <a href="${pageContext.request.contextPath}/bbs_front/mainPostContent.jsp">
                        <div class="indexCon_msg_detail_tittle">
                            <span><li>${mainPostList.userID}</li></span>
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
                            <li>发帖时间：${mainPostList.mainPostTime}</li>
                            <li>
                            <input type="image" src="${pageContext.request.contextPath}/image/agree.png"  name="img"  style="width:15px;height:15px" />  <!--图片按钮-->
                            ${mainPostList.mainPostGoodCount}</li>
                            <li>
                            <input type="image" src="${pageContext.request.contextPath}/image/disagree.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostBadCount}</li>
                            <li>
                            <input type="image" src="${pageContext.request.contextPath}/image/comment.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostBadCount}</li>
                            
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
                <div class="indexCon_msg_pic">
                <a href=""><img src="${pageContext.request.contextPath}/image/defaultPhoto.png"/></a>
                </div>
                <div class="indexCon_msg_detail">
                    <a href="${pageContext.request.contextPath}/bbs_front/mainPostContent.jsp">
                        <div class="indexCon_msg_detail_tittle">
                            <span><li>${mainPostList.userID}</li></span>
                            <p>${mainPostList.mainPostTitle}</p>
                        </div>
                    </a>
                    <div class="indexCon_msg_detail_other">
                       <ul>                        
                            <li>发帖时间：${mainPostList.mainPostTime}</li>
                            <li>
                            <input type="image" src="${pageContext.request.contextPath}/image/agree.png"  name="img"  style="width:15px;height:15px" />  <!--图片按钮-->
                            ${mainPostList.mainPostGoodCount}</li>
                            <li>
                            <input type="image" src="${pageContext.request.contextPath}/image/disagree.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostBadCount}</li>
                            <li>
                            <input type="image" src="${pageContext.request.contextPath}/image/comment.png"  name="img" style="width:15px;height:15px"/>  <!--图片按钮-->
                            ${mainPostList.mainPostBadCount}</li>
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
            <div class="indexFooter_con">
                <a href="javascript:"><</a>
                <a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser" class="on">1</a>
                <a href="">2</a>
                <a href="">3</a>
                <a href="javascript:">></a>
                
            </div>
        </div>
    </div>
    <div class="indexMain_right">
        <div class="indexMain_rightCon">
            <a href="${pageContext.request.contextPath }/bbs_front/newMainPost.jsp" class="newMsg">发新帖</a>
            <div class="pwfb">
                <div class="pwfbHead">音乐播放器</div>
                <div class="pwfbCon">
	                <audio controls="controls">
					  <source src="${pageContext.request.contextPath}/music/song.ogv" type="audio/ogg">
					  <source src="${pageContext.request.contextPath}/music/song.ogv" type="audio/mpeg">
					  <embed height="100" width="100" src="${pageContext.request.contextPath}/music/song.ogv" />
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
    
   
    
</script>




</html>