<%@page import="in.co.rays.proj4.controller.LoginCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<h1 align="center">Login</h1>

	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<div align="center">
			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="ENTER YOUR EMAIL"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN %>"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>