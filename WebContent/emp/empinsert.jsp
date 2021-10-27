<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원 신규 등록</h1>
		<form action="empinsert" method="post">
		<table border='1'>
			<tr>
				<th>직원번호</th>
				<td><input type="number" name="employee_id"></td>
			</tr>
			<tr>
				<th>성</th>	
				<td><input type="text" name="last_name"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="first_name"></td>
			</tr>
			<tr>
				<th>부서</th>
				<td>
					<select name="department_id">
						<c:forEach items="${deptlist}" var="dept">
							<option value="${dept.department_id}">${dept.department_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>직책</th>
				<td>
					<select name="job_id">
						<c:forEach items="${joblist}" var="job">
							<option value="${job.job_id}">${job.job_title}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone_number"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>메니저</th>
				<td>
					<select name="manager_id">
						<c:forEach items="${mlist}" var="manager">
							<option value="${manager.employee_id}">${manager.first_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>커미션</th>
				<td><input type="text" name="commission_pct" value="0.2"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="number" name="salary"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="date" name="hire_date"></td>
			</tr>
			<tr>
				<td colspan="2"><input type='submit' value='등록하기'></td>
			</tr>
		</table> 
	</form>
</body>
</html>