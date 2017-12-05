<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Visualizza bolla</title>
	<style type="text/css">
		table, tr, td, th{border: 0.5px solid black; border-collapse: collapse;}
		table{margin-left: auto; margin-right: auto;}
		th{background-color: #b3b3ff;}
		td, th, input{padding: 5px; font-family: Ubuntu; font-size: 17px; text-align: center;}
		div{text-align: center; border: 2.5px solid #999999; border-collapse: collapse; 
				margin-left: 350px; margin-right: 350px; border-radius: 23px;}
		h1, h3, h4{font-family: Ubuntu;}
		span.success{color: #00e600;}
		span.failed{color: #ff1a1a;}
		td.success{background-color: rgba(0, 255, 0, 0.5);}
		td.failed{background-color: rgba(255, 0, 0, 0.5);}
		td.notAvailable{background-color: rgba(255, 200, 0, 0.6);}
		td.id{background-color: rgba(192, 192, 192, 0.7)}
	</style>
</head>
<body>

	<div>
		<form:form action="order">	
			<h1>-- Bolle --</h1>
			<h3> Numero Ordini: ${numOrdini} </h3>
			<h4><span class="success">Ordini con succeso: ${numOrdiniConSuccesso}%</span>&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="failed">Ordini senza successo: ${numOrdiniSenzaSuccesso}%</span></h4>
			<c:choose>
				<c:when test="${stop == false}">
					<span><input type="submit" value="Ordina" /></span>
				</c:when>    
				<c:otherwise>
					<span>Siamo spiacenti, non è più possibile evadere ordini</span>
				</c:otherwise>
			</c:choose> 
			&nbsp;&nbsp;<a href="home">Torna alla home</a>
		</form:form>
		<br/><br/>
	</div>
	
	<br/><br/>
	
	<table>  
	
		<tr><th class="violet">Id</th>
			<th>Tipo1</th><th class="violet">Marca1</th><th>Modello1</th><th class="violet">Magazzino1</th>
			<th>Tipo2</th><th class="violet">Marca2</th><th>Modello2</th><th class="violet">Magazzino2</th>
			<th>Stato</th></tr>  
			
		<c:forEach var="bill" items="${billList}">   
			<tr>  
				<td class="id">
					<fmt:formatNumber value="${bill.idBolla}" minIntegerDigits = "8" maxIntegerDigits = "8" pattern="#"/>
				</td>
				
				<td>${bill.prodotto1.getTipoProdotto()}</td>
				<td>${bill.prodotto1.getMarcaProdotto()}</td>
				<td>${bill.prodotto1.getModelloProdotto()}</td>
				
				<c:choose>
					<c:when test="${bill.magazzino1 == null}">					
						<td class="notAvailable">Non disponibile</td>
					</c:when>    
					<c:otherwise>						
						<td>${bill.magazzino1}</td>
					</c:otherwise>
				</c:choose>
				
				<td>${bill.prodotto2.getTipoProdotto()}</td>
				<td>${bill.prodotto2.getMarcaProdotto()}</td>
				<td>${bill.prodotto2.getModelloProdotto()}</td>
				
				<c:choose>
					<c:when test="${bill.magazzino2 == null}">
						
						<td class="notAvailable">Non disponibile</td>
					</c:when>    
					<c:otherwise>
						<td>${bill.magazzino2}</td>
					</c:otherwise>
				</c:choose>
				
				<c:choose>	   
					<c:when test="${bill.stato == true}">
						<td class="success">Spedito</td>
					</c:when>    
						<c:otherwise>
						<td class="failed">Annullato</td>
					</c:otherwise>
				</c:choose>
				
			</tr>  
		</c:forEach>  
		
	</table> 
		
	</body>
</html>