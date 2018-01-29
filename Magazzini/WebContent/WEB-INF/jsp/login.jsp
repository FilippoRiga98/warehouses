<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
   <h1>Login</h1>
	   <form:form action="performlogin" method='POST' modelAttribute="user">
	      <label>Username: </label><form:input path="username" /><br /><br />
	      <label>Password: </label><form:input path="password" /><br />
	      <input type="submit" value="Login" /> 
	   </form:form>
</body>
