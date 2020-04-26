<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome>BanK</title>
<link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
	<div>
		<form action="controler.do" method="post">
			<table class="table1">
				<tr>
					<td>Code 1</td>
					<td><input type="text" name="code1" /></td>
				</tr>
				<tr>
					<td>Code 2</td>
					<td><input type="text" name="code2" /></td>
				</tr>
				<tr>
					<td>Amount</td>
					<td><input type="text" name="amount" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Debit" name="action"></td>
					<td><input type="submit" value="Credit" name="action"></td>
					<td><input type="submit" value="Transfert" name="action"></td>
					<td><input type="submit" value="Ajouter" name="action"></td>
				</tr>
			</table>
		</form>
	</div>
	<br /><br /><br />
	<div>
		<table class="table2">
			<tr>
				<th>Code</th>
				<th>Balance</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${accounts}" var="ac">
				<tr>
					<td>${ac.code}</td>
					<td>${ac.solde}</td>
					<td>${ac.active}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>