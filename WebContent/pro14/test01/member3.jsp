<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%
  request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean id="ms" class="com.kosta.controller.pro13.MemberBean" />
<jsp:setProperty name="ms" property="*" />

<meta  charset="UTF-8">
<html>
<head>
<title>회원 정보 출력창</title>
</head>
<body>
   <table align=center border="1" >
     <tr align="center" bgcolor="#99ccff">
        <td width=20%><b>아이디</b></td>
        <td width="20%" ><b>비밀번호</b></td>
        <td width="20%" ><b>이름</b></td>
        <td width="20%" ><b>이메일</b></td>		
     </tr>
     
     <tr align="center">
       <td>${ms.id } </td>
       <td>${ms.pwd} </td>
       <td>${ms.name }</td>
       <td>${ms.email }</td>
</tr>
</table>
</body>
</html>
