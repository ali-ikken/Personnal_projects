<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
		<head>
		<meta charset="ISO-8859-1">
		<title> sign in/ sing up</title>
		</head>
		<body>
		 <form action= "Operation" method ="post">
		 <table>
			   <tr>
		          <td> <b>Email</b> </td>
		          <td><input type="text" name="email" style="width: 300px"></td>
		        </tr>
		      <tr>
		          <td> <b>Password</b> </td>
		          <td><input type="password" name="password" style="width: 300px"></td>
	          </tr>
	         <tr>
	          <td colspan="2" align="center">
	            <input type="submit" name="login" value="Ok">
	            <a href="inscription.jsp">S'inscrire...</a>
	          </td>
	        </tr>
	          
		   </table>
		 </form>
		 <% session.setAttribute("page", "login") ;
		String erreur   = (String)request.getAttribute("erreur") ;
		 if(erreur!=null)
			 out.print(erreur) ;
		 %>
		
		</body>
</html>