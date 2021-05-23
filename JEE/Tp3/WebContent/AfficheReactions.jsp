<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href= "style.css">
<title>Affichage des reactions :</title>
</head>
<body>

  <p align="left" > <s:property value="nomPrenom"/> <br> <a href="login.jsp">Se deconnecter</a> </p>
  <s:if test="%{listReactions.size()>0}">
 <table border ="1">
        <tr>
           <tH>num</th>
           <th>dateReaction</th>
           <th>reaction</th>
           <th>user </th>
           <th>news </th>
        </tr> 
     <s:iterator value="listReactions">
        <tr>
          <td> <s:property value = "num" /> </td>
          <td>  <s:property value = "dateReaction" /> </td>
          <td> <s:property value = "reaction" /> </td>
          <td> <s:property value = "user.nomPrenom" />  </td>
          <td> <s:property value = "news.titre" /> </td>
        </tr> </s:iterator>
     </table>
  
</s:if>
<s:else> aucune reaction !!</s:else>
 <a href ="afficheNews.action"> Affichage des news </a> <br>
    <a href ="ajoutReaction.action"> Ajouter une reaction </a> <br>
     <a href ="ajoutNews.action"> Ajouter un news</a> <br>
</body>
</html>