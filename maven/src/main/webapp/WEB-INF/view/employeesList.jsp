<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="aqua">
	<center>
		<a href="/maven/employee/add">Add Record</a>
		<form>
			<table border="2">
				<tr>
					<th>Employee Name</th>
					<th>Employee Address</th>
					<th>Employee Phone</th>
					<th>Employee Salary</th>
					<th>Action1</th>
					<th>Action2</th>
				</tr>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.empName}</td>
						<td>${employee.empAddress}</td>
						<td>${employee.empNo}</td>
						<td>${employee.empSalary}</td>
						<td><a href="/maven/employee/update?id=${employee.id}">update</a></td>
						<td><a href="/maven/employee/delete?id=${employee.id}">delete</a></td>
					</tr>

				</c:forEach>
			</table>
		</form>
	</center>
</body>
</html>