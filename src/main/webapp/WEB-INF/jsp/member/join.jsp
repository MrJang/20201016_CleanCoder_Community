<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var = "pageName" value = "회원가입" />
<%@ include file = "../part/head.jspf" %>
		
		<script>
		 function submitJoinForm(form){
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

			form.pwConfirm.value = form.pwConfirm.value.trim();

			if(form.pwConfirm.value.length == 0){
				alert('PW 확인을 입력해주세요.');
				form.pwConfirm.focus();
				
				return false;
			}

			if(form.pwConfirm.value !=  form.pw.value){
				alert('PW가 일치 하지안습니다.');
				form.pwConfirm.focus();

				return false;
			}
			
			form.name.value = form.name.value.trim();

			if(form.name.value.length == 0){
				alert('이름을 입력해주세요.');
				form.name.focus();
				
				return false;
			}

			
			form.submit();
		}
		</script>
		<form class = "con common-form" action = "./doJoin" method = "POST" onsubmit = "submitJoinForm(this); return false;">
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
					PW확인
				</span>
				<div>
					<input name = "pwConfirm" type = "password" placeholder = "PW확인" autofocus = "autofocus" maxlength = "30">
				</div>
			</div>
			
			<div>
				<span>
					이름
				</span>
				<div>
					<input name = "name" type = "text" placeholder = "이름" autofocus = "autofocus" maxlength = "30">
				</div>
			</div>
			<div>
				<span>
					가입
				</span>
				<div>
					<input name = "usertype" type = "hidden" value = "N" >
					<input type = "submit" value = "가입"> <input type = "reset" value = "취소" onclick = "history.back();">
				</div>
			</div>
		</form>
<%@ include file = "../part/foot.jspf" %>
