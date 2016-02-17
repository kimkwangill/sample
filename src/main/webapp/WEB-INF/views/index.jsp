<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Sample</title>
</head>
<body>
	<h1>This is "index.jsp".</h1>
	
	<fieldset>
	    <legend>Hello</legend>
	    <p><a href="/sample/hello">hello test</a></p>
	</fieldset>
	
	<fieldset>
	    <legend>DAO</legend>
	    <p><a href="/sample/dao/sampleInsert">insert sample</a></p>
	    <p><a href="/sample/dao/sample">read sample</a></p>
	    <p><a href="/sample/dao/sampleList">read sample list</a></p>
	</fieldset>
		
	<fieldset>
	    <legend>Filter</legend>
	    <p><a href="/sample/filter/filter">Filter</a></p>
	</fieldset>
	
	<fieldset>
	    <legend>Interceptor</legend>
	    <p><a href="/sample/interceptor/interceptor">Interceptor</a></p>
	</fieldset>

	<fieldset>
	    <legend>Logging</legend>
	    <p><a href="/sample/logging/logging">Logging</a></p>
	</fieldset>	
	
</body>
</html>