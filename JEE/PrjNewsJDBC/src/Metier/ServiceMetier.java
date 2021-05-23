package Metier;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.*;

public class ServiceMetier {
	
	private static ArrayList<News> listNews ; 
	private static ArrayList<Reaction> listReactions; 
	private static ArrayList<User> listUsers ;
	
	static {
		try {
			listUsers=ServiceDao.getAllUser();
			listNews=ServiceDao.getAllNews();
			listReactions=ServiceDao.getAllReaction();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    // Constructeur et setters
	public ServiceMetier ()  {}
	
	public static ArrayList<News> getListNews() {
		return listNews;
	}
	public static ArrayList<Reaction> getListReactions() {
		return listReactions;
	}
	public static ArrayList<User> getListUsers() {
		return listUsers;
	}

	public static void setListUsers(ArrayList<User> listUsers) {
		ServiceMetier.listUsers = listUsers;
	}

	// Methodes metiers
	public static User getUserByEmail(String email) {
			for(User user:listUsers) {
				if (user.getEmail().equals(email)) return user;
			}
			return null;
	}
	public static User getUser(String email, String motPasse) {
			for(User user:listUsers) {
				if (user.getEmail().equals(email) && 
					user.getMotPasse().equals(motPasse)	) return user;
			}
			return null;
	}
	public static News getNewsByUrl(String url) {
		for(News news:listNews) {
			if (news.getUrl().equals(url)	) return news;
		}
		return null;
	}
	
	public static ArrayList<String> getAllUrl() {
		ArrayList<String> urls= new ArrayList<String>();
		for(News news:listNews) {
			urls.add(news.getUrl());
		}
		return urls;
	}
	
	public static ArrayList<News> getNewsCreateByUser(User user){
		ArrayList<News> lesNews= new ArrayList<News>();
		for(News news:listNews) {
			  if (news.getCreateur().equals(user)) 
				  lesNews.add(news);
			 
		}
		return lesNews;
	}
	public static ArrayList<Reaction> getReactionByUser(User user){
		ArrayList<Reaction> lesReaction= new ArrayList<Reaction>();
		for(Reaction reaction:listReactions) {
			  if (reaction.getUser().equals(user)) 
				  lesReaction.add(reaction);
			 
		}
		return lesReaction;
	}
	public static ArrayList<Reaction> getReactionByNews(News news){
		ArrayList<Reaction> lesReaction= new ArrayList<Reaction>();
		for(Reaction reaction:listReactions) {
			  if (reaction.getNews().equals(news)) 
				  lesReaction.add(reaction);
			 
		}
		return lesReaction;
	}
	public static int getNombreJaime(News news){
		int nombreJaime=0;
		for(Reaction reaction:listReactions) {
			  if (reaction.getNews().equals(news)
					&& reaction.getReaction()   ) 
				  nombreJaime++;	 
		}
		return nombreJaime;
	}
	public static int getNombreJeDeteste(News news){
		int nombreJeDeteste=0;
		for(Reaction reaction:listReactions) {
			  if (reaction.getNews().equals(news)
					&& !reaction.getReaction()   ) 
				  nombreJeDeteste++;	 
		}
		return nombreJeDeteste;
	}
	public static void addUser(User user) throws UserExistant, SQLException {
		if ( getUserByEmail(user.getEmail())!= null)
			throw new UserExistant("Utilisateur exist déja");
		listUsers.add(user);
		ServiceDao.addUserDao(user);
	}
	
	public static void addReaction(Reaction reaction) throws SQLException {
		boolean trouve=false;
		for(Reaction react:listReactions) {
		  if (react.equals(reaction)) {
			react.setReaction(reaction.getReaction());
			trouve =true;
		  }
		}
		if (!trouve) {
			listReactions.add(reaction);
			ServiceDao.addReaction(reaction);
		}
		else {
			
		}
		
	}
	
	public static boolean addNews(News news) throws NewsExistant, SQLException {
		if ( getNewsByUrl(news.getUrl())!= null)
			throw new NewsExistant("News exixt déja");
		listNews.add(news);
		ServiceDao.addNews(news);
		return true;
	}
	
	
	
	
}
