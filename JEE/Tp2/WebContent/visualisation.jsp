<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Metier.Message"%>
<%@page import="Metier.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des messages </title>
</head>
<body>
  <h2>Affichage des messages : </h2>

   <%  ArrayList<Message> messages ;
   if( session.getAttribute("messages")!=null)  messages = (ArrayList<Message>)session.getAttribute("messages") ;
   else   messages = new ArrayList<Message>() ; 
   %>
    <table border ="1">
        <tr> 
            <th> Date </th>
            <th>Email</th>
            <th>Message </th>
        </tr>
        <%
        for(Message msg : messages) {
        %>
        <tr>
	        <td><%= msg.getDate()  %></td>
	        <td><%= msg.getUser().getEmail()  %></td>
	        <td><%= msg.getMessage()  %></td>
        </tr>
        <% } %> 
    </table>
    <a href="ajoutMessage.jsp" >ajouter un nouveau message ... </a>
     <% session.setAttribute("page", "visualisation") ;  %>
    </body>
</html>