package Metier;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Reaction implements Serializable{
	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat formatter = 
            new SimpleDateFormat ("dd-MM-yyyy", Locale.FRANCE);
	private static SimpleDateFormat formatter2 = 
            new SimpleDateFormat ("yyyy-MM-dd", Locale.FRANCE);//pour MySQL
	
	private int num;
	private Date dateReaction; 
	private boolean reaction;
	private User user;
	private News news;
	public Reaction() {	dateReaction =new Date();}
    public void setNum(int num) { this.num = num;	}
    public String getDateReactionString()	{
		return (String) formatter.format (dateReaction.getTime());
	}
	public String getDateReactionString2()	{
		return (String) formatter2.format (dateReaction.getTime());
	}
	public Date getDateReaction() { return dateReaction;}
	public void setDateReaction(Date dateReaction) {this.dateReaction = dateReaction;}
	public boolean getReaction() { return reaction;	}
	public String getReactionString() {
		if(reaction) return ("J'aime"); else return ("je Deteste");
	}
	public void setReaction(boolean reaction) { this.reaction = reaction; }
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user;	}
	public News getNews() {	return news; }
	public void setNews(News news) { this.news = news;	}
	public int getNum() { return num;}
	@Override
	public String toString() {
		return "Reaction [num=" + num + ", dateReaction=" + getDateReactionString() + ", reaction=" + reaction + ", user=" + user
				+ ", news=" + news + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) 	return false;
		Reaction other = (Reaction) obj;
		if (news == null) {
			if (other.news != null) return false;
		} else if (!news.equals(other.news)) return false;
		if (reaction != other.reaction) return false;
		if (user == null) {
			if (other.user != null) return false;
		} else if (!user.equals(other.user)) return false;
		return true;
	}

	
    

}
