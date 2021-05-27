<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/layui-v2.6.1/layui/css/layui.css"
	charset="utf-8" media="all">


</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"></script>

	<form class="layui-form" action="">
		<div class="layui-row">
			<div class="layui-col-xs3">
				<div class="grid-demo grid-demo-bg1">
					<div class="layui-form-item">
						<label class="layui-form-label">查询字段</label>
						<div class="layui-input-block">
							<select id="userKey" name="userKey" lay-filter="dept">
								<option value="0" selected="true">用户ID</option>
								<option value="1">用户昵称</option>
								<option value="2">电话号码</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="layui-col-xs6">
				<div class="grid-demo grid-demo-bg1">
					<div class="layui-form-item">
						<label class="layui-form-label"></label>
						<div class="layui-input-block">
							<input id="userValue" type="text" name="userValue"
								lay-verify="title" autocomplete="off" placeholder="要查找的内容"
								class="layui-input">
						</div>
					</div>
				</div>
			</div>
			<div class="layui-col-xs3">
				<div class="grid-demo grid-demo-bg1">
					<div class="layui-form-item">
						<button class="layui-btn" data-type="reload" type="button">搜索</button>
					</div>
				</div>
			</div>
		</div>
		
	</form>
	<table class="layui-hide" id="userList" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    
  </div>
</script>
<!-- <button class="layui-btn layui-btn-sm layui-btn-danger  " lay-event="deleteAll">删除全选</button> -->
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

	<script type="text/html" id="switchTpl">
  <!-- 这里的 checked 的状态只是演示 -->
  <input type="checkbox" name="sex" value="{{d.id}}" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo" {{ d.id == 10003 ? 'checked' : '' }}>
</script>

	<script type="text/html" id="checkboxTpl">
  <!-- 这里的 checked 的状态只是演示 -->
  <input type="checkbox" name="lock" value="{{d.id}}" title="锁定" lay-filter="lockDemo" {{ d.id == 10006 ? 'checked' : '' }}>
