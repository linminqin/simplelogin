<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<script src="${ctx }/script/jquery.min.js" type="text/javascript"></script>
		<style type="text/css">
			body {
				width: 100%;
    			height: 100%;
    			overflow:hidden;
			}
			.content {
				width: 300px;
			    margin-left: auto;
			    margin-right: auto;
				line-height: 30px;
				position: relative;
				top: 200px;
			}
		</style>
	</head>
	<body>
		<div class="content" >
				欢迎您：${sessionScope.loginName }
		</div>
	</body>
</html>