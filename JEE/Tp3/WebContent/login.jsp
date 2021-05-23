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
		<h1>Sign in</h1>
		 <s:form action= "service" method ="post">
		 <s:textfield name="email" id ="email"  label="EMAIL"></s:textfield>
		 <s:password name="motPasse" id="motPasse" label="PASSWORD" ></s:password>
		 <s:submit value = "VALIDER"></s:submit>
		 </s:form>
		  
		     <a href="inscrire1.action">S'inscrire...</a> <br>
		</body>
		<s:if test="%{error!=null}">
		  <s:property value="error"/>
		</s:if>
</html>