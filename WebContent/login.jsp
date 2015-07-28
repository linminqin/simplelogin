<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登陆</title>
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
			.inputLabel {
				width: 70px; 
				display: inline-block;
				text-align: right;
			}
			.errorDiv {
				color: #ff0000;
				display: block;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<form id="loginForm" action="login.action" method="post">
			<div class="content" >
				<div class="errorDiv">
				</div>
				<div class="inputDiv">
					<span class="inputLabel">用户名：</span>
					<input type="text" name="loginName" 
						<c:if test="${not empty param.loginName }"> value="${param.loginName}"</c:if>
					/>
				</div>
				<div>
					<span class="inputLabel">密码：</span>
					<input type="text" name="password" />
				</div>
				<div class="buttonDiv">
					<span class="inputLabel">&nbsp;</span> <button type="button" onclick="login()">提交</button>
				</div>
			</div>
		</form>
	</body>
	<script type="text/javascript">
		function login() {
			var loginName = $('input[name="loginName"]').val();
			var password = $('input[name="password"]').val();
			if(loginName == '') {
				alert('请输入用户名!');
				focusInput('loginName');
				return;
			}
			if(!checkInput(loginName)) {
				alert('用户名格式错误!');
				focusInput('loginName');
				return;
			}
			if(password == '') {
				alert('请输入密码!');
				focusInput('password');
				return;
			}
			if(!checkInput(password)) {
				alert('密码格式错误!');
				focusInput('password');
				return;
			}
			$('#loginForm').submit();
		}
		$(document).ready(function(){
			<c:if test="${not empty requestScope.errorInfo }">
				$('.errorDiv').text('${requestScope.errorInfo }');
			</c:if>
		});
		//回车
		$(document).keyup(function(event){
			if(event.keyCode ==13){
				//如果已经有submit按钮，会自动绑定回车事件
				if($("input[type='submit']").length > 0) {
					return;
				}
				if($("#mainForm").length  = 1) {
					login();
				}
			}
		});
		
		function checkInput(value) {
            var regx = /^[A-Za-z0-9]*$/;
            if (regx.test(value)) {
                return true;
            }
            else {
                return false;
            }
        }
		
		function focusInput(inputName) {
			$('input[name="' + inputName + '"]').focus();
        }
	</script>
</html>