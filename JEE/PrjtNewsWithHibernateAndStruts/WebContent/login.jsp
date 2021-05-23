<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="ISO-8859-1">
		<title> login : </title>
		</head>
		<body>
		 <s:form action= "Service" method ="post">
		 <s:textfield name="email" label="EMAIL"></s:textfield>
		 <s:textfield name="motPasse" label="PASSWORD" ></s:textfield>
		 <s:submit value = "VALIDER"></s:submit>
		 </s:form>
		  
		     <a href="inscription.jsp">S'inscrire...</a>
		</body>
</html>