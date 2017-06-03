<pre name="code" class="java"><%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
 "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Spring mvc demo</title>  
</head>  
<body>  
<a href="${pageContext.request.contextPath }/user/add">添加</a>用户列表：
<table width="80%" border=1>
<tr>
  <td>id</td>
  <td>用户名</td>
  <td>电子邮箱</td>
  <td>电话</td>
  <td>地址</td>
  <td>操作</td>
</tr>
<c:forEach items="${list}" var="item">
<tr>
  <td>${item.id}</td>
  <td>${item.name}</td>
  <td>${item.email}</td>
  <td>${item.telephone}</td>
  <td>${item.address}</td>
  <td><a href="${pageContext.request.contextPath }/user/edit?id=${item.id}" rel="external nofollow">修改</a>
  <a href="${pageContext.request.contextPath }/user/deleteByName?id=${item.id}" rel="external nofollow">删除</a>
  </td> 
</tr>
</c:forEach>
</body>  
</html>  