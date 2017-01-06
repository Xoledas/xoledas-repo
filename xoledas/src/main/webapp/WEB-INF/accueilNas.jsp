<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Synology</title>
	</head>
	<body>
		<%@ include file="structure/menu.jsp" %>
		Accueil NAS
		
		<c:out value="bonjour"/><br>
		<c:out value="${test1}"/><br>
		<c:out value="${speedt.download}"/>
	    
	    <!-- 
	    <c:forEach items="${ titres }" var="titre" varStatus="status">
		    <p>N°<c:out value="${ status.count }" /> : <c:out value="${ titre }" /> !</p>
		</c:forEach>
	     -->
		
	</body>
</html>