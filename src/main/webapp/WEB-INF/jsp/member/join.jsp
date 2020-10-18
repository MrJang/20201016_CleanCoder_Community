<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var = "pageName" value = "회원가입" />
<%@ include file = "../part/head.jspf" %>
		
		<script>
		 function submitJoinForm(form){
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

			form.userPwConfirm.value = form.userPwConfirm.value.trim();

			if(form.userPwConfirm.value.length == 0){
				alert('PW 확인을 입력해주세요.');
				form.userPwConfirm.focus();
				
				return false;
			}

			if(form.userPwConfirm.value !=  form.userPw.value){
				alert('PW가 일치 하지안습니다.');
				form.userPwConfirm.focus();

				return false;
			}
			
			form.userName.value = form.userName.value.trim();

			if(form.userName.value.length == 0){
				alert('이름을 입력해주세요.');
				form.userName.focus();
				
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
					PW확인
				</span>
				<div>
					<input name = "userPwConfirm" type = "password" placeholder = "PW확인" autofocus = "autofocus" maxlength = "30">
				</div>
			</div>
			
			<div>
				<span>
					이름
				</span>
				<div>
					<input name = "userName" type = "text" placeholder = "이름" autofocus = "autofocus" maxlength = "30">
				</div>
			</div>
			<div>
				<span>
					가입
				</span>
				<div>
					<input name = "userType" type = "hidden" value = "N" >
					<input type = "submit" value = "가입"> <input type = "reset" value = "취소" onclick = "history.back();">
				</div>
			</div>
		</form>
<%@ include file = "../part/foot.jspf" %>
