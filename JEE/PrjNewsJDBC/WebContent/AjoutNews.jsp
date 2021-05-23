<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, Metier.*" %>
<!DOCTYPE html>
<html>
<head>

<title>Formulaire d'ajout de messages</title>
</head>
<body>
<% User user=(User) session.getAttribute("user"); %>
  
   <TABLE style="width:50%" >
     	<TR > 
     	<TD colspan =2 align="right" >  
		<%=user.getNomPrenom()%> 
   		<a href="ServletS">  Se deconnecter ... </a>
   		</TD> </TR>
   </TABLE>
   <BR>
   <FORM action = "ServletS" method ="post">
     <TABLE style="width:50%">
		<TR>
		  <TD width="10%" > <b>Email </b>  </TD>
		  <TD> <input type="text"  name="email" style="width:300px" disabled
			      value= <%=user.getEmail()%>> </TD>
		</TR>
		<TR> 
		  <TD width="10%" > <b>Url </b>  </TD>
		  <TD> <input type="text"  name="url" style="width:300px" >
		  </TD>
		</TR>
		<TR>
		  <TD width="10%"> <b>Titre </b>  </TD>
		  <TD > <input type="text"  name="titre" style="width:300px" >
		  </TD>
		</TR>
	</TABLE >
	<BR>
	<TABLE style="width:50%; align:center" >	
		 <TR>
			<TD  >
			<input type="submit" name="action" value="Valider"  
			                             width="60" height="60" >
			</TD>
			<TD >			
			<input type="submit" name="action" value="Ajout reaction"  
			                             width="60" height="60" >
			<input type="submit" name="action" value="Affichage news" 
			                            width="60" height="60">
			</TD>
		</TR>
	</TABLE>

    </FORM>
    
    <% session.setAttribute("page", "AjoutNews");  
			String erreur= (String) request.getAttribute("erreur");
			   if (erreur!=null ){
					out.print(erreur);
			   }

    %>
</body>
</html>