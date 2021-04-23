<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <div style="margin: 50px auto">
        <form action="${pageContext.request.contextPath}/user/uploadPhoto" method="post"  enctype="multipart/form-data">
         
            图片：<input type="file" name="photo"><br/>
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
