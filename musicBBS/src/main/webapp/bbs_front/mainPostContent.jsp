<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>帖子</title>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/index.css"/>
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
        <div class="ltForm">
            <a href=""><img src="img/indexForm_bg.png" alt="" class="headPic2"/></a>
            <ul>
                <li><a href="">登入</a></li>
                <li><a href="">注册</a></li>
            </ul>
        </div>
        <!-- 未登入结束-->
        <!-- 登入开始，未登入时以下隐藏-->
        <!--<div class="lt_login">-->
        <!--<ul>-->
        <!--<li><a href="">花开花落</a></li>-->
        <!--<li><a href="">退出</a></li>-->
        <!--</ul>-->
        <!--</div>-->
        <!-- 登入结束-->
    </div>
</header>
<div class="indexMain">
    <div class="indexMain_left">
        <div class="tzCon">
            <div class="tzCon_head">
                <div class="tzCon_head_left"></div>
                <div class="tzCon_head_right">
                    <h1>${mainPostList.mainPostTitle}</h1>
                    <ul>
                        <li>${mainPostList.userID}</li>
                        <li>1天前</li>
                        <li>21</li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div class="tzCon_con">
               ${mainPostList.mainPostBadCount}
            </div>
            <div class="tzCon_foot">
                <div class="tzCollect">
                    <div class="tzCollect_left">收藏</div>
                    <div class="tzCollect_right">131</div>
                </div>
            </div>
        </div>
        <div class="newPending">
            <div class="newPending_head">
                <div class="tzHeng"></div>
                <div class="newPending_head_tittle">最新评论(52)</div>
            </div>
            <!--楼主可以删除评论、自己可以删除自己的评论删除按钮酌情出现-->
            <div class="newPending_son">
                <div class="pendPic"></div>
                <div class="pendDetail">
                    <div class="pendDetail_head">
                        <p>花开花落 <span>1天前</span></p>
                        <i>2楼</i>
                    </div>
                    <div class="pendDetail_con">
                        <p>测试一下图片,4文档和3文档差别很大测试一下图片,4文档和3文档差别很大</p>
                    </div>
                    <div class="pendDetail_btn">
                        <ul>
                            <li>361</li>
                            <li class="replayBtn">278</li>
                            <li class="delateBtn">删除</li>
                        </ul>
                    </div>
                    <div class="pendDetail_action">
                        <input type="text" value="回复XXX:"/>
                        <button>评论</button>
                        <button>取消</button>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <!--回复后的情况-->
            <div class="newPending_son">
                <div class="pendPic"></div>
                <div class="pendDetail">
                    <div class="pendDetail_head">
                        <p>花开花落 <span>1天前</span></p>
                        <i>2楼</i>
                    </div>
                    <div class="pendDetail_con">
                        <p>测试一下图片,4文档和3文档差别很大测试一下图片,4文档和3文档差别很大</p>
                    </div>
                    <div class="pendDetail_replayCon">
                        <p>回复桃花朵朵开：确实，正确的。</p>
                    </div>
                    <div class="pendDetail_btn">
                        <ul>
                            <li>361</li>
                            <li class="delateBtn">删除</li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <!--测试内容-->
            <div class="newPending_son">
                <div class="pendPic"></div>
                <div class="pendDetail">
                    <div class="pendDetail_head">
                        <p>花开花落 <span>1天前</span></p>
                        <i>2楼</i>
                    </div>
                    <div class="pendDetail_con">
                        <p>测试一下图片,4文档和3文档差别很大测试一下图片,4文档和3文档差别很大</p>
                    </div>
                    <div class="pendDetail_btn">
                        <ul>
                            <li>361</li>
                            <li class="replayBtn">278</li>
                            <li class="delateBtn">删除</li>
                        </ul>
                    </div>
                    <div class="pendDetail_action">
                        <input type="text" value="回复XXX:"/>
                        <button>评论</button>
                        <button>取消</button>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="newPending_son">
                <div class="pendPic"></div>
                <div class="pendDetail">
                    <div class="pendDetail_head">
                        <p>花开花落 <span>1天前</span></p>
                        <i>2楼</i>
                    </div>
                    <div class="pendDetail_con">
                        <p>测试一下图片,4文档和3文档差别很大测试一下图片,4文档和3文档差别很大</p>
                    </div>
                    <div class="pendDetail_btn">
                        <ul>
                            <li>361</li>
                            <li class="replayBtn">278</li>
                            <li class="delateBtn">删除</li>
                        </ul>
                    </div>
                    <div class="pendDetail_action">
                        <input type="text" value="回复XXX:"/>
                        <button>评论</button>
                        <button>取消</button>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="newPending_son">
                <div class="pendPic"></div>
                <div class="pendDetail">
                    <div class="pendDetail_head">
                        <p>花开花落 <span>1天前</span></p>
                        <i>2楼</i>
                    </div>
                    <div class="pendDetail_con">
                        <p>测试一下图片,4文档和3文档差别很大测试一下图片,4文档和3文档差别很大</p>
                    </div>
                    <div class="pendDetail_btn">
                        <ul>
                            <li>361</li>
                            <li class="replayBtn">278</li>
                            <li class="delateBtn">删除</li>
                        </ul>
                    </div>
                    <div class="pendDetail_action">
                        <input type="text" value="回复XXX:"/>
                        <button>评论</button>
                        <button>取消</button>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="newPending_son">
                <div class="pendPic"></div>
                <div class="pendDetail">
                    <div class="pendDetail_head">
                        <p>花开花落 <span>1天前</span></p>
                        <i>2楼</i>
                    </div>
                    <div class="pendDetail_con">
                        <p>测试一下图片,4文档和3文档差别很大测试一下图片,4文档和3文档差别很大</p>
                    </div>
                    <div class="pendDetail_btn">
                        <ul>
                            <li>361</li>
                            <li class="replayBtn">278</li>
                            <li class="delateBtn">删除</li>
                        </ul>
                    </div>
                    <div class="pendDetail_action">
                        <input type="text" value="回复XXX:"/>
                        <button>评论</button>
                        <button>取消</button>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <!--测试内容结束、十条内容分页-->
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
        <div class="writePending">
            <div class="newPending_head">
                <div class="tzHeng"></div>
                <div class="newPending_head_tittle">评论</div>
            </div>
            <div class="writePending_con">
                <input type="text" placeholder="写下你的评论..."/>
                <input type="submit" value="评论"/>
            </div>
        </div>
    </div>
    <div class="indexMain_right">
        <a href="${pageContext.request.contextPath }/bbs_front/newMainPost.jsp" class="newMsg">发新帖</a>
        <div class="myMsg">
            <div class="myMsg_con">
                <div class="myMsg_conPic"></div>
                <p>花开花落</p>
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
                    <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                    <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                    <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                    <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                    <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
                    <li><a href="">关注上海车牌竞拍方面的资讯</a><span>29</span></li>
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
    <p>Copyrigh &copy; 2017-2018 PaiWang 上海钦合投资管理有限公司版权所有 沪ICP备16032224号-2</p>
</footer>
</body>
</html>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/tiezi.js"></script>
<script>

</script>