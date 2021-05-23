<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "Metier.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>l'ajout d'un message</title>
</head>
<body>
     <h2>Ajout d'un nouveau message : </h2>
     <% User user = (User) session.getAttribute("user") ; %>
         <form action= "Operation" method ="post">
           <table>
              <TR>
                <TD valign = "top"><b>Email</b></TD>
                 <TD ><input type ="text" name ="email" style = "width :300 px" disabled 
                                                        value = <%= user.getEmail() %>></TD>
              </TR>
              <tr>
                 <TD valign = "top"><b>Message</b></TD>
                 <TD ><textarea name ="message" placeholder ="saisir un message"
                     rows ="10" cols="30" 
                                         style = "width :400 px ; heigth :150px">
                  </textarea>
                   </TD>
              
              </tr> 
              </table>
              <table>
                 <tr>
                    <td align = center width = "50%">
                    
                     <input type ="submit" name ="action" width="60"  value="envoi" width = "60" height ="60" >
       
                     <input type ="submit" name ="action" width="60"  value ="visualiser" width = "60" height ="60" >
                                     
                    </td>
                    <td align = center valign="middle">
                    <a href = "Operation">se deconnecter .. </a>
                    
                    </td>
                 </tr>
              </table>
         
         </form>
         <% session.setAttribute("page", "ajoutMessage");
         %>

</body>
</html>