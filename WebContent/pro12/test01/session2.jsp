<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String name=(String)session.getAttribute("name");
String address = (String)session.getAttribute("address");

%>    
 
<!DOCTYPE html>     
<html>
<head>
<meta charset="UTF-8">
<title>session 내장 객체 테스트2</title>
</head>
<body>
이름은 <%=name %>입니다.<br>
주소는 <%=address %>입니다. 
<p>직원정보는 ${emp} 입니다.</p>
<p>직원이름은 ${emp.first_name}입니다.</p>

<!-- include 디렉션 : 합쳐서 컴파일 -->
<%-- <%@ include file="../gugu2.jsp" %> --%>

<!-- 컴파일후 합친다. -->
<jsp:include page="../gugu2.jsp">
	<jsp:param value="8" name="dan"/>
</jsp:include>
</body>
</html>
