<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
 	<c:forEach items="${user}" var="var" varStatus="vs">
 	    ${var.name}
 	</c:forEach>
</body>
</html>
