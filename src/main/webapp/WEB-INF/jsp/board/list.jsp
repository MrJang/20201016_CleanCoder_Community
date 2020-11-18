<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.cleancoder.dto.Board" %>
<c:set var = "pageName" value = "게시물 목록" />
<%@ include file = "../part/head.jspf" %>

		<h2 class = "con">전체 게시물 개수 : ${totalCount}</h2>
		
		<div class = "con">
			<c:forEach items = "${list}" var = "board">
				<section> 
				<a href = "./detail/${board.bno}">번호 : ${board.bno}, 제목 : ${board.title}, 조회수 : ${board.hit}</a> 
				</section>
				<hr>
			</c:forEach>
		</div>
		
		<div class = "btns con">
			<a href = "./add">[게시물 추가]</a>
		</div>
		
<%@ include file = "../part/foot.jspf" %>
