<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, Metier.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Formulaire d'ajout de news</title>
</head>
<body>

   <%--   <% User user=(User) session.getAttribute("user"); %> --%>
   <jsp:useBean id="user" class="Metier.User" scope ="session">
   </jsp:useBean>  
   <% ArrayList<String> urls=(ArrayList<String>) application.getAttribute("urls"); %>  
   
   
   <TABLE style="width:50%" >
     	<TR > 
     	<TD colspan =2 align="right" >  
		<%=user.getNomPrenom()%> 
   		<a href="ServletS">  Se deconnecter ... </a>
   		</TD> </TR>
   </TABLE>
   <BR>
      			
   <FORM action = "ServletS" method ="post">
     <TABLE style="width:50%; border-collapse: collapse;" >
     	<TR >
			<TD style="width:10%; border: thin solid #6495ed; padding: 5px" > <b>News </b>  </TD>
			<TD style="border: thin solid #6495ed; padding: 5px" > 
			  <SELECT name="listUrl" size="1" >
				<% for(String url: urls){ %>
				     <OPTION> <%=url %> <%}%>
				</SELECT>
	        </TD>
		</TR>
		<TR>
			<TD style="width:10%; border: thin solid #6495ed; padding: 5px"> <b>Reaction </b>  </TD>
			<TD style="border: thin solid #6495ed; padding: 5px" > <input type="radio"  name="reaction"   value="Jaime" checked > J'aime 
				     <input type="radio"  name="reaction"   value="jedeteste" >  je deteste
	   			</TD>
		</TR> 
	</TABLE>
	 <BR>
	 <TABLE style="width:50%; align:center" >	
		 <TR>
			<TD  >
			<input type="submit" name="action" value="Valider"  
			                             width="60" height="60" >
			</TD>
			<TD >			
			<input type="submit" name="action" value="Ajout news"  
			                             width="60" height="60" >
			<input type="submit" name="action" value="Affichage news" 
			                            width="60" height="60">
			<input type="submit" name="action" value="Affichage Reactions" 
			                            width="60" height="60">
			</TD>
		</TR>
	</TABLE>
    </FORM>
    
    
 
    <% session.setAttribute("page", "AjoutReaction");  %>
</body>
</html>