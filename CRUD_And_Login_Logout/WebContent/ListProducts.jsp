<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Products</title>
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
	<h1>CRUD Jsp/Servlet</h1>
	<form action="add_edit" method="post">
		<table>
			<c:if test="${products.id ne null}">
				<tr>
					<td>Product ID</td>
					<td><input type="hidden" name="custId" value="${products.id}"
						readonly="readonly" /></td>
				</tr>
			</c:if>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="name" value="${products.name}"
					required="required" /></td>
			</tr>
			<tr>
				<td>QUANTITY</td>
				<td><input type="text" name="quantity"
					value="${products.quantity}" required="required" /></td>
			</tr>
			<tr>
				<td>PRICE</td>
				<td><input type="text" name="price"
					value="${products.price}" required="required" /></td>
			</tr>
			<tr>
				<td>LOGIN-ID</td>
				<td><input type="text" name="longin_id"
					value="${products.longin_id}" required="required" /></td>
			</tr>

			<c:if test="${products.id ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="UPDATE"/></td>
				</tr>
			</c:if>
			
			<c:if test="${products.id eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="ADD"/></td>
				</tr>
			</c:if>
		</table>
	</form>

	<h1>List Products</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>QUANTITY</th>
			<th>PRICE</th>
			<th>LOGIN-ID</th>
			<td>UPDATE</td>
			<td>DELETE</td>
		</tr>
		<c:forEach items="${listProducts}" var="i">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.quantity}</td>
				<td>${i.price}</td>
				<td>${i.longin_id}</td>

				<td>
					<form action="update-product" method="post">
						<input type="hidden" name="custId" value="${i.id}" /> <input
							type="submit" value="UPDATE" />
					</form>
				</td>

				<td>
					<form action="delete-product" method="post">
						<input type="hidden" name="custId" value="${i.id}" /> <input
							style="background: #F00;" type="submit" value="DELETE" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>