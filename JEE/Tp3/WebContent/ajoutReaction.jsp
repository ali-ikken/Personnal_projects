<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>l'ajout d'un reaction</title>
</head>
<body>
     <h2>Ajout d'une reaction : </h2>
     <p align="right"> <s:property value ="#session.user.nomPrenom"/>
         <a href = "login.action">Se deconnecter</a>
         </p>
         <s:form action= "validerReaction" method ="post">
         <s:select list="#application.urls" label = "News" name="urlNews"></s:select>
         <s:radio list="{'like' , 'dislike'}" name ="reaction" label="Reaction " ></s:radio>
         <s:submit value="Valider" ></s:submit>
         <s:submit value ="ajouter news" action="ajoutNews"></s:submit>
         <s:submit value ="Affichage des news" action="afficheNews"></s:submit>
         </s:form>

</body>
</html>