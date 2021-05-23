<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, Metier.*"
    %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="Style.css" />
<head>
<meta charset="ISO-8859-1">
<title>Affichage des news</title>
</head>
<body>
 <% ArrayList<Reaction> listReactions= (ArrayList<Reaction>) application.getAttribute("listReactions");%>
 <% User user=(User) session.getAttribute("user"); %> 
 <p align="right">
		<%=user.getNomPrenom()%> 
   		<a href="ServletS">  Se deconnecter ... </a>
 </p>
 <TABLE >
	<TR>
		<TH >Num</TH> 
		<TH >DateReaction </TH>
		<TH >Titre</TH>
		<TH >User</TH>
		<TH >reaction</TH>
				
	</TR>
	
	<%
	for (Reaction react:listReactions ) {
	%>
	<TR>
	 	<TD > <%=react.getNum()%>       </TD>
		<TD>  <%=react.getDateReactionString()%>   </TD>
		<TD > <%=react.getNews().getTitre() %>       </TD>
		<TD > <%=react.getUser().getNomPrenom() %>    </TD>
		<TD > <% if (react.getReaction()) out.print("J'aime");
		           else out.print("je deteste");%>    </TD>
		
	
	</TR>
	<% } %> 
</TABLE>
<BR><BR>
<a href="AjoutNews.jsp">Envoyer de nouveaux news... </a><BR><BR>
<a href="AjoutReaction.jsp">Envoyer de nouvelle reaction... </a>
		
<% session.setAttribute("page", "AffichageReaction");%>
</body>
</html>