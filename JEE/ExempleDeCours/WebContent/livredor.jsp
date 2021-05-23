<%@ page import ="libMessage.*" %> 
<html> <head>
  <title> Livre d''or </title> </head>
	 <body > <form action ='livredor.jsp' method ='POST'> <label> email :</label>
		<input type ='text' name ='email' size ='50'/><br/>
		<textarea name='texte' rows ='10' cols='80'> Saisissez votre message ici
		</textarea> <br/>
			<input type ='submit' name ='submit' value ='Envoyer'/> </form>
			<jsp:useBean id="msg" class="libMessage.UnMessage" scope ="page">
			<jsp:setProperty name ="msg" property ="*"/> </jsp:useBean>
			<jsp:useBean id ="livreor" class ="libMessage.LivreOr" scope ="page"/>
			<jsp:setProperty name ="livreor" property ="fichier" value ="messages.txt "/>
		<% if( msg != null && msg.getEmail()!=null && !msg.getEmail().equals("")) {
		livreor.addMessage (msg ); livreor.enregistrer (); }
		if( livreor != null && livreor.getMessages()!=null && !livreor.getMessages().isEmpty()){
		for ( Object lemsg : livreor.getMessages ()) { %>
		  <table border ="1" > <tr > <td >
		<%= ((UnMessage)lemsg).getEmail() %></td > <td >
		<%= (( UnMessage ) lemsg ).getDate () %></td > </tr > <tr > <td colspan="2">
		<pre > <%= (( UnMessage ) lemsg ).getTexte () %> </pre >
		</td > </tr > </table > <% }} %>
	</body >
 </html >
