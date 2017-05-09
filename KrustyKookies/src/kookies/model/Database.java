package kookies.model;
	
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
	    	//Connection conn = null;
	    	try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn = DriverManager.getConnection 
	                ("jdbc:mysql://localhost/krusty_kookies",
	                 "Greg", "");
	    	//System.out.println("Connection Established");
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
	                ("jdbc:mysql://localhost/krusty_kookies", userName, password);
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
	    	ArrayList<Cookie> cookieList = new ArrayList<Cookie>();
	    	String cookies = "select * from cookies;";
	    	Statement statement = null;
	    	
	    	try{

	    		statement = conn.createStatement();	    		
	    		//System.out.println(conn.isClosed());
	    		ResultSet cookieListRS = statement.executeQuery(cookies);
	    		while(cookieListRS.next()){
	    			cookieList.add(new Cookie(cookieListRS.getString(1)));
	    		}
	    		cookieListRS.close();
	    		statement.close();
	    		for(Cookie c : cookieList){
	    			System.out.println(c.getName());
	    		}
	    	}catch(SQLException e){
	    		e.printStackTrace();
	    	}
	    	for(Cookie c : cookieList){
	    		c.addRecipe(getRecipe(c.getName()));
	    	}
	    	return cookieList;
	    }
	    
	    private List<Ingredient> getRecipe(String cookie){
	    	StringBuilder builder = new StringBuilder();
	    	builder.append("'");
	    	builder.append(cookie);
	    	builder.append("'");
	    	IngredientFactory factory = new IngredientFactory();
	    	ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
	    	String recipeByCookie = "select * from recipes where cookieName ="+builder.toString()+ ";";
	    	Statement statement = null;
	    	
	    	try{
	    		statement = conn.createStatement();
	    		ResultSet recipeRS = statement.executeQuery(recipeByCookie);
	    		while(recipeRS.next()){
	    			recipe.add(factory.buildIngredientObject(recipeRS.getString(2), recipeRS.getDouble(3)));
	    		}
	    		recipeRS.close();
	    		statement.close();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return recipe;
	    }

}
