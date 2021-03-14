<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title> Add Customer Form</title>

<link type="text/css" rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

<div id = "wrapper">
		<div id = "header"> 
		
			<h2>Customer Relationship Management</h2>
		
		</div>
	
	</div>
	
	<br>
	
	<form:form action = "list">
	<input type = "submit" value = "Back To list">
	</form:form>

<div id = "container">
<div id = "content">
<h2> Form To add Customer</h2>

</div>
</div>

<form:form action = "addCustomer" method ="POST" modelAttribute = "customer">
<form:hidden path ="id" />
	<table>
		<tr>
			<td><form:label path  = "firstName">Enter First Name</form:label></td>
			<td><form:input type = "text" label="First Name" path = "firstName"></form:input></td>
		</tr>
			
		<tr>
			<td><form:label path  = "lastName">Enter Last Name </form:label></td>
			<td><form:input type = "text"  path = "lastName"></form:input></td>
		</tr>
		
		<tr>
			<td><form:label path  = "email">Enter Email </form:label></td>
			<td><form:input type = "text" label="Email" path = "email"></form:input></td>
		</tr>
	</table>
		
		
		<br><br>
			<input type = "submit" />
		
	
</form:form>


</body>

</html>