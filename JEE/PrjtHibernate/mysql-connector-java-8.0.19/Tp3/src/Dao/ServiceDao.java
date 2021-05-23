package Dao;

import java.sql.*;
import java.util.ArrayList;

import Metier.*;

public class ServiceDao {
	private static Connection connection = Connexion.getConnection() ;
	private static PreparedStatement ps ;
	private static PreparedStatement psR ; 
	private static PreparedStatement psN; 
	static {
		
		try {
			psN = connection.prepareStatement("insert into news (dateNews,titre ,url,email)values (?,?,?,?)") ;
			psR = connection.prepareStatement("insert into reaction (num, dateReaction,reaction,email,url) values ("
					+ "null,?,?,?,?)") ;
			ps = connection.prepareStatement("insert into user (email , nomPrenom,motPasse) values (?,?,?) ") ;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	public static void addUserDao(User user) throws SQLException {
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getNomPrenom());
		ps.setString(3, user.getMotPasse());
		ps.executeUpdate() ;
	}
	public static void addReactionDao(Reaction reaction) throws SQLException {
		psR.setString(1,  reaction.getDateFormatter1());
		psR.setBoolean(2, reaction.getReaction());
		psR.setString(3, reaction.getUser().getEmail());
		psR.setString(4, reaction.getNews().getUrl());
		psR.executeUpdate() ;
		
	}

	public static void addNewsDao(News news) throws SQLException {
		psN.setString(1, news.getDateFormatter1());
		psN.setString(2, news.getTitre());;
		psN.setString(3, news.getUrl());
		psN.setString(4, news.getCreateur().getEmail() );
		psN.executeUpdate() ;
	}
	
	public static ArrayList<Reaction> getAllReaction() throws SQLException{
		ArrayList<Reaction> reactions = new ArrayList<Reaction>() ;
		Statement st = connection.createStatement() ;
		ResultSet rs = st.executeQuery("select * from reaction");
		while (rs.next()) {
			Reaction reaction =new Reaction() ;
			reaction.setNews(ServiceMetier.getNewsByUrl(rs.getString("url")));
			reaction.setNum(rs.getInt("num"));
			reaction.setUser(ServiceMetier.getUser(rs.getString("email")));
			reaction.setReaction(rs.getBoolean("reaction"));
			reactions.add(reaction);			
		}
		return reactions ;
	}
	public static void updateReaction(Reaction react) throws SQLException {
		Statement st = connection.createStatement() ; 
		st.executeUpdate("update table reaction set reaction = '" +react.getReaction()+ "' where num = "+react.getNum()+ "");
	    
	}
	
	public static ArrayList<User> getAllUsers() throws SQLException{ 
		ArrayList<User> users = new ArrayList<User>() ;
		Statement st = connection.createStatement() ; 
		ResultSet rs = st.executeQuery("Select * FROM user") ; 
		while(rs.next() ) {
			User user = new User() ;
			user.setEmail(rs.getString("email"));
			user.setNomPrenom(rs.getString("nomPrenom"));
			user.setMotPasse(rs.getString("motPasse"));
			users.add(user) ;
		}
		
		return users ;
	}
	public static ArrayList<News> getAllNews() throws SQLException{
		ArrayList<News> ns =new ArrayList<News>();
		Statement st = connection.createStatement() ;
		ResultSet rs = st.executeQuery("select * from news") ;
		while (rs.next()) {
			News news = new News() ;
			news.setDateNews(rs.getDate("dateNews"));
			news.setTitre(rs.getString("titre"));
			news.setUrl(rs.getString("url"));
			news.setCreateur(ServiceMetier.getUser(rs.getString("email")));
			ns.add(news);
			
		}
		return ns ;
	}

}
