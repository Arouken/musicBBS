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
      			height: 420px;
		 		 min-height: 380px;  
		 		 max-height: 380px;  
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
        
        <script type="text/javascript">
//读秒的方法
var iTime = 59;
var Account;
function RemainTime(){
	document.getElementById('getPhoneCode').disabled = true;
	var iSecond,sSecond="",sTime="";
	if (iTime >= 0){
		iSecond = parseInt(iTime%60);
		iMinute = parseInt(iTime/60)
		if (iSecond >= 0){
			if(iMinute>0){
				sSecond = iMinute + "分" + iSecond + "秒";
			}else{
				sSecond = iSecond + "秒";
			}
		}
		sTime=sSecond;
		if(iTime==0){
			clearTimeout(Account);
			sTime='获取手机验证码';
			iTime = 59;
			document.getElementById('getPhoneCode').disabled = false;
		}else{
			Account = setTimeout("RemainTime()",1000);
			iTime=iTime-1;
		}
	}else{
		sTime='没有倒计时';
	}
	document.getElementById('getPhoneCode').value = sTime;
}
</script>
        
    </head>
    <body>
    	<form class="layui-form" action="${pageContext.request.contextPath}/user/updatePasswordByPhone" method="post" id="userForgetPd" >
    		<div class="container" >
    			
    			<div class="layui-form-mid layui-word-aux">
    							
    			</div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">手  机  号</label>
			    <div class="layui-input-block">
			      <input type="text" name="phone" id="phone" 
			       placeholder="请输入手机号" autocomplete="off" onkeyup="clealMess()" class="layui-input">			    
			      <span id="msg" style="color: red;font-size: 12px;margin-left: 20px;"></span> 
			    </div>
			  </div>
			  
			   <div class="layui-form-item">
			    <label class="layui-form-label">验  证  码</label>
			    <div class="layui-input-inline">
			      <input type="text" placeholder="请输入验证码" onkeyup="clealCodeMess()" name="phoneCode" id="phoneCode" autocomplete="off" class="layui-input verity">	
			      <span id="imgCode_mess"></span> 		      
			    </div>
			    
			  	<div class="layui-form-inline">
			      <input type="button" class="layui-btn layui-btn-normal" id="getPhoneCode"  style="width:34%" value=" 获取手机验证码 ">	     
			    </div>		      
			  </div>
			  
			  <div class="layui-form-item">
			    <label class="layui-form-label">新  密  码</label>
			    <div class="layui-input-block">
			      <input type="text" name="newPassword" id="newPassword" 
			       placeholder="请输入新密码" autocomplete="off" onkeyup="clealMess()" class="layui-input">
			    
			      <span id="newPassword_msg" style="color: red;font-size: 12px;margin-left: 20px;"></span> 
			    </div>
			  </div>
			  
			  <div class="layui-form-item">
			    <label class="layui-form-label">再次输入</label>
			    <div class="layui-input-block">
			      <input type="text" name="newPasswordSe" id="newPasswordSe" 
			       placeholder="请再次输入新密码" autocomplete="off" onkeyup="passwordSame()" class="layui-input">			    
			      <span id="newSePassword_mess" style="color: red;font-size: 12px;margin-left: 20px;"></span> 
			    </div>		    
			  </div>

			  <div class="layui-form-item">			 
<!-- 			      <span id="msg" style="color: red;font-size: 12px;margin-left: 20px;"></span>		  -->
			    <div class="layui-input-block">
			      <button class="layui-btn layui-btn-normal" id="updatePassword">提交修改</button>	     
			    </div>
			  </div>
			   <a href="user_forget_pd.jsp" class="font-set">忘记密码?</a>
			   <a href="user_login.jsp" class="font-set">密码登陆</a>  
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
			
			//清除错误提示
			function clealMess(){
				
				$("#msg").html("");
			}
			//清除错误提示
			function clealCodeMess(){
				
				$("#imgCode_mess").html("");
			}

			
			$("#getPhoneCode").click(function(){
				$("#msg").html("");
				//获取输入的手机号
				var phone=$("#phone").val();
				//手机号不能为空
				if($.trim(phone).length==0){
					$("#msg").html("手机号码不能为空！");
					return false;
				}
				//手机号码格式正确
				var reg=/^1[0-9]{10}$/;
				if(!reg.test(phone)){
					$("#msg").html("请输入正确的手机号！");
					return false;
				}
				
				//验证手机是否已经注册过：ajax
				$.ajax({
					url:"${pageContext.request.contextPath}/user/phoneIsExit",
					type:"post",
					dataType:"text",
					data:"phone="+phone,
					success:function(obj){
						if(obj=="no"){//手机号码没有注册
							$("#msg").html("该手机号码没有绑定！");
							return false;
						}else{//手机号已经注册
							//开启倒计时
							RemainTime();
							//发送验证码到手机上：ajax请求访问后台
							sendCode(phone);
						}
					}
				})
				
			})
			
			//封装发送验证码js方法
			function sendCode(phone){
				//ajax请求后台发送验证码
				$.ajax({
					url:"${pageContext.request.contextPath}/user/getPhoneCode",
					type:"post",
					dataType:"text",
					data:"phone="+phone,
					success:function(obj){
						console.log(obj);
					}
				})
			}
			
			//判断两次密码是否一致
			function passwordSame() {
				var password = document.getElementById("newPassword").value;
				var repassword = document.getElementById("newPasswordSe").value;
				if (password == repassword) {
					$("#newSePassword_mess").html("").css("color", "green");
					document.getElementById("updatePassword").disabled = false;

				} else {
					$("#newSePassword_mess").html("两次输入的密码不一致").css("color", "red");
					document.getElementById("updatePassword").disabled = true;
				}
			}

			//2.点击修改密码
			$("#updatePassword").click(function(){
				//获取输入的密码
				var newPassword=$("#newPassword").val();
				//密码不能为空
				if($.trim(newPassword).length==0){
					$("#newPassword_msg").html("密码不能为空！");
					return false;
				}
				
				//获取输入确认密码
				var newPassword=$("#newPasswordSe").val();
				//确认密码不能为空
				if($.trim(newPassword).length==0){
					$("#newSePassword_mess").html("确认密码不能为空！");
					return false;
				}
				
				var phone=$("#phone").val();
				var phoneCode=$("#phoneCode").val();	
				//验证码是否正确：ajax		
				$.ajax({
					url:"${pageContext.request.contextPath }/user/checkPhoneCode",
					type:"post",
					dataType:"text",
					async:false,
					data:{'phone':phone,'phoneCode':phoneCode},
					success:function(obj){
						if(obj=="ok"){
							//验证码正确，提交表单根据账号密码验证登录
							$("#userForgetPd").submit();
							alert("修改成功!请点击确认，返回登录界面");
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