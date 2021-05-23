<%@page import="java.util.ArrayList"%>
<%@page import="Metier.Produits"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits  : </title>
</head>
<body>
 <form action="prod" method= "post">
     <table>
       <tr>
           <td>Nom</td>
           <td><input type ="text" name = "nom"></td>   
       </tr>
        <tr>
           <td>Description</td>
           <td><input type ="text" name = "desc"></td>   
       </tr>
        <tr>
           <td>Prix </td>
           <td><input type ="text" name = "prix"></td>   
       </tr>
        <tr>
           <td>Etat</td>
           <td><input type ="text" name = "etat"></td>
            <tr>
           <td><input type ="submit" value = "Envoyer"></td>  
           </tr>
     </table>
 
 </form>
 <%=5%>
    
   </table>
</body>
</html>