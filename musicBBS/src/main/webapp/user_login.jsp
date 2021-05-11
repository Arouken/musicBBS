<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/layui-v2.6.1/layui/css/layui.css">
        <style type="text/css">
      		.container{
      			width: 420px;
      			height: 320px;
		 		 min-height: 320px;  
		 		 max-height: 320px;  
		 		 position: absolute;   
		 		 top: 0;  
		 		 left: 0;  
		 		 bottom: 0;  
		 		 right: 0;  
		 		 margin: auto;  
		 		 padding: 20px;  
		 		 z-index: 130;  
		 		 border-radius: 8px;  
		 		 background-color: #fff;  
		 		 box-shadow: 0 3px 18px rgba(100, 0, 0, .5); 
		 		 font-size: 16px;
      		}
      		.close{
      			background-color: white;
      			border: none;
      			font-size: 18px;
      			margin-left: 410px;
      			margin-top: -10px;
      		}
 
        	.layui-input{
        		border-radius: 5px;
        		width: 300px;
        		height: 40px;
        		font-size: 15px;
        	}
        	.layui-form-item{
        		margin-left: -20px;
        	}
			#logoid{ 
				margin-top: -16px;
		 		 padding-left:150px; 
		 		 padding-bottom: 15px;
			}
			.layui-btn{
				margin-left: -50px;
				border-radius: 5px;
        		width: 350px;
        		height: 40px;
        		font-size: 15px;
			}
			.verity{
				width: 120px;
			}
			.font-set{
				font-size: 13px;
				text-decoration: none; 
				margin-left: 60px;
			}
			a:hover{
			 text-decoration: underline; 
			}
			.invalid:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
            color: red;
            opacity: 1;
        }
        .invalid::-moz-placeholder { /* Mozilla Firefox 19+ */
            color: red;
            opacity: 1;
        }
        input.invalid:-ms-input-placeholder{
            color: red;
        }
        input.invalid::-webkit-input-placeholder {
            color: red;
        }
        
       
        </style>
    </head>
    <body>
    	<form class="layui-form" action="${pageContext.request.contextPath}/user/login" method="post" id="userLoginFrom" >
    		<div class="container" style>
    			
    			<div class="layui-form-mid layui-word-aux">
    							
    			</div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">用户ID</label>
			    <div class="layui-input-block">
			      <input type="text" name="userID" id="userID" required  onkeyup="idIsExist()"
			      lay-verify="required" placeholder="请输入用户ID" autocomplete="off" class="layui-input">
			      <span id="userID_mess"></span> 
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">密 &nbsp;&nbsp;码</label>
			    <div class="layui-input-block">
			      <input type="password" name="password" id="password" required lay-verify="required" 
			      placeholder="请输入密码" autocomplete="off" class="layui-input" onkeyup="passIsNull()">
			      <span id="password_mess"></span> 
			    </div>
<!-- 			    <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			  </div>
			   <div class="layui-form-item">
			    <label class="layui-form-label">验证码</label>
			    <div class="layui-input-inline">
			      <input type="text" name="imgCode" id="imgCode" required  lay-verify="required" 
			      placeholder="请输入验证码" autocomplete="off" class="layui-input verity">	
			      <span id="imgCode_mess"></span> 		      
			    </div>
			    
			    <div class="layui-form-mid layui-word-aux"style="padding-left:4px;">
			      <!-- 图形验证码图片, src属性直接访问后台的servlet映射路径即可   -->
                <img id="loginImg" src="${pageContext.request.contextPath }/authImage/imgCode" style="width:100%;">
			    </div> 			      
			  </div>
			  
