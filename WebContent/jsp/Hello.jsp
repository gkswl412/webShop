<!-- page 디렉티브 태그 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- library 태그 -->
<%@ taglib prefix="c" uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello~~~~~~~~jsp</h1>
<!-- include 태그 , 다른페이지를 출력할때 -->
<%@ include file="../pro09/login.jsp" %>
<%@ include file="common.jsp" %>
</body>
</html>