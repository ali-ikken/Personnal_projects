<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "Metier.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href= "style.css">
<title>Affichage des news  :</title>
</head>
<body>
 <% ArrayList<News> nws  =(ArrayList<News>) session.getAttribute("nwss") ;
 User user = (User) session.getAttribute("user") ;
 %>
         <p align="right"><%=user.getNomPrenom() %>
         <a href = "login.jsp">Se deconnecter</a> </p>

 
     <table border ="1">
        <tr>
           <tH>url</th>
           <th>titre</th>
           <th>dateNews</th>
           <th>Createur </th>
           <th>nbrs de j'aime </th>
           <th>nbres de je_deteste </th>
        </tr> 
        <%for(News nw : nws){ %>
        <tr>
          <td><%=nw.getUrl() %></td>
          <td><%=nw.getTitre() %></td>
          <td><%=nw.getDateFormatter2() %></td>
          <td><%= nw.getCreateur().getNomPrenom()%></td>
           <td><%= ServiceMetier.getNombreslike(nw)%></td>
            <td><%= ServiceMetier.getNombresJeDeteste(nw)%></td>
        </tr><% } %> 
     </table>

        <a href ="AjoutNew.jsp"> Ajouter un news</a> <br>
         <a href ="ajoutReaction.jsp"> Ajouter une reaction </a> <br>
          <a href ="AfficheReactions.jsp">Affichages des reactions </a> <br>
          <% session.setAttribute("page", "afficheNew") ; %>
</body>
</html>