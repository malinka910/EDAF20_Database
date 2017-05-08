package kookies.model;

import java.util.ArrayList;

public class IngredientFactory {
	
	private ArrayList<String> volumeCookies = new ArrayList<String>();
	
	public IngredientFactory(){
		volumeCookies.add("eggs");
		volumeCookies.add("egg whites");
	}
	
	public Ingredient buildIngredientObject(String name, double amount){
		if(volumeCookies.contains(name)){
			return new VolumeIngredient(name, amount);
		}else{
			return new MassIngredient(name, amount);
		}
	}

}
