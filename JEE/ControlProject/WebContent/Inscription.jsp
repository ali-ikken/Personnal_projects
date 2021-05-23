<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
 <s:form method="post" action="insc">
  <s:textfield label="CNE" name = "cne"></s:textfield>
  <s:textfield label="NOM" name ="nom" ></s:textfield>
  <s:textfield label="PRENOM" name="prenom"></s:textfield>
  <s:password label="MOT DE PASSE" name="motPasse"></s:password>
  <s:submit value="VALIDER"></s:submit>
 
 </s:form>
</body>
</html>