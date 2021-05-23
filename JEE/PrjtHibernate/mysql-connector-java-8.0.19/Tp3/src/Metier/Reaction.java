package Metier;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Reaction implements Serializable {
	private static SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE) ;
	private static SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE) ;
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int num ; 
   private Date dateReaction  ;
   private boolean reaction  ; 
   private User user ;  
   private News news ;
public Reaction() throws SQLException {
	dateReaction = new Date() ;
}
public boolean getReaction() {
	return reaction;
}

public void setDateReaction(Date dateReaction) {
	this.dateReaction = dateReaction;
}


public String getDateFormatter1() {
	return (String)formatter1.format(dateReaction.getTime());
}


public String  getDateFormatter2() {
	return (String)formatter2.format(dateReaction.getTime());
}


public int getNum() {
	return num;
}

public Date getDateReaction() {
	return dateReaction;
}


public void setNum(int num) {
	this.num = num;
}
public void setReaction(boolean reaction) {
	this.reaction = reaction;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public News getNews() {
	return news;
}
public void setNews(News news) {
	this.news = news;
}

   
} 
