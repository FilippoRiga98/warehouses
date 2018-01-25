<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
	<style type="text/css">
			table, tr, td, th{border: 0.5px solid black; border-collapse: collapse;}
    		table{margin-left: auto; margin-right: auto;}
    		td, th{padding: 4px; font-size: 17px; font-family: Ubuntu; text-align: center;}
    		th{background-color: #b3b3ff;}
    		div{text-align: center;}
    		h1{text-align: center; font-family: Ubuntu;}
    		form{display: inline;}
	</style>
</head>
<body>

	<h1>-- Effettua un ordine --</h1>
	<div>
		<form:form action="order">
				<c:choose>
					<c:when test="${stop == false}">
						<span><input type="submit" value="Ordina" /></span>
					</c:when>    
					<c:otherwise>
						<span>Siamo spiacenti, non è più possibile evadere ordini</span>
					</c:otherwise>
				</c:choose> 
		</form:form>
	</div>
	<br/>
	<table> 
	 
	   <tr><th>Tipo</th><th>Marca</th><th>Modello</th></tr>  
	   
	   <c:forEach var="product" items="${productList}">   
		   <tr>  
		   	<td>${product.tipoProdotto}</td>
			   <td>${product.marcaProdotto}</td>  
			   <td>${product.modelloProdotto}</td>  
		   </tr>  
	   </c:forEach> 
	    
	</table>  
	
   <br/>
    
	<div>
		<form action="viewbill">
    		<input type="submit" value="Visualizza fatture" />
		</form>
		<form action="addProductFlow?selectTipoProdotto">
    		<input type="submit" value="Aggiung prodotto" />
		</form>
	</div>
</body>