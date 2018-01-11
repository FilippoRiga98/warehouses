<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuovo Prodotto</title>
</head>
<body>
	<h2>Aggiungi un nuovo prodotto - Scegli il tipo</h2>
	<form:form method="post" action="${flowExecutionUrl}&_eventId=next" modelAttribute="prodotto" cssStyle="display: inline;">
		<label>Tipo prodotto:</label>
		<form:select path="tipoProdotto">
			<c:forEach items="${productTypes}" var="type">
				<form:option value="${type.tipoProdotto}" ></form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Avanti" />
	</form:form>
	<br/><br/>
	<form:form action="${flowExecutionUrl}&_eventId=home">
    		<input type="submit" value="Torna alla home" />
	</form:form>
</body>
</html>