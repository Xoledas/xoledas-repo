<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Synology</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">		
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>
	<body class="body">
		<c:import url="structure/menu.jsp"></c:import>
		
		<div class="main-container">
			<form method="post" action="details">
				<div id="searchform">
					<fieldset>
						<legend class="colortext">Paramètres de recherche</legend>
						<div class="searchform-item">
							Date de début : 
							<input type="text" id="datedebut" name="dated" value=<c:out value="${datede}"/> />
						</div>
						<div class="searchform-item">
							Date de fin : 
							<input type="text" id="datefin" name="datef" value=<c:out value="${datefi}"/> />
						</div>
						<input class="submit-button" type="submit" value="Affiner" />
					</fieldset>
				</div>
			</form>
			
		    <c:import url="structure/accueil-canvas.jsp"></c:import> 
		    
	    
	    </div>
	    
	    <!-- 
	    <c:forEach items="${ titres }" var="titre" varStatus="status">
		    <p>N°<c:out value="${ status.count }" /> : <c:out value="${ titre }" /> !</p>
		</c:forEach>
	     -->
	     
	     <script>
			$( function() {
				$( "#datedebut" ).datepicker({dateFormat:"dd/mm/yy"});
				$( "#datefin" ).datepicker({dateFormat:"dd/mm/yy"});
			} );
		</script>
		
	</body>
</html>