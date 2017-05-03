package datamodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Database is a class that specifies the interface to the 
 * movie database. Uses JDBC and the MySQL Connector/J driver.
 */
public class Database {
    /** 
     * The database connection.
     */
    private Connection conn;
    
        
    /**
     * Create the database interface object. Connection to the database
     * is performed later.
     */
    public Database() {
        conn = null;
    }
    
    public Connection connect(){
    	Connection conn = null;
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection 
                ("jdbc:mysql://localhost/Lab_database",
                 "Greg", "");
    	}catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
           
        }
        catch (ClassNotFoundException e) {
            System.err.println(e);
            e.printStackTrace();
            
        }
    	return conn;
    }
    
    public void disconnect(){
    	
    }
        
    /** 
     * Open a connection to the database, using the specified user name
     * and password.
     *
     * @param userName The user name.
     * @param password The user's password.
     * @return true if the connection succeeded, false if the supplied
     * user name and password were not recognized. Returns false also
     * if the JDBC driver isn't found.
     */
    public boolean openConnection(String userName, String password) {
        try {
        	//"jdbc:mysql://puccini.cs.lth.se/ + userName"
        	//"jdbc:mysql://" + serverName + "/" + mydatabase;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection 
                ("jdbc:mysql://localhost/Lab_database", userName, password);
        }
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e) {
            System.err.println(e);
            e.printStackTrace();
            return false;
        }
        return true;
    }
        
    /**
     * Close the connection to the database.
     */
    public void closeConnection() {
        try {
            if (conn != null)
                conn.close();
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
        conn = null;
        
        System.err.println("Database connection closed.");
    }
        
    /**
     * Check if the connection to the database has been established
     *
     * @return true if the connection has been established
     */
    public boolean isConnected() {
        return conn != null;
    }
	/**
	 * GET THE SHOW DETAILS
	 * @param mTitle
	 * @param mDate
	 * @return
	 */
  	public Show getShowData(String mTitle, String mDate) {
		Integer mFreeSeats = null;
		String mVenue = null;
		
		Show showing;
		
		PreparedStatement showings = null;
		
		try {
			/* Make ALL the statements */ 
			String showingString = "select * from showing where movie = ? and showday = ?";
			
			showings = conn.prepareStatement(showingString);
			showings.setString(1, mTitle);
			showings.setString(2, mDate);
			
			
			/* Get number of bookings */
			
			/* get theater and free seats number */
			ResultSet showingResults = showings.executeQuery();
			if(showingResults.next()){
				mVenue = showingResults.getNString("theaterName");
				mFreeSeats = showingResults.getInt("freeSeats");
				
			}
			showings.close();
			showingResults.close();
		} catch (SQLException e){
			// nothing I can to to fix this 
		}finally{
			System.out.println(mFreeSeats);
			/*try{
			bookings.close();
			}catch(SQLException e){
				//nothing I can do
			}
			System.out.println(mFreeSeats);
			System.out.println(mVenue);
			System.out.println(nBooked);
			System.out.println(nSeats);*/
		}
		showing = new Show(mTitle, mDate, mVenue, mFreeSeats);
		return showing;
		
	}
  	
  	/**
  	 * See if the user name exists.
  	 * @param userName
  	 * @return true if the user name exists
  	 */
  	public boolean login(String userName){
  		PreparedStatement  login = null;
  		//String injection = "select * from users where userName = " + userName;
  		String loginString = "select * from users where userName = ?";
  		try {
			login = conn.prepareStatement(loginString);
			login.setString(1, userName);
			ResultSet rs = login.executeQuery();
			if(rs.next()){
				//String uName = rs.getNString(userName);
				//System.out.println(uName);
				rs.close();
				login.close();
				return true;
			}else{
				rs.close();
				login.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
  		return false;
  	}
  	/**
  	 * GET MOVIE LIST!!!!
  	 * @return
  	 * @throws SQLException
  	 */
  	public List<String> getMovies() throws SQLException{
  		List<String> movieList = new ArrayList<String>();
  		try{	
  				String movieString = "select distinct movie from showing";
  				Statement movies = conn.createStatement();
  				ResultSet list = movies.executeQuery(movieString);
  				while(list.next()){
  					movieList.add(list.getString(1));
  				}
  				movies.close();
  				list.close();
  		} catch (SQLException e) {
			e.printStackTrace();
		}
  		return movieList;
  	}
  	
  	/**
  	 * GET DATE LIST!!!
  	 * @param movie
  	 * @return
  	 */
  	public List<String> getDates(String movie){
  		List<String> dateList = new ArrayList<String>();
  		try{
  			//dateList.add("Got to the try");
  			String movieString = "select DATE(showday) from showing where movie = '" + movie +"'";
			Statement dates = conn.createStatement();
			ResultSet list = dates.executeQuery(movieString);
			while(list.next()){
			dateList.add(list.getString(1));
			}
  			dates.close();
  			list.close();
  		} catch (SQLException e) {
  			System.out.println("SQLException thrown");
			//e.printStackTrace();
  		}
  		return dateList;
  	}

  	/**
  	 * MAKA DA BOOKINGU!!!
  	 * @param uName
  	 * @param movie
  	 * @param date
  	 * @return
  	 */
  	public int makeBooking(String uName, String movie , String date){
  		int bookingNbr = 0;
  		String bookingString = "Select MAX(nbr) from bookings where movie = ? and showday = ?";
  		try{
  			
  			//Try to make a booking
  			String booking = "insert into Bookings values( null, ?, ?, ?)";
  			String seatUpdateString = "update showing set freeSeats = freeSeats - 1 where movie = ? and showday = ?";
  			PreparedStatement book = conn.prepareStatement(booking);
  			book.setString(1, uName);
  			book.setString(2, movie);
  			book.setString(3, date);
  			int n = book.executeUpdate();
  			//If booking doesn't work, return ticket number 0
  			if(n != 1){
  				return bookingNbr;
  			}
  			PreparedStatement booked = conn.prepareStatement(seatUpdateString);
  			booked.setString(1, movie);
  			booked.setString(2, date);
  			int m = booked.executeUpdate();
  			if(m != 1){
  				return 0;
  			}
  			
  			
  			
  		}catch (SQLException e){
  			return bookingNbr;
  		}finally{
  			try{
  				PreparedStatement reservationNbr = conn.prepareStatement(bookingString);
  				reservationNbr.setString(1, movie);
  				reservationNbr.setString(2, date);
  				ResultSet resNbr = reservationNbr.executeQuery();
  				if(resNbr.next()){
  					bookingNbr = resNbr.getInt(1);
  				}
  			}catch (SQLException e){
  				
  			}
  			
  		}

  	  return bookingNbr;
  	}
  	
  
}