<!-- 			  <div class="layui-form-item">
				    <label class="layui-form-label">记住密码</label>
				    <div class="layui-input-block">
				      <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
				    </div>
			  </div> -->
 
			  <div class="layui-form-item">
			   <div class="layui-input-block">
			      <span id="msg" style="color: red;font-size: 12px;margin-left: 20px;"></span>
			    </div>
			    <div class="layui-input-block">
			      <button class="layui-btn layui-btn-normal" id="login">登陆</button>	     
			    </div>
			  </div>
			   <a href="" class="font-set">忘记密码?</a>
			   <a href="user_login_phone.jsp" class="font-set">手机登陆</a>  
			   <a href="user_regist.jsp" class="font-set">立即注册</a>
			</div>
		</form>
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
		<script>
			layui.use(['form', 'layedit', 'laydate'], function(){
			  var form = layui.form
			  ,layer = layui.layer
			  ,layedit = layui.layedit
			  ,laydate = layui.laydate;
			  
			  //日期
			 /* laydate.render({
			    elem: '#date'
			  });
			  laydate.render({
			    elem: '#date1'
			  });
			  
			  //创建一个编辑器
			  var editIndex = layedit.build('LAY_demo_editor');
			 
			  //自定义验证规则
			  form.verify({
			    title: function(value){
			      if(value.length < 5){
			        return '标题至少得5个字符啊';
			      }
			    }
			    ,pass: [
			      /^[\S]{6,12}$/
			      ,'密码必须6到12位，且不能出现空格'
			    ]
			    ,content: function(value){
			      layedit.sync(editIndex);
			    }
			  });
			  
			  //监听指定开关
			  form.on('switch(switchTest)', function(data){
			    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
			      offset: '6px'
			    });
			    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
			  });*/
			  
			  //监听提交
			  form.on('submit(demo1)', function(data){
			    layer.alert(JSON.stringify(data.field), {
			      title: '最终的提交信息'
			    })
			    return false;
			  });
			 	  
			});
			
			//1.点击图片改变验证码
			$("#loginImg").click(function(){
				//再次访问图片的servlet映射路径即可：也就是改变图片的src属性值
				//为了让后台服务器认为每次都是一个新的请求，需要设置一个参数在请求中
				this.src="${pageContext.request.contextPath }/authImage/imgCode?date="+new Date();
			})
			
			//2.账号验证
			function idIsExist(){
				//清空错误提示
				$("#userID_mess").html("");
				//手机号码非空
				var userID=$("#userID").val();//账号
			    if($.trim(userID).length==0){
					$("#userID_mess").html("账号不能为空！").css("color","red");
					return;
				}

				//验证账号是否被注册过
				//超链接  表单  提交数据最终都需要刷新整个页面。
				//但是我们验证账号的时候需要的是局部刷新技术:ajax
				$.ajax({
					url:"${pageContext.request.contextPath }/user/idIsExist",  //请求的目标地址路径：目标servlet的映射路径以及对应的增删改查的方法
					type:"post",  //请求后台的方式：get/post
					dataType:"text",//服务器响应给客户端的数据类型：html  xml  json  text
					data:"userID="+userID,//请求中携带的参数：账号
					success:function(obj){//根据服务器响应的参数进行处理：成功的回调函数
						//obj是ok或者是no
						console.log(obj);
						if(obj=="ok"){
							//提示可以注册
							$("#userID_mess").html("该账号不存在,可选择注册").css("color","red");
							 document.getElementById("login").disabled = true; 
						}else{
							//已经注册
							$("#userID_mess").html("");
							document.getElementById("login").disabled = false; 
						}
					}
				})			
			}
			
			
			function passIsNull(){
				var pw=$("#password").val();
			    $("#password_mess").html("");
			    if($.trim(pw).length==0)
			    {
		           $("#password_mess").html("密码不能为空").css("color","red");		          
		        }
			    
			}
			
			
			
			$("#imgCode").blur(function(){
				$("#imgCode_mess").html("");			
				var imgcode=$("#imgCode").val();
			        if($.trim(imgcode).length==0){
			        	$("#imgCode_mess").html("验证码不能为空").css("color","red");			        	
			        	}
			    	});
			
		
		    //2.点击登录
			$("#login").click(function(){
				
				
				var userID=$("#userID").val();//账号
			    if($.trim(userID).length==0){
					$("#userID_mess").html("账号不能为空！").css("color","red");
					return false;
				}
				
			    var pw=$("#password").val();
			    $("#password_mess").html("");
			    if($.trim(pw).length==0)
			    {
		           $("#password_mess").html("密码不能为空").css("color","red");	
		           return false;
		        }
				
			    var imgcode=$("#imgCode").val();
		        if($.trim(imgcode).length==0){
		        	$("#imgCode_mess").html("验证码不能为空").css("color","red");
		        	return false;
		        	}
		    
				
				
				var code=$("#imgCode").val();	
				//验证码是否正确：ajax		
				$.ajax({
					url:"${pageContext.request.contextPath }/user/checkImgCode",
					type:"post",
					dataType:"text",
					async:false,
					data:"code="+code,
					success:function(obj){
						if(obj=="ok"){
							//验证码正确，提交表单根据账号密码验证登录
							$("#userLoginFrom").submit();		
						}else{
							//验证码错误
							$("#imgCode_mess").html("验证码错误").css("color","red");
							return false;
						}
					}			
				})	
				return false;
			})
			</script>
    </body>
</html>