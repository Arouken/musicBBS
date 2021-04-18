<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
        <a href=""><img src="img/logo.png" alt="" class="headPic1"/></a>
        <ul class="headNav">
            <li><a href="${pageContext.request.contextPath }/MainPost/getMainPostListUser">首页</a></li>
            <li><a href="">音乐交流</a></li>
            <li><a href="">心情分享</a></li>
            <li><a href="">站内公告</a></li>
            <li><a href="">我的关注</a></li>
            <li><a href="">我的收藏</a></li>
        </ul>
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
        <li><a href="">花开花落</a></li>
        <li><a href="">退出</a></li>
        </ul>
        </div>
        <!-- 登入结束-->
    </div>
</header>
<div class="writeCon">
    <div class="writeCon_head">
        <p>发新帖</p>
    </div>
    <div class="writeCon_cen">
        <div class="writePic">
            <input type="file" accept=".jpeg, .jpg, .png" class="upload_file"/>
        </div>
        <div class="writeMsg">
            <input type="text" placeholder="请输入标题"/>
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
        <div class="writeDown"></div>
        <input type="submit" class="reform" value="发布"/>
    </div>
</div>
</body>

<script src="js/jquery-1.8.3.min.js"></script>
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
</script>
</html>