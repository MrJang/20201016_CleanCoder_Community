<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.cleancoder.dto.Board" %>
<c:set var = "pageName" value = "게시물 수정"/>
<%@ include file = "../part/head.jspf" %>
		
		<script>
		 function submitModifyForm(form){
			form.title.value = form.title.value.trim();

			if(form.title.value.length == 0){
				alert('제목을 입력해주세요.');
				form.title.focus();
				
				return false;
			}

			form.content.value = form.content.value.trim();

			if(form.content.value.length == 0){
				alert('내용을 입력해주세요.');
				form.content.focus();
				
				return false;
			}
			form.submit();
		}
		</script>
		<form class = "con common-form" action = "/board/doModify" method = "POST" onsubmit = "submitModifyForm(this); return false;">
			<input type = "hidden" name = "bno" value = "${board.bno}">
			<div>
				<span>
						제목
				</span>
				<div>
					<input name = "title" type = "text" placeholder = "제목" autofocus = "autofocus" value = "${board.title}">
				</div>
			</div>
			
			<div>
				<span>
						내용
				</span>
				<div>
					<textarea name = "content" placeholder = "내용">${board.content}</textarea>
				</div>
			</div>
			
			<div>
				<span>
						수정
				</span>
				<div>
					<input name = "uno" type = "hidden" value = 1 ><!-- 나중에 회원번호로 대치 -->
					<input type = "submit" value = "수정"> <input type = "reset" value = "취소" onclick = "history.back();">
				</div>
			</div>
		</form>
		
<%@ include file = "../part/foot.jspf" %>