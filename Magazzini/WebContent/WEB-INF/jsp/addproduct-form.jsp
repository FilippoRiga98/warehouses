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
	<h2>Aggiungi un nuovo prodotto - Marca e modello</h2>
	<form:form method="post" action="${flowExecutionUrl}&_eventId=save" modelAttribute="prodotto">
		<label>Marca prodotto:</label>
		<form:input path="marcaProdotto" />
		<label>Modello Prodotto:</label>
		<form:input path="modelloProdotto" />
		<input type="submit" value="Salva" />
	</form:form>
	<br/> <br/> <br/>
	<form:form action="${flowExecutionUrl}&_eventId=back" cssStyle="display: inline;">
    		<input type="submit" value="Indietro" />
	</form:form>
	<form:form action="${flowExecutionUrl}&_eventId=home" cssStyle="display: inline;">
    		<input type="submit" value="Torna alla home" />
	</form:form>
</body>
</html>