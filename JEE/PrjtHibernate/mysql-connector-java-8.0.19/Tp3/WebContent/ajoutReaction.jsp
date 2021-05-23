<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "Metier.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>l'ajout d'un reaction</title>
</head>
<body>
     <h2>Ajout d'une reaction : </h2>
     <% User user = (User) session.getAttribute("user") ;
     ArrayList<String> urls = (ArrayList<String>)session.getAttribute("urls") ;
     %>
         <form action= "Service" method ="post">
         <p align="right"> <%=user.getNomPrenom() %> 
         <a href = "login.jsp">Se deconnecter</a>
         </p>
           <table border ="1">
              <tr>
                 <TD valign = "top"><b>Url News :</b></TD>
                 <TD ><select name ="url" size="1">
                          <%for(String url : urls){ %> <option> <%=url %><%} %>
                 </select>
                   </TD>
              </tr> 
             <tr>
                <td>  <b>Reaction :</b> </td>
                 
                 <td>   j'aime
                    <input type = "radio" name="reaction" value ="j'aime" checked>
                       je deteste
                    <input type = "radio" name="reaction" value =" je deteste"  ></td>
             </tr>
              </table>
              
                <table>
                 <tr>
                <td>    
               <input type ="submit" name ="action" width="60"  value="Valider"  >
               <input type ="submit" name ="action" width="60"  value ="AjoutNews" >
               <input type ="submit" name ="action" width="60"  value ="Affichage Reaction"  >
                       </td>         
                 </tr>
              </table>
         
         </form>
         <%
         session.setAttribute("page", "ajoutReaction");
         %>

</body>
</html>