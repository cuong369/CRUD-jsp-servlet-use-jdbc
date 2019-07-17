<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet, JSP CRUD Operations</title>

<style type="text/css">
body {
	text-align: center;
}

table {
	margin-left: 15%;
	min-width: 70%;
	border: 1px solid #CCC;
	border-collapse: collapse;
}

table tr {
	line-height: 30px;
}

table tr th {
	background: #000033;
	color: #FFF;
}

table tr td {
	border: 1px solid #CCC;
	margin: 5px;
}

input[type=text], input[type=email], input[type=tel] {
	min-width: 60%;
}

input[type=submit], a {
	background: green;
	padding: 5px;
	margin: 5px;
	color: #FFF;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h1>List User</h1>
	<div style="text-align: right">
		<a href="logout">Logout</a>
	</div>
	<div style="text-align: right; margin-top: 18px;">
		<a style = "background: #F00;" href="register">ADD</a>
	</div>
	<div style="text-align: right; margin-top: 18px;">
		<a href="products">Information Products</a>
	</div>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listUser}" var="i">
				<tr>
					<td>${i.id}</td>
					<td>${i.name}</td>
					<td>${i.email}</td>
					<td>${i.username}</td>
					<td>${i.password}</td>

					<td>
						<form action="<c:url value="update"/>" method="post">
							<input type="hidden" name="custId" value="${i.id}">
							<input type="submit" value="Update">
						</form>
					<td>
						<form action="<c:url value="delete"/>" method="post">
							<input type="hidden" name="custId" value="${i.id}"> 
							<input style="background: #F00;" type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>