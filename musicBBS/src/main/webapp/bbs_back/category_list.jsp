<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>分区列表</title>
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
								<option value="0" selected="true">分区ID</option>
								<option value="1">分区名</option>
								<option value="2">分区简介</option>
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
	<table class="layui-hide" id="categoryList" lay-filter="test"></table>
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
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
										elem : '#categoryList',
										url : '/musicBBS/Category/getBackCategoryList',
										toolbar : '#toolbarDemo',//开启头部工具栏，并为其绑定左侧模板

										defaultToolbar : [ 'filter', 'exports',
												'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
													title : '提示',
													layEvent : 'LAYTABLE_TIPS',
													icon : 'layui-icon-tips'
												} ],
										title : '分区数据表',
										cols : [ [//表头
												{
													type : 'checkbox',
													fixed : 'left'
												},
												{
													field : 'categoryID',
													title : '分区ID',
													width : 90,
													fixed : 'left',
													unresize : true,
													sort : true
												},
												{
													field : 'categoryName',
													title : '分区名',
													width : 100,
													edit : 'text'
												},
												{
													field : 'userID',
													title : '创建用户',
													width : 100
												},
												{
													field : 'categoryTxt',
													title : '分区简介',
													width : 160
												}
											
												,
												{
													field : 'categoryCreatDay',
													title : '创建时间',
													width : 120,
													sort : true,
													templet : '<div>{{ Format(d.categoryCreatDay,"yyyy-MM-dd")}}</div>'
												}											
												
												,
												{
													field : 'categoryImg',
													title : '分区图片',
													width : 120,
													templet : '<div><img src="/categoryImg/{{d.categoryImg}}"></div>'
												}
												,{field:'lock', title:'分区锁定', width:110, templet: '#checkboxTpl', unresize: true}
												,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:200} 
												
										] ],
										page : true,
									
									//开启分页
									});
									 //头工具栏事件
									  table.on('toolbar(test)', function(obj){
									    var checkStatus = table.checkStatus(obj.config.id);
									    switch(obj.event){
									      case 'getCheckData':
									        var data = checkStatus.data;
									        layer.alert(JSON.stringify(data));
									      break;
									      case 'getCheckLength':
									        var data = checkStatus.data;
									        layer.msg('选中了：'+ data.length + ' 个');
									      break;
									      case 'isAll':
									        layer.msg(checkStatus.isAll ? '全选': '未全选');
									      break;
									      
									      //自定义头工具栏右侧图标 - 提示
									      case 'LAYTABLE_TIPS':
									        layer.alert('这是工具栏右侧自定义的一个图标按钮');
									      break;
									    };
									  });
									  
									  //监听行工具事件
									  table.on('tool(test)', function(obj){
									    var data = obj.data;
									    //console.log(obj)
									    if(obj.event === 'del'){
									      layer.confirm('真的删除行么', function(index){
									        obj.del();
									        layer.close(index);
									      });
									    } else if(obj.event === 'edit'){
									      layer.prompt({
									        formType: 2
									        ,value: data.email
									      }, function(value, index){
									        obj.update({
									          email: value
									        });
									        layer.close(index);
									      });
									    }
									  });
						});
						
						
	</script>

</body>
</html>