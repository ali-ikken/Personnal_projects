<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ConsultDisponible</title>
</head>
<body>
 <s:property value ="#session.etud.getNomPrenom()" /> <a href="login.action">Se deconnectee ...</a>
  <s:if test="%{listExemplaires.size()>0}">
  <table border="1">
    <tr> <th>Code</th><th>Titre</th> </tr>
   <s:iterator value="listExemplaires" var="exe">
    <tr>
		   <td> <s:property value="code" />  </td> 
		   <td>  <s:property value="livre.titre" /> </td>
   </tr>
    
   </s:iterator>
  </table>
    
  
  
  </s:if>
  <s:else>Aucun livre disponible</s:else> <br>
  
  
  <a href="emprunter.action">Emprunter un Exemplaire de livre </a>
</body>
</html>