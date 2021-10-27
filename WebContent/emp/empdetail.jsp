<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원 상세 보기</h1>
	<form action="empdetail" method="post">
		<table border='1'>
			<tr>
				<th>직원번호</th>
				<td><input type="text" name="employee_id" value="${emp.employee_id}"></td>
			</tr>
			<tr>
				<th>성</th>	
				<td><input type="text" name="last_name" value="${emp.last_name}"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="first_name" value="${emp.first_name}"></td>
			</tr>
			<tr>
				<th>부서</th>
				<td><input type="text" name="department_id" value="${emp.department_id}"></td>
			</tr>
			<tr>
				<th>직책</th>
				<td><input type="text" name="job_id" value="${emp.job_id}"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone_number" value="${emp.phone_number}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${emp.email}"></td>
			</tr>
			<tr>
				<th>메니저</th>
				<td><input type="text" name="manager_id" value="${emp.manager_id}"></td>
			</tr>
			<tr>
				<th>커미션</th>
				<td><input type="text" name="commission_pct" value="${emp.commission_pct}"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="text" name="salary" value="${emp.salary}"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" name="hire_date" value="${emp.hire_date}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type='submit' value='수정하기'></td>
			</tr>
		</table> 
	</form>
</body>
</html>