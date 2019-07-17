<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Here</h1>
	<form action="register" method="post">
		<table>
			<c:if test="${login.id ne null}">
				<tr>
					<td>ID</td>
					<td><input type="text" name="custId" value="${login.id}"
						readonly="readonly" /></td>
				</tr>
			</c:if>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${login.name}" required="required"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" value="${login.email}" required="required"/></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"
					value="${login.username}" required="required"/></td>
			</tr>
			<tr>
				<td>PassWord</td>
				<td><input type="password" name="password"
					value="${login.password}" required="required"/></td>
			</tr>
			<c:if test="${login.id ne null}">
				<tr>
					<td><input type="submit" value="Update" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</c:if>
			<c:if test="${login.id eq null}">
				<tr>
					<td><input type="submit" value="Register" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</c:if>
			<tr>
				<td><a href="login.jsp">Login Here</a></td>
			</tr>
		</table>
	</form>
</body>
</html>