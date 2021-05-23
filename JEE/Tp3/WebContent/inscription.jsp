<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>inscription</title>
		</head>
		<body>
		<s:form action ="inscrire" method="post">
		<s:textfield name="nomPrenom" id="nomPrenom" label="NOM&&PRENOM"></s:textfield>
		<s:textfield name="email" id ="email" label="EMAIL"></s:textfield>
		<s:password name="motPasse" id="motPasse" label="PASSWORD"></s:password>
		<s:submit value= "VALIDER"></s:submit>
		</s:form>
		</body>
</html>