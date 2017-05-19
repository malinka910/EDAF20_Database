package kookies;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kookies.model.Cookie;
import kookies.model.Customer;
import kookies.model.Database;
import kookies.model.Ingredient;
import kookies.model.Order;
import kookies.model.Pallet;
import kookies.model.TimeStamp;

public class TestMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Database db = new Database();
		TimeStamp timeStamp = new TimeStamp();
		db.connect();
		
		@SuppressWarnings("rawtypes")
		ArrayList<Cookie> cookies = new ArrayList();
		cookies.addAll(db.getCookieList());
		Customer customer = new Customer("Smabrod AB", "Malmo");
		ArrayList<Integer> palletTotals = new ArrayList<Integer>();
		for(int i = 1 ; i < 7 ; i++){
			palletTotals.add((Integer) i);
		}
		String date = timeStamp.makeTimeStamp().substring(0,10);
		Order testOrder = new Order(customer,date);
		testOrder.setOrderNbr(1);
		testOrder.setPalletTotals(cookies, palletTotals);
		
//		for(int i = 0; i < 6; i++){
//			System.out.println(testOrder.getPalletTotals()[i]);
//		}
		
		List<Pallet> pallets = new ArrayList<Pallet>();
		
		for(int k = 1 ; k < 60 ; k++){
			pallets.add(new Pallet(k, cookies.get(k%6), "2017-10-10"));
			//System.out.println(k + " " + k%6 + " " + cookies.get(k%6).getName());
		}
		
		for(Pallet p : pallets){
			testOrder.addPalletToOrder(p);
		}
		
		List<String> orderInfo = testOrder.getOrderDetails();
		
		for(String s : orderInfo){
			System.out.println(s);
		}
		db.placeOrder(testOrder);
		db.closeConnection();
		
//		db.connect();
//		
//		System.out.println(db.ingredientStockDelivery(100.00, "Butter"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Sugar"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Flour"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Chocolate"));
//		System.out.println(db.ingredientStockDelivery(100.00, "Dummy"));
//		
//		db.closeConnection();	
		
//		Scanner scan = new Scanner(System.in);
//		
//		TimeStamp ts = new TimeStamp();
//		boolean cont = true;
//		while(cont){
//			ts.makeTimeStamp();
//			System.out.println("continue? (y/n) "); 
//			if(scan.next().equals("n")){
//				cont = false;
//			}
//		}
		
	}

}
