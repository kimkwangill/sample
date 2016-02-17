<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Filter</title>
</head>
<body>
	<h1>${msg}</h1>
	<form method="post" action="/sample/filter/filterPrc">
		<p> ID : <input type="text" name="id"></p>
		<p> NAME : <input type="text" name="name"></p>
		<p> <input type="submit"> </p>
	</form>
</body>
</html>