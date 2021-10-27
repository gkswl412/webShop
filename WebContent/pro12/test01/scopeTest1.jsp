<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//scope: pageContext(현재페이지만) < request(요청이 살아 있는 동안) < session(브라우저) < application(서버 멈추기 전까지 유효)
	pageContext.setAttribute("major","jspServlet박사....pageContext");
	request.setAttribute("major","jspServlet박사....request");
	session.setAttribute("major","jspServlet박사....session");
	application.setAttribute("major","jspServlet박사....application");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scopeTest1</h1>
	<h2>default: ${major}</h2>
	<h2>pageContext: ${pageScope.major}</h2>
	<h2>request: ${requestScope.major}</h2>
	<h2>session: ${sessionScope.major}</h2>
	<h2>application(ServletContext): ${applicationScope.major}</h2>
	<hr>
	<!-- request전달 -->
	<%-- <jsp:forward page="scopeTest2.jsp"></jsp:forward> --%>
	<%-- <%
	RequestDispatcher rd = request.getRequestDispatcher("scopeTest2.jsp");
	rd.forward(request,response);
	//forward : 요청은 내가 받을께, 응답은 너가해! 요청주소는 그대로 나다? 넌 응답만 하는겨!
	%> --%>
	
	<!-- include forward로 갔다가 다시 나한테 와라! -->
	<jsp:include page="scopeTest2.jsp"></jsp:include>
	<!-- include와 forward 둘다 응답은 너가해라 인데, forward는 응답 페이지를 보여주고
		 include는 그 응답페이지를 내 페이지에 불러와서 띄운다. -->
</body>
</html>