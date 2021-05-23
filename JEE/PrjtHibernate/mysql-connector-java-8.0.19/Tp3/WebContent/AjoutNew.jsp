<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "Metier.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter news </title>
</head>
<body>
   <% User user = (User)session.getAttribute("user")  ; %>
          <p align="right"> <%=user.getNomPrenom() %> 
         <a href = "login.jsp">Se deconnecter</a> </p>
   <form action ="Service" method="post">
		<table border ="1">
		<tr>
		    <td>Url de News :</td>
		    <td><input type ="text" name="url" style ="width : 300px"></td>
		</tr>
	    <tr>
		    <td>titre du news : </td>
		    <td><input type ="text"  name="titre" style ="width : 300px"></td>
		</tr>
	
		 <tr>
	          <td colspan="2" align="center">
	            <input type="submit" name="valider" value="valider">
	           <br> <a href="AfficheNew.jsp">Affichage des news </a> <br>
	            <a href ="AfficheReactions.jsp">Affichages des reactions </a> <br>
	                <a href ="ajoutReaction.jsp"> Ajouter une reaction </a> <br>
	            
	          </td>
	    </tr>
		
		</table>
		</form>
		<%session.setAttribute("page", "AjoutNews") ;
		String err = (String)request.getAttribute("err") ;
		if(err!=null) 
		{%><%=err %> <% } %>
</body>
</html>