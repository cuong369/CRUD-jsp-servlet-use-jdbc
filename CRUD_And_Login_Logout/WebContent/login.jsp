<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<thead>
				<tr>
					<th>Let's Login my account</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
				<tr>
					<td>Yet Not Register!!! <a href="register">Register Here</a></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>