<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.cleancoder.dto.Board" %>
<c:set var = "pageName" value = "게시물 목록" />
<%@ include file = "../part/head.jspf" %>

		<h2 class = "con">전체 게시물 개수 : ${totalCount}</h2>
		<div class = "con">
        <form id = "search" action = "/board/list" method = "get">
		<select name='type'>
					<option value=""
								<c:out value= "${Criteria.type == null ? 'selected' : ''}"/>>--</option>
					<option value="T"
								<c:out value= "${Criteria.type eq 'T' ? 'selected' : ''}"/>>제목</option>
					<option value="C"
								<c:out value="${Criteria.type eq 'C' ? 'selected': ''}"/>>내용</option>
					<option value="TC"
								<c:out value="${Criteria.type eq 'TC' ? 'selected' : ''}"/>>제목 or 내용</option>
		</select> <input type='text' name='keyword' value='<c:out value="${Criteria.keyword}"/>' />
					<button>검색</button>
	    </form>
		</div>
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
