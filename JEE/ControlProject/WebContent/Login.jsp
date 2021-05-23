<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
</head>
<body>
   <s:form method="post" action="inscrire">
     <s:textfield label="Login" name="cne" ></s:textfield>
     <s:password label="mot de passe " name="motPasse"></s:password>
  
      <s:submit value="ok"></s:submit>
    </s:form>
</body>
<a href="inscription.action">S'inscrire ...</a>
</html>