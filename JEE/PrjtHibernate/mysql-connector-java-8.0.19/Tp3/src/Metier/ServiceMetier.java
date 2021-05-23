package Metier;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.ServiceDao;

public class ServiceMetier {
  private static ArrayList<User> listUsers = new ArrayList<User>() ; 
  private static ArrayList<News> listNews = new ArrayList<News>();
  private static ArrayList<Reaction> listReactions = new ArrayList<Reaction>();
  static {
	  try {
		listUsers = ServiceDao.getAllUsers() ;
		listNews = ServiceDao.getAllNews() ;
		listReactions = ServiceDao.getAllReaction() ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public ServiceMetier() {
	  
  }
public static ArrayList<User> getListUsers() throws SQLException {
	if(listUsers==null) {
		listUsers = ServiceDao.getAllUsers() ;
	}
	return listUsers;
}
public static void addUser(User user) throws SQLException {
	ServiceDao.addUserDao(user);
	listUsers.add(user);
}



public static ArrayList<News> getListNews() throws SQLException {
	if(listNews==null) {
		listNews = ServiceDao.getAllNews() ;
	}
	
	return listNews;
}
public static void addNewsDao(News news) throws SQLException {
	ServiceDao.addNewsDao(news);
	listNews.add(news);
}

public static void setListNews(ArrayList<News> listNews) {
	ServiceMetier.listNews = listNews;
}
public static ArrayList<Reaction> getListReactions() throws SQLException {
    if(listReactions ==null) {
    	listReactions = ServiceDao.getAllReaction() ;
    }
	return listReactions;
	
}
public static void addReactionDao(Reaction reaction) throws SQLException {
	ServiceDao.addReactionDao(reaction);
	listReactions.add(reaction);
}
public static void setListReactions(ArrayList<Reaction> listReactions) {
	ServiceMetier.listReactions = listReactions;
}
  public static User getUser(String email) {
	  for(User user : listUsers) 
	  {
		  if(user.getEmail().equals(email))
			  return user ; 
	  }
	  return null ;
  }
  public static News getNews(String url) {
	  for(News nw : listNews) 
	  {
		  if(nw.getUrl().equals(url))
			  return nw ; 
	  }
	  return null ;
  }
  public static User getUser(String email , String pw) {
	  for(User user : listUsers) 
	  {
		  if(user.getEmail().equals(email) && user.getMotPasse().equals(pw))
			  return user ; 
	  }
	  return null ;
  }
  public static News  getNewsByUrl(String url) {
	  for (News news : listNews) {
		  if(news.getUrl().equals(url))
			  return news ; 
	}
	  return null ;
  }
  public static ArrayList<String> getAllUrl(){
	  ArrayList<String> urls = new ArrayList<String>();
	  for(News news : listNews) {
		  urls.add(news.getUrl()) ; 
	  }
	  return urls ;
  }
 
  public static void addReaction(Reaction react) throws SQLException {
	  boolean trouve = false ;
	  for(Reaction R : listReactions) {
		  if(R.getUser().equals(react.getUser())&& R.getNews().equals(react.getNews())) {
			R.setReaction(react.getReaction());
			trouve = true ;
		  }
	  }
 if(!trouve) {
	  listReactions.add(react) ;
	  ServiceDao.addReactionDao(react);
 }
 else {
	 ServiceDao.updateReaction(react);
 }
  }
  public static int getNombresJeDeteste(News news) {
	  int  i = 0 ;
	  for(Reaction react : listReactions) {
		  if(!react.getReaction()&&react.getNews().equals(news)) i++ ;
	  }
	  return  i ; 
  }
  public static  int getNombreslike(News news) {
	  int  i = 0 ;
	  for(Reaction react : listReactions) {
		  if(react.getReaction()&& react.getNews().equals(news)) i++ ;
	  }
	  return  i ; 
  }
  public ArrayList<News> getNewsCreateByUser(User user) throws SQLException{
	  ArrayList<News> listN = new ArrayList<News>() ;
	  for(News news : listNews) {if(news.getCreateur().equals(user)) listN.add(news) ;}
	  return listN ; 
  }
  public static ArrayList<Reaction> getReactionByUser(User user) throws SQLException{
	  ArrayList<Reaction> rs = new ArrayList<Reaction>();
	  for(Reaction react : listReactions) {if(react.getUser().equals(user))  rs.add(react) ; }
	  return rs ;
  }
  public static ArrayList<Reaction> getReactionByNews(News news){
	  ArrayList<Reaction> listreact = new ArrayList<Reaction>() ;
	  for(Reaction react : listReactions) {if(react.getNews().equals(news)) listreact.add(react) ; }
	  return listreact ;
  }
}
