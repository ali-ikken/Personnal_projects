<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'autentification</title>
</head>
<body>
 	<TABLE style="width:50%" >
     	<TR > 
     	<TD colspan =2 align="right" >  
		<a href="inscription.jsp">S'inscrire ... </a>
   		</TD> </TR>
   </TABLE>
   <BR>
     <FORM action = "ServletS" method ="post">
     <TABLE >
		<TR>
			<TD> <b>Email </b>  </TD>
			<TD> <input type="text"  name="email"    style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Mot de passe </b>  </TD>
			<TD> <input type="text"  name="motPasse"   style="width:300px"> </TD>
		</TR>
		
		<TR height="50px"> 
			<TD  colspan =2 align=center >
			<INPUT type ="submit" name="login" value="OK"> 
			</TD>
		</TR>
	</TABLE>
	
    </FORM>
    
    <% session.setAttribute("page", "login");
	   String erreur= (String) request.getAttribute("erreur");
	   if (erreur!=null ){
			out.print(erreur);
	   }
    %>
</body>
</html>