<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui-v2.6.1/layui/css/layui.css"  charset="utf-8" media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
 
<table class="layui-hide" id="userList" lay-filter="test"></table>
 
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    <button class="layui-btn layui-btn-sm layui-btn-danger  " lay-event="deleteAll">删除全选</button>
  </div>
</script>
 
<script type="text/html" id="barDemo">
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
    function Format(datetime,fmt) {
        if (parseInt(datetime)==datetime) {
            if (datetime.length==10) {
                datetime=parseInt(datetime)*1000;
            } else if(datetime.length==13) {
                datetime=parseInt(datetime);
            }
        }
        datetime=new Date(datetime);
        var o = {
            "M+" : datetime.getMonth()+1,                 //月份
            "d+" : datetime.getDate(),                    //日
            "h+" : datetime.getHours(),                   //小时
            "m+" : datetime.getMinutes(),                 //分
            "s+" : datetime.getSeconds(),                 //秒
//            "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
            "S"  : datetime.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }
</script>

<script src="${pageContext.request.contextPath}/layui-v2.6.1/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 --> 
 
<script>
layui.use('table', function(){
  var table = layui.table;
  table.render({
    elem: '#userList'
    ,url:'/musicBBS/user/getUserList'
    ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
    ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
      title: '提示'
      ,layEvent: 'LAYTABLE_TIPS'
      ,icon: 'layui-icon-tips'
    }]
    ,title: '用户数据表'
    ,cols: [[//表头
      {type: 'checkbox', fixed: 'left'}
      ,{field:'userID', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
      ,{field:'userName', title:'用户名', width:120, edit: 'text'}
      ,{field:'password', title:'密码', width:100}
//    ,{field:'gender', title:'性别', width:85, templet: '#switchTpl', unresize: true}
      ,{field:'gender', title:'性别', width:80, edit: 'text', sort: true,
    	   templet: function(d){if(d.gender == 1){return '男'}else{return '女'}}}
      ,{field:'phoneNum', title:'电话号码', width:120}
      ,{field:'createDate', title:'注册时间', width:120, sort: true,templet:'<div>{{ Format(d.createDate,"yyyy-MM-dd")}}</div>'}
    	
 //    ,{field:'lock', title:'是否锁定', width:110, templet: '#checkboxTpl', unresize: true}
       ,{field:'photo',title: '头像',width:120,templet:'<div><img src="/userPhoto/{{d.photo}}"></div>'}
//        ,{field:'photo',title: '头像',width:120,templet:function(d){  
//     	   return '<div οnclick="show_img(this)" ><img src="/userPhoto/{{d.photo}}" alt="" width="50px" height="50px"></a></div>';}}
       ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
     /* ,{field:'email', title:'邮箱', width:150, edit: 'text', templet: function(res){
        return '<em>'+ res.email +'</em>'
      }}
     
      ,{field:'city', title:'城市', width:100}
      ,{field:'sign', title:'签名'}
      ,{field:'ip', title:'IP', width:120}
      ,{field:'logins', title:'登入次数', width:100, sort: true}
      */
     
    ]]
    ,page: true//开启分页
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

  
// //监听锁定操作
//   form.on('checkbox(lockDemo)', function(obj){
//     layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
//   });
  
// //监听性别操作
//   form.on('switch(sexDemo)', function(obj){
//     layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
//   });
  
});
</script>

</body>
</html>