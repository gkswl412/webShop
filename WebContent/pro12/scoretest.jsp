<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>시험점수입력창</title>
<meta charset="UTF-8">
</head>
<body>
<h1>시험 점수를 입력해 주세요</h1>
    <form method=get action="scoreResultServlet">
       시험점수  :<input type=text  name="score" /> <br>
		 <input type ="submit" value="변환하기">	 			 
   </form>
</body>
</html>