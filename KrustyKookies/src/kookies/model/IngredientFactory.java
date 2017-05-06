package kookies.model;

import java.util.ArrayList;

public class IngredientFactory {
	
	private ArrayList<String> volumeCookies;
	
	public IngredientFactory(){
		volumeCookies.add("eggs");
		volumeCookies.add("egg whites");
	}
	
	public Ingredient buildCookieObject(String name, double amount){
		if(volumeCookies.contains(name)){
			return new VolumeIngredient(name, amount);
		}else{
			return new MassIngredient(name, amount);
		}
	}

}
