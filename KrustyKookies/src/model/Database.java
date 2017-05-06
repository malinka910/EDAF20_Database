package model;
	
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
	/**
	 * Database is a class that specifies the interface to the 
	 * movie database. Uses JDBC and the MySQL Connector/J driver.
	 */
	public class Database {
		
	    /** The database connection. */
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
	                ("jdbc:mysql://localhost/krusty_kookies",
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
	    
	    public List<Cookie> getCookieList(){
	    	//TODO make it do things
	    	return new ArrayList<Cookie>();
	    }
	    
	    public List<Ingredient> getIngredientList(){
	    	//TODO
	    	return new ArrayList<Ingredient>();
	    }

}
