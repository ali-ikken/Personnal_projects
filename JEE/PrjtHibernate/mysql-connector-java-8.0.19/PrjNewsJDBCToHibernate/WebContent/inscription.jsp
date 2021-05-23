<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'inscription</title>
</head>
<body>

<h2> Ajout d'un nouveau user</h2>

     <FORM action = "ServletS" method ="post">
     <TABLE >
		<TR>
			<TD> <b>NomPr</b>  </TD>
			<TD> <input type="text"  name="nomPrenom" style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Email </b>  </TD>
			<TD> <input type="text"  name="email"    style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>PassWord </b>  </TD>
			<TD> <input type="text"  name="motPasse"   style="width:300px"> </TD>
		</TR>
		<TR height="50px" > 
			<TD colspan =2 align=center >
			<INPUT type ="submit" name="Valider" value="valider"> 
			</TD>
		</TR>
	</TABLE>
    </FORM>
     
    <% session.setAttribute("page", "inscription"); 
	   String erreur= (String) request.getAttribute("erreur");
	   if (erreur!=null ){
	        	out.print(erreur);
	   }
    %>
 
</body>
</html>
