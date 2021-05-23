package Dao;

import java.sql.*;
import java.util.*;
import Metier.*;

public class ServiceDao {
	private static Connection connection;
	private static PreparedStatement psUser;
	private static PreparedStatement psReaction;
	private static PreparedStatement psNews;
	
	static {
		connection= Connexion.getConnection();
		try {
			psUser= connection.prepareStatement(
				 "insert into user values(?,?,?)");
			psReaction=connection.prepareStatement(
					 "insert into reaction values(null, ?,?,?,?)");
			psNews=connection.prepareStatement(
					 "insert into news values(?,?,?,?)");
		} catch (SQLException e) {
			System.out.println(e.getMessage() );
		}
	}
	
	public static ArrayList<User> getAllUser( ) throws SQLException {
		ArrayList<User> users= new ArrayList<User>();
	   	ResultSet rs = connection.createStatement().executeQuery ("Select * from user");
	   	while (rs.next()) {
	   		 User user= new User();
	   		 user.setEmail(rs.getString("email"));
	   		 user.setNomPrenom(rs.getString("nomPrenom"));
	   		 user.setMotPasse(rs.getString("motPasse"));
	   		 users.add(user);
	   	}
	   	rs.close();	 
	   	return users;
	}
	public static ArrayList<News> getAllNews( ) throws SQLException {
		ArrayList<News> newss= new ArrayList<News>();
	   	ResultSet rs = connection.createStatement().executeQuery ("Select * from News");
	   	while (rs.next()) {
	   		 News news= new News();
	   		 news.setUrl(rs.getString("url") );
	   		 news.setTitre(rs.getString("titre"));
	   		 news.setDateInsertion(rs.getDate("dateNews"));
	   		 news.setCreateur(  ServiceMetier.getUserByEmail(rs.getString("email")));
	   		 newss.add(news);
	   	}
	   	rs.close();	 
	   	return newss;
	}
	public static ArrayList<Reaction> getAllReaction( ) throws SQLException {
		ArrayList<Reaction> reactions= new ArrayList<Reaction>();
	   	ResultSet rs = connection.createStatement().executeQuery ("Select * from reaction");
	   	while (rs.next()) {
	   		 Reaction reaction= new Reaction();
	   		 reaction.setNum(rs.getInt("num") );
	   		 reaction.setDateReaction(rs.getDate("dateReaction") );
	   		 reaction.setReaction(rs.getBoolean("reaction") );
	   		 reaction.setUser(ServiceMetier.getUserByEmail(rs.getString("email") ) );
	   		 reaction.setNews(ServiceMetier.getNewsByUrl(rs.getString("url") ) );
	   		 reactions.add(reaction);
	   	}
	   	rs.close();	 
	   	return reactions;
	}
	public static void addUserDao(User user ) throws SQLException {
   	   	 psUser.setString(1, user.getEmail());
	   	 psUser.setString(2, user.getNomPrenom());	
	   	 psUser.setString(3, user.getMotPasse());
	   	 psUser.executeUpdate();
    }
	public static void addReaction(Reaction reaction) throws SQLException { 
		 psReaction.setString(1, reaction.getDateReactionString2());
	   	 psReaction.setBoolean(2, reaction.getReaction());	
	   	 psReaction.setString(3, reaction.getUser().getEmail());
	   	 psReaction.setString(4, reaction.getNews().getUrl());
	   	 psReaction.executeUpdate();
	}
	public static void addNews(News news) throws SQLException { 
		 psNews.setString(1, news.getUrl());
		 psNews.setString(2, news.getTitre());
		 psNews.setString(3, news.getDateInsertionString2());
		 psNews.setString(4, news.getCreateur().getEmail());
		 psNews.executeUpdate();
	}
	
	
	

}
