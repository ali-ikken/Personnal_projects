<%@page import="java.util.ArrayList"%>
<%@page import="Metier.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search for noDept</title>
</head>
		<body>
		<% ArrayList<Emp> emps ; 		
		if(request.getAttribute("emps")!=null){ emps =(ArrayList<Emp>)request.getAttribute("emps") ;}
		else { emps = new ArrayList<Emp>()  ;} %>
		<form action ="data" method="post">
		  <table border ="1">
		   <tr>
		      <td colspan="2">N°Departement<select name= "num" ><option value="10">10</option>
		                                                        <option value="20">20</option>
		                                                        <option value="30">30</option>
		                                                               </select></td>
		      <td colspan="2"><input type="submit" value="search"></td>
		   </tr>
		   
		  </table>   </form>
		 
		  <table border="1">
		  <tr>
		     <th>Name</th>
		     <th>Job</th>
		     <th>Salary</th>
		  </tr>
		  <% 
		for(Emp ep : emps){
		   %>
		   
		   <tr>
		       <td><%=ep.getNom() %></td>
		       <td><%=ep.getFonction() %></td>
		       <td><%=ep.getSal() %></td>
		   </tr>
		   <% } %></table> 
		  
		</body>
</html>