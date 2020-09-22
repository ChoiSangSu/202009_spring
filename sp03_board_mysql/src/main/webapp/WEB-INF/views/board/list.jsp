<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글조회</title>

<script type="text/javascript">
	//document가 로딩 완료된후 함수 실행
	$(function() {
		//조회버튼
		$('#btnSearch').on('click', function(){
			var findKey = $('#findKey').val();
			var findValue = $('#findValue').val();
			console.log(findKey);
			console.log(findValue);
			$(location).attr('href',
					'${path}/board/list?findKey='+findKey+'&findValue='+findValue);
		});
		//추가 버튼 클릭시
		$('#btnAdd').on('click', function() {
			$(location).attr('href','${path}/board/add');
		});
		//제목을 클릭했을때
		$('.aSubject').on('click', function(e) {
			e.preventDefault(); //기본기능  소멸
			var bnum = $(this).attr('href');
			console.log(bnum);
			$(location).attr('href', '${path}/board/detail?bnum='+bnum);
		});
		
		//페이지를 클릭했을때
		$('.aPage').on('click', function(e) {
			e.preventDefault(); //기본기능  소멸
			var curPage = $(this).attr('href');
			var findKey = $('#findKey').val();
			var findValue = $('#findValue').val();
			
			console.log(curPage);
			$(location).attr('href','${path}/board/list?curPage='+curPage+'&findKey='+findKey+'&findValue='+findValue);
		});
		
		//세션삭제 클릭
		$('#btnSessionDelete').on('click', function() {
			$(location).attr('href','${path}/board/sessionDelete');
		});
		
		
	});

</script>
</head>
<body>
<div class="container">
	<h2><span class="badge badge-secondary">게시글 조회</span></h2>

	<div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<select id ="findKey">
			<option value="writer" <c:out value="${pdto.findKey=='writer'?'selected':''}" />>작성자</option>
			<option value="subject" <c:out value="${pdto.findKey=='subject'?'selected':''}" />>제목</option>
			<option value="content" <c:out value="${pdto.findKey=='content'?'selected':''}" />>내용</option>
			<option value="subcon" <c:out value="${pdto.findKey=='subcon'?'selected':''}" />>제목+내용</option>
		</select>
		<input class="form-control mr-sm-2" placeholder="Search" type="text" id="findValue" value="${pdto.findValue}">
		<input class="btn btn-primary"  id="btnSearch" type="button" value="조회">
		<input class="btn btn-success" id="btnAdd" type="button" value="추가">
		<input id="btnSessionDelete" type="button" value="세션값삭제">
	</nav>

	</div>
	<!-- 리스트 출력 -->
	<div>
		<table class="table table-hover">
			<tr>
				<th>순번</th>
				<th>작성자</th>
				<th>이메일</th>
				<th>제목</th>
				<th>조회수</th>
				<th>댓글수</th>
			</tr>
		
			<c:forEach var="board" items="${blist}">
				<tr>
					<td>${board.bnum}</td>
					<td>${board.writer}</td>
					<td>${board.email}</td>
					<td><a class="aSubject" href="${board.bnum}" >${board.subject}</a></td>
					<td>${board.readcnt}</td>
					<td>${board.replycnt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 페이징 처리 -->
	<%-- ${pdto} --%>
	<div>
		<c:if test="${pdto.startPage!=1}">
			<a class ="aPage" href="${pdto.startPage-1}">이전</a>
		</c:if> 
		<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
			<a class ="aPage" href="${i}"> ${i}</a>
		</c:forEach>
		<c:if test="${pdto.endPage < pdto.totPage}">
			<a class ="aPage" href="${pdto.endPage+1}">다음</a>
		</c:if>
		
	</div>
</div>	
</body>
</html>