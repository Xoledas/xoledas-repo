<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Synology</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	</head>
	<body class="body">
		<c:import url="structure/menu.jsp"></c:import>
		
		<div class="main-container">
		
			<!--<c:out value="${speedt.download}"/>-->
			
			<c:set var="maVariable" value="testtest"/>
		    <c:import url="structure/accueil-canvas.jsp"></c:import> 
	    
	    </div>
	    
	    <!-- 
	    <c:forEach items="${ titres }" var="titre" varStatus="status">
		    <p>N°<c:out value="${ status.count }" /> : <c:out value="${ titre }" /> !</p>
		</c:forEach>
	     -->
		
	</body>
</html>