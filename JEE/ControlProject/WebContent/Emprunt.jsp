<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emprunter un livre</title>
</head>
<body>
 <b><s:property value ="#session.etud.getNomPrenom()" /> </b> <a href="login.action">Se deconnectee ...</a>
 <br><br><br> <h3>Les codes des exemplaires disponibles  : </h3>
   <s:form method="post" action="emp">
     <s:textfield label="CNE"  value="%{#session.etud.cne}" readonly="true" disabled="true"></s:textfield>
  <s:select list="listcodes" label = "List Codes" name="codeE"></s:select>
     <s:submit value="Valider"></s:submit>
    
     </s:form>
 <a href="affiche.action">Consulter les exemplaire disponibles ...</a>
</body>
</html>