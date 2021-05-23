<%@taglib  prefix="s" uri="/struts-tags"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href= "style.css">
<title>Affichage des news  :</title>
</head>
<body>

         <p align="right"> <s:property  value ="#session.user.nomPrenom"/>
         <a href = "srv.action">Se deconnecter</a> </p> <br>

 <s:if test="%{listNews.size()>0}">
     <table border ="1">
        <tr>
           <tH>url</th>
           <th>titre</th>
           <th>dateNews</th>
           <th>Createur </th>
           <th>nbrs de j'aime </th>
           <th>nbres de je_deteste </th>
        </tr> 
        <s:iterator value="listNews">
        <tr>
          <td> <s:property value="url"/> </td>
          <td><s:property value="titre"/></td>
          <td><s:property value="dateNews"/></td>
          <td><s:property value="createur.nomPrenom"/></td>
           <td><s:property value="nbrLikes"/></td>
            <td><s:property value="nbrDislikes"/></td>
        </tr></s:iterator>
     </table>
     <br>
     </s:if>
     <s:else>Aucune news !! </s:else> <br>

        <a href ="ajoutNews.action"> Ajouter un news</a> <br><br><br>
         <a href ="ajoutReaction.action"> Ajouter une reaction </a> <br><br><br>
          <a href ="affichageReaction.action">Affichages des reactions </a>
        
</body>
</html>