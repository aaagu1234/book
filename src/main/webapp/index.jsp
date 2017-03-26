<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ExtJS4.2 Demo 演示</title>
    <meta charset="utf-8" />
    <meta name="description" content="ExtJS4.2Demo、演示" /> 
    <link href="<%=basePath %>static/extjs/resources/ext-theme-neptune/ext-theme-neptune-all.css" rel="stylesheet" />
    <script src="<%=basePath %>static/extjs/bootstrap.js"></script> 
    <script src="<%=basePath %>static/extjs/locale/ext-lang-zh_CN.js"></script> 
   <script src="<%=basePath %>app/app.js"></script>  
</head>

<body class="ak">
<div id="hello"></div>
<script>
 
</script>
</body>

</html>