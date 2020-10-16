<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.cleancoder.dto.Board" %>
<c:set var = "pageName" value = "게시물 상세보기"/>
<%@ include file = "../part/head.jspf" %>
		
		<section class = "con"> 
				번호 :  ${board.bno}
				제목 :  ${board.title}
				내용 :  ${board.content}
				조회수 :  ${board.hit}
	    </section>

		<div class = "btns con">
			<a href = "./list">게시물 리스트</a>
			<a href = "./add">게시물 추가</a>
			<a href = "./modify?bno=${board.bno}">게시물 수정</a>
			<a onclick = "if(confirm('삭제 하시겠습니까?') == false) return false"; href = "./doDelete?bno=${board.bno}">게시물 삭제</a>
		</div>

<%@ include file = "../part/foot.jspf" %>