<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui-v2.6.1/layui/css/layui.css">
</head>
<body>
<div>
<form class="layui-form" action="" method="post" enctype="multipart/form-data" lay-filter="user-edit">
  <div class="layui-form-item" style="margin-top:15px;width:500px;">
      <label class="layui-form-label">头像</label>
      <div class="layui-upload">
      <div class="layui-upload-list">
      <div class="upload-img"></div>
            <p id="demoText"></p>
		    <button type="button" class="layui-btn layui-btn-img"  id="test1">上传头像</button>
        </div> 
    </div>
    </div>
  <div class="layui-form-item" style="margin-top:15px;width:500px;">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="userName" lay-verify="userName" autocomplete="off" placeholder="请输入用户名" class="layui-input" value="">
    </div>
  </div>
  <div class="layui-form-item" style="margin-top:15px;width:500px;">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input type="password" name="password" lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input" value="">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">单选框</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男" checked="">
      <input type="radio" name="sex" value="女" title="女">
<!--       <input type="radio" name="sex" value="禁" title="禁用" disabled=""> -->
    </div>
  </div>
    <div class="layui-form-item" style="margin-top:15px;width:500px;">
      <label class="layui-form-label">手机号</label>
      <div class="layui-input-block">
        <input type="tel" name="phone" lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off" class="layui-input" value="">
      </div>
    </div>
    <div class="layui-form-item" style="margin-top:15px;width:500px;">
      <label class="layui-form-label">邮箱</label>
      <div class="layui-input-block">
        <input type="email" name="phone" lay-verify="required|email" placeholder="请输入邮箱" autocomplete="off" class="layui-input" value="">
      </div>
    </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
</div>
<script src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
  form.val('user-edit', {   
    "gender":'${user.gender}'
  });
  //自定义验证规则
  form.verify({
    userName: function(value){
      if(value.length < 3){
        return '用户名至少得3个字符';
      }
      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
      return '用户名不能有特殊字符';
    }
    }
    ,password:[/(.+){6,12}$/, '密码必须6到12位']
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
    return false;
  });
});
 
layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  //普通图片上传
  var uploadInst = upload.render({
    elem: '#test1'
    ,method:'post'
    ,url: '${pageContext.request.contextPath}/user/uploadPhoto'    
    ,done: function(res){
      //如果上传失败
      if(res.code > 0){
        return layer.msg('上传失败');
      }
      //上传成功
      if(res.code==0){
        $('.upload-img').html('<img class="layui-upload-img" style="width:80px;height:100px" src="'+res.src+'" id="demo1"> <p id="demoText"></p>');
        $('.layui-btn-img').css({"margin-left":"104px","width":"90px","margin-top":"6px"});
        $('.layui-btn-img').text("重新上传");      
        return layer.msg('上传成功',{time:700});
      }
    }
  }); 
 });
</script>
</body>
</html>