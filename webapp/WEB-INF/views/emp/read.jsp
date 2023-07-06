<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상사정보조회</title>
</head>
<body>
    <h1>상사 정보 조회</h1>
    <hr>
    <c:if test="${not empty manager}">
        <p>이름 : ${manager.ename}</p>
        <p>직무 : ${manager.job}</p>
        <p>급여 : ${manager.sal}</p>
    </c:if>
</body>
</html>
