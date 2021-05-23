<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import = "Metier.Produits" %>
   <%@page import="java.util.ArrayList"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<Produits> ps ;
 if(request.getParameter("listP")!=null) ps = (ArrayList<Produits>)request.getAttribute("listP")  ;
 else ps = new ArrayList<Produits>() ;   
	 
 %>
 <% if (ps!=null) { %>
 <table>
  <tr>
      <th>Nom</th>
       <th>Description</th>
        <th>Etat</th>
         <th>Prix</th>
  </tr>
 <%
 for(Produits p : ps) {
 %>  <tr>
          <td><%=p.getNom() %></td>
          <td><%=p.getDesc() %></td>
          <td><%=p.getEtat() %></td>
          <td><%=p.getPrix() %></td>
     </tr> <% } } %>
    
   </table>

</body>
</html>