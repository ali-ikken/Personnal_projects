<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter news </title>
</head>
<body>
         <a href = "login.jsp">Se deconnecter</a> </p>
   <s:form action ="ajouternews" method="post">
	<s:textfield value="%{#session.user.nomPrenom}" label="Email" readonly="true"></s:textfield>	
	<s:textfield name="url" label="Url"></s:textfield>
	<s:textfield name="titre" label="Titre "></s:textfield>
	<s:submit value="Send"></s:submit>
	<s:submit value="Ajouter une Reaction " action="ajoutReaction"></s:submit>
	<s:submit value="Afficher les news" action="afficheNews"></s:submit>
	<s:submit value="Afficher les reactions  " action="affichageReaction"></s:submit>
   </s:form>
   <s:if test="%{#session.error!=null}">
     <s:property value="#session.error"/>
   </s:if>
		
</body>
</html>