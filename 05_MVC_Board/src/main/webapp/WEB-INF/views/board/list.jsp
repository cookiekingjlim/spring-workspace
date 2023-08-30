<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
</head>
<body>
	<div class="container">	
	<h1>List Page</h1>
	
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
				<th>${board.no}</th>
				<th>${board.title}</th>
				<th>${board.writer}</th>
				<th><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<nav aria-labe=Page navigation">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#">1</a>
				</li>
				<li class="page-item"><a class="page-link active" href="#">2</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">3</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">4</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">5</a>
				</li>
			</ul>
		</nav>
	</div>
	
</body>
</html>