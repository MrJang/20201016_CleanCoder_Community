<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var = "pageName" value = "로그인" />

<%@ include file  = "../part/head.jspf" %>

<script>
	function submitLoginForm(form){
		
		form.userId.value = form.userId.value.trim();
		if(form.userId.value.length == 0){
			alert('ID를 입력해주세요.');
			form.userId.focus();

			return false;
		}

		form.userPw.value = form.userPw.value.trim();
		if(form.userPw.value.length == 0){
			alert('PW를 입력해주세요.');
			form.userPw.focus();

			return false;
		}

		form.submit();
	}
</script>

<form class = "con common-form" action = "./doLogin" method = "POST" onsubmit = "submitLoginForm(this); return false;">
	<div>
		<span> 
			ID 
		</span>
		<div>
			<input name = "userId" type = "text" placeholder = "ID" autofocus = "autofocus" maxlength = "30">
		</div>
	</div>
	
	<div>
		<span> 
			PW 
		</span>
		<div>
			<input name = "userPw" type = "password" placeholder = "PW" autofocus = "autofocus" maxlength = "30">
		</div>
	</div>
	
	<div>
		<span> 
			로그인 
		</span>
		<div>
			<input type = "submit" value = "로그인" > <input type = "reset" value = "취소" onclick = "history.back();">
		</div>
	</div>
</form>

<div class = "btns con">
		<a href ="/">메인</a>
		<a href ="/">가입</a>
</div>

<%@ include file = "../part/foot.jspf" %>