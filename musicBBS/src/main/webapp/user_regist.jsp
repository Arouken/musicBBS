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
				margin-left: 120px;
			}
			a:hover{
			 text-decoration: underline; 
			}
 
        </style>
    </head>
    <body >
    	<form class="layui-form" action="${pageContext.request.contextPath}/user/regist" method="post">
    		<div class="container">
    			
    			<div style="height:14px">
    							
    			</div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">用 户&nbsp;&nbsp;ID</label>
			    <div class="layui-input-block">
			      <input type="text" name="userID" required  lay-verify="required" placeholder="请输入用户ID" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">密  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
			    <div class="layui-input-inline">
			      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
			    </div>
			    <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">昵  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</label>
			    <div class="layui-input-inline">
			      <input type="text" name="userName" required lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
			    </div>
			    <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			  </div>
			   <div class="layui-form-item">
			    <label class="layui-form-label">确认密码</label>
			    <div class="layui-input-inline">
			      <input type="text" name="title" required  lay-verify="required" placeholder="请再次输入密码" autocomplete="off" class="layui-input verity">
			    </div>
			    <!--<div class="layui-form-mid layui-word-aux">辅助文字</div> -->
			      
			  </div>
			  <!--<div class="layui-form-item">
				    <label class="layui-form-label">记住密码</label>
				    <div class="layui-input-block">
				      <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
				    </div>
			  </div> -->
 
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit" >注册</button>	     
			    </div>
			  </div>
			   <a href="" class="font-set">忘记密码?</a>  <a href="user_login.jsp" class="font-set">立即登陆</a>
			</div>
		</form>
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"></script>
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
			 
			  //表单初始赋值
			 /* form.val('example', {
			    "username": "贤心" // "name": "value"
			    ,"password": "123456"
			    ,"interest": 1
			    ,"like[write]": true //复选框选中状态
			    ,"close": true //开关状态
			    ,"sex": "女"
			    ,"desc": "我爱 layui"
			  })*/
			  
			  
			});
			</script>
    </body>
</html>