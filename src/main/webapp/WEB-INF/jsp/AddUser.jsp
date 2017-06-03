<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联系信息</title>

</head>
<body> 
<form id="itemForm" action="${pageContext.request.contextPath }/user/addUser" method="post">
联系信息：
<table width="100%" border=1>
<tr>
	<td>id</td>
	<td><input type="text" name="id"/></td>
</tr>
<tr>
	<td>用户名称</td>
	<td><input type="text" name="name"/></td>
</tr>
<tr>
	<td>地址</td>
	<td><input type="text" name="address"/></td>
</tr>
<tr>
	<td>电子邮箱</td>
	<td><input type="text" name="email"/></td>
</tr>
<tr>
	<td>电话</td>
	<td><input type="text" name="telephone"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>
