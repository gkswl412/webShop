<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP내장객체</h1>
	<%
	String s = request.getParameter("myname");
	%>
	<%=s %>
	<h1>EL내장객체</h1>
	${param.myname}
	<h1>path사용하기</h1>
	<img alt="상대경로로 이미지 연결하기" src="./image/duke.png"><br>
	<img alt="절대경로(고정)로 이미지 연결하기" src="/webShop/pro14/image/duke.png"><br>
	<img alt="전체경로로 이미지 연결하기" src="http://localhost:9999/webShop/pro14/image/duke.png"><br>
	<img alt="절대경로(script let)로 이미지 연결하기" src="<%=request.getContextPath()%>/pro14/image/duke.png""><br>
	<img alt="절대경로(script el)로 이미지 연결하기" src="${pageContext.request.contextPath}/pro14/image/duke.png""><br>
</body>
</html>