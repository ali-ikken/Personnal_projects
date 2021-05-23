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
 <% ArrayList<News> listNews=(ArrayList<News>) application.getAttribute("listNews");%>
 <% User user=(User) session.getAttribute("user"); %> 
 <p align="right">
		<%=user.getNomPrenom()%> 
   		<a href="ServletS">  Se deconnecter ... </a>
 </p>
 <TABLE >
	<TR>
		<TH >Date</TH> 
		<TH >Titre</TH>
		<TH >Url</TH>
		<TH >Créateur</TH>
		<TH >Nb J'aime</TH>
		<TH >Nb Je deteste</TH>
		
	</TR>
	
	<%
	for (News news:listNews ) {
	%>
	<TR>
	 	<TD > <%=news.getDateInsertionString()%>       </TD>
		<TD>  <%=news.getTitre() %>   </TD>
		<TD > <%=news.getUrl() %>       </TD>
		<TD > <%=news.getCreateur().getNomPrenom() %>    </TD>
		<TD > <%=ServiceMetier.getNombreJaime(news) %>    </TD>
		<TD > <%=ServiceMetier.getNombreJeDeteste(news) %>    </TD>
		
	
	</TR>
	<% } %> 
</TABLE>
<BR><BR>
<a href="AfficheReactions.jsp">Afficher les reactions... </a><BR><BR>
<a href="AjoutNews.jsp">Envoyer de nouveaux news... </a><BR><BR>
<a href="AjoutReaction.jsp">Envoyer de nouvelle reaction... </a>
		
<% session.setAttribute("page", "AffichageNews");%>
</body>
</html>