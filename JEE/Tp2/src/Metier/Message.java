package Metier;


import java.util.ArrayList;
import java.util.Date;


public class Message {
	private User user ; 
	private String message ; 
    private static ArrayList<Message> messages = new 
    		    ArrayList<Message>() ;
	public Message() {
		messages.add(this) ;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return new Date() ; 
	}


    public static ArrayList<Message> getMessages() {
		return messages;
	}
	public static void setMessages(ArrayList<Message> messages) {
		Message.messages = messages;
	}
	public static ArrayList<Message> getMessageByUser(User user ) {
		ArrayList<Message> messageUsers; 
		if(user.estProf()) messageUsers = messages ; 
		else {
			 messageUsers = new ArrayList<Message>() ;
			for(Message mes : messages ) {
				if(mes.user.equals(user)) messageUsers.add(mes) ;
			}
		}
		return messageUsers ; 
	}


}
