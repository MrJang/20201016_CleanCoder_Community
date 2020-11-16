<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var = "pageName" value = "로그인" />

<%@ include file  = "../part/head.jspf" %>

<script>
	function submitLoginForm(form){
		
		form.id.value = form.id.value.trim();
		if(form.id.value.length == 0){
			alert('ID를 입력해주세요.');
			form.id.focus();

			return false;
		}

		form.pw.value = form.pw.value.trim();
		if(form.pw.value.length == 0){
			alert('PW를 입력해주세요.');
			form.pw.focus();

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
			<input name = "id" type = "text" placeholder = "ID" autofocus = "autofocus" maxlength = "30">
		</div>
	</div>
	
	<div>
		<span> 
			PW 
		</span>
		<div>
			<input name = "pw" type = "password" placeholder = "PW" autofocus = "autofocus" maxlength = "30">
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
<%@ include file = "../part/foot.jspf" %>