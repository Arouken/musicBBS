<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆测试</title>
</head>
<body>
<form action="user/login" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="userName" /></td>
		</tr>
		<tr>
			<td>密 码：</td>
			<td><input type="text" name="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="登录" /></td>
			<td></td>
		</tr>
		<tr>
			<td><a href="regist.jsp">注册</a></td>
			<td></td>
		</tr>
	</table>
</form>
</body>
</html>