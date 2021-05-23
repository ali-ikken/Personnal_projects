<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>inscription</title>
		</head>
		<body>
		<form action ="Operation" method="post">
		<table>
		<tr>
		    <td>nomPr</td>
		    <td><input type ="text" name="nomPr" style ="width : 300px"></td>
		</tr>
	    <tr>
		    <td>Email</td>
		    <td><input type ="text"  name="email" style ="width : 300px"></td>
		</tr>
		<tr>
		    <td>Password</td>
		    <td><input type ="password"  name="password" style ="width : 300px"></td>
		</tr>
		 <tr>
		    <td>Statut</td>
		    <td><label for = "etudiant">Etudiant</label><input type ="radio" id= "etudiant" name="statut" value = "etudiant" >
		   <label for = "professeur">Professeur</label><input type ="radio" id="professeur" name="statut" value = "professeur" >
		     </td>
		</tr>
		 <tr>
	          <td colspan="2" align="center">
	            <input type="submit" name="valider" value="valider">
	            <a href="login.jsp"></a>
	          </td>
	    </tr>
		
		</table>
		</form>
		<% session.setAttribute("page", "inscription") ;
				   String erreur = (String)request.getAttribute("erreur");
				   if(erreur !=null){
					   out.print(erreur);
				   }
				   %>
		</body>
</html>