</script>


	<!--table日期转换格式-->
	<script>
		function Format(datetime, fmt) {
			if (parseInt(datetime) == datetime) {
				if (datetime.length == 10) {
					datetime = parseInt(datetime) * 1000;
				} else if (datetime.length == 13) {
					datetime = parseInt(datetime);
				}
			}
			datetime = new Date(datetime);
			var o = {
				"M+" : datetime.getMonth() + 1, //月份
				"d+" : datetime.getDate(), //日
				"h+" : datetime.getHours(), //小时
				"m+" : datetime.getMinutes(), //分
				"s+" : datetime.getSeconds(), //秒
				//            "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
				"S" : datetime.getMilliseconds()
			//毫秒
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
			return fmt;
		}
	</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js"></script>	
<script type="text/javascript" src="${pageContext.request.contextPath}/layui-v2.6.1/layui/jquery-3.3.1.js"></script>
	<script>								
						layui.use('table',function() {
							var table = layui.table	
							 ,form = layui.form;
									table.render({
										elem : '#userList',
										url : '/musicBBS/user/getUserList',
										toolbar : '#toolbarDemo',//开启头部工具栏，并为其绑定左侧模板

										defaultToolbar : [ 'filter', 'exports',
												'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
													title : '提示',
													layEvent : 'LAYTABLE_TIPS',
													icon : 'layui-icon-tips'
												} ],
										title : '用户数据表',
										cols : [ [//表头
												{
													type : 'checkbox',
													fixed : 'left'
												},
												{
													field : 'userID',
													title : 'ID',
													width : 80,
													fixed : 'left',
													unresize : true,
													sort : true
												},
												{
													field : 'userName',
													title : '用户名',
													width : 120,
													edit : 'text'
												},
												{
													field : 'password',
													title : '密码',
													width : 100
												}
												//    ,{field:'gender', title:'性别', width:85, templet: '#switchTpl', unresize: true}
												,
												{
													field : 'gender',
													title : '性别',
													width : 80,
													edit : 'text',
													sort : true,
													templet : function(d) {
														if (d.gender == 1) {
															return '男'
														} else {
															return '女'
														}
													}
												},
												{
													field : 'competence',
													title : '权限',
													width : 80,
													edit : 'text',
													sort : true,
													templet : function(d) {
														if (d.competence == 0) {
															return '用户'
														} else {
															return '管理员'
														}
													}
												},
												{
													field : 'phoneNum',
													title : '电话号码',
													width : 120
												},
												{
													field : 'createDate',
													title : '注册时间',
													width : 120,
													sort : true,
													templet : '<div>{{ Format(d.createDate,"yyyy-MM-dd")}}</div>'
												}

												,{field:'lock', title:'账号锁定', width:110, templet: '#checkboxTpl', unresize: true}
												,
												{
													field : 'photo',
													title : '头像',
													width : 120,
													templet : '<div><img src="/userPhoto/{{d.photo}}"></div>'
												}
												//        ,{field:'photo',title: '头像',width:120,templet:function(d){  
												//     	   return '<div οnclick="show_img(this)" ><img src="/userPhoto/{{d.photo}}" alt="" width="50px" height="50px"></a></div>';}}
												, {
													fixed : 'right',
													title : '操作',
													toolbar : '#barDemo',
													width : 180
												}
										/* ,{field:'email', title:'邮箱', width:150, edit: 'text', templet: function(res){
										   return '<em>'+ res.email +'</em>'
										 }}
										
										 ,{field:'city', title:'城市', width:100}
										 ,{field:'sign', title:'签名'}
										 ,{field:'ip', title:'IP', width:120}
										 ,{field:'logins', title:'登入次数', width:100, sort: true}
										 */

										] ],
										page : true,
										id: 'userTable'
									//开启分页
									});

							//头工具栏事件
							table.on('toolbar(test)',
									function(obj) {
										var checkStatus = table
												.checkStatus(obj.config.id);
										switch (obj.event) {
										case 'getCheckData':
											var data = checkStatus.data;
											layer.alert(JSON.stringify(data));
											break;
										case 'getCheckLength':
											var data = checkStatus.data;
											layer.msg('选中了：' + data.length
													+ ' 个');
											break;
										case 'isAll':
											layer.msg(checkStatus.isAll ? '全选'
													: '未全选');
											break;
										case 'deleteAll':
											layer.msg(checkStatus.isAll ? '全选'
													: '删除全选');
											break;

										//自定义头工具栏右侧图标 - 提示
										case 'LAYTABLE_TIPS':
											layer.alert('这是工具栏右侧自定义的一个图标按钮');
											break;
										}
										;
									});

							//监听行工具事件
							table.on('tool(test)', function(obj) {
								var data = obj.data;
								//console.log(obj)
								if (obj.event === 'del') {
									layer.confirm('真的删除行么', function(index) {
										$.ajax({
					                        url: "/musicBBS/Admin/deleteUser",
					                        type: "POST",
					                        data: {"userID": data.userID},
					                        dataType: "json",
					                        success: function (data) {
					                          
					                            if (data.result == "1") {
					                                obj.del();
					                                //关闭弹框
					                                layer.close(index);
					                                layer.msg("删除成功", {icon: 6});
					                                $(".layui-laypage-btn").click()
					                            } else {
					                                layer.msg("删除失败", {icon: 5});
					                            }
					                        }
					                    });
									});
								} else if (obj.event === 'edit') {
									layer.open({
					                    type: 2,
					                    closeBtn: 2,
					                    title: '修改用户信息',
					                    area: ['400px', '460px'],
					                    shade: 0.8,
					                    id: (new Date()).valueOf(), //设定一个id，防止重复弹出 时间戳1280977330748
					                    btnAlign: 'r',
					                    moveType: 1, //拖拽模式，0或者1
					                    content: '/musicBBS/Admin/toUpdateUser?userID=' + data.userID + "&password=" + data.password
					                        + "&userName=" + encodeURI(encodeURI(data.userName)) + "&phoneNum=" 
					                        + data.phoneNum + "&gender=" + data.gender+"&competence=" + data.competence
					                });
								}else if(obj.event === 'detail'){
									layer.alert("查看用户 ID: " + data.userID + " 的行");
								}
							});
							
							 var $ = layui.$, active = {
						                reload: function () {
						                    var userValue = $('#userValue').val();//获取输入框的值
						                    var userKey = $('#userKey').val();//获取输入框的值
						                
						                    //执行重载
						                    table.reload('userTable', {
						                        page: {
						                            curr: 1 //重新从第 1 页开始
						                        }
						                        
						                        , url: '${pageContext.request.contextPath}/Admin/findUserBySelect?userKey='+userKey+"&userValue="+userValue//后台做模糊搜索接口路径
						                        , method: 'post'
						                    });
						                }
						            };
							
							 //这个是用于创建点击事件的实例
					        $('.layui-form-item .layui-btn').on('click', function () {
					            var type = $(this).data('type');
					            active[type] ? active[type].call(this) : '';
					        });
							 
					      

							//   table.on('tool(demo)', function (obj) {
							//       var data = obj.data;
							//       if (obj.event === "showPic") {
							//           layer.photos({
							//               photos: '#pic_' + data.id,
							//               //0-6的选择，指定弹出图片动画类型，默认随机
							//               anim: 5
							//           });
							//       }
							//   });

							//监听锁定操作
							 form.on('checkbox(lockDemo)',function(obj){
							    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
							  });

							// //监听性别操作
							//   form.on('switch(sexDemo)', function(obj){
							//     layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
							//   });

						});
						
						 function a() {
						        $(".layui-laypage-btn").click();
						    }
	</script>

</body>
</html>