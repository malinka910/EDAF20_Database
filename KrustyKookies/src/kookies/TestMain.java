package kookies;

import java.security.Timestamp;
import java.util.Scanner;

import kookies.model.Cookie;
import kookies.model.Database;
import kookies.model.Ingredient;
import kookies.model.TimeStamp;

public class TestMain {

	public static void main(String[] args) {

//		Database db = new Database();
//		
//		db.connect();
//		
//		System.out.println(db.ingredientStockDelivery(100.00, "Butter"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Sugar"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Flour"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Chocolate"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Dummy"));
//		
//		db.closeConnection();	
		
		Scanner scan = new Scanner(System.in);
		
		TimeStamp ts = new TimeStamp();
		boolean cont = true;
		while(cont){
			ts.makeTimeStamp();
			System.out.println("continue? (y/n) "); 
			if(scan.next().equals("n")){
				cont = false;
			}
		}
		
	}

}
