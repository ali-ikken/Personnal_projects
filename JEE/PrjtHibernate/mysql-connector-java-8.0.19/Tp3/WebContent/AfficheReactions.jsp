<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "Metier.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href= "style.css">
<title>Affichage des reactions :</title>
</head>
<body>
<% ArrayList<Reaction> reacts =(ArrayList<Reaction>) session.getAttribute("reactions") ; 
User user = (User) session.getAttribute("user") ;
%>
<caption>
  <p align="right"> <%=user.getNomPrenom() %>
         <a href = "login.jsp">Se deconnecter</a> </p>
   </caption>
 <table border ="1">
        <tr>
           <tH>num</th>
           <th>dateReaction</th>
           <th>reaction</th>
           <th>user </th>
           <th>news </th>
        </tr> 
      
     <% for (Reaction rts : reacts) { %>
        <tr>
          <td><%=rts.getNum() %></td>
          <td><%=rts.getDateReaction() %></td>
          <td><%=rts.getReaction() %></td>
          <td><%=rts.getUser().getNomPrenom() %> </td>
          <td><%=rts.getNews().getUrl() %></td>
        </tr> <% } %> 
     </table>
   <a href ="AfficheNew.jsp"> Affichage des news </a> <br>
    <a href ="ajoutReaction.jsp"> Ajouter une reaction </a> <br>
     <a href ="AjoutNew.jsp"> Ajouter un news</a> <br>

</body>
</html>