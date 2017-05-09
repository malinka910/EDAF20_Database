package kookies;

import kookies.model.Cookie;
import kookies.model.Database;
import kookies.model.Ingredient;

public class TestMain {

	public static void main(String[] args) {

		Database db = new Database();
		
		db.connect();
		
		for(Cookie c : db.getCookieList()){
			
			System.out.println(c.getName() + ": ");
			
			for(Ingredient i : c.getRecipe()){
				
				System.out.println("     " + i.getName() + " : " + i.getAmount());
				
			}
			
		}
		db.closeConnection();	
	}

}
