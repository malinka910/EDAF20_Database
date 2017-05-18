package kookies.model;

import java.util.ArrayList;

public class IngredientFactory {
	
	private ArrayList<String> volumeCookies = new ArrayList<String>();
	
	public IngredientFactory(){
		volumeCookies.add("Eggs");
		volumeCookies.add("Egg whites");
	}
	
	public Ingredient buildIngredientObject(String name, double amount){
		if(volumeCookies.contains(name)){
			return new VolumeIngredient(name, amount);
		}else{
			return new MassIngredient(name, amount);
		}
	}
	
	public Ingredient parseIngredientString(String toParse){
		String ingredient = toParse.substring(toParse.indexOf(" ")+1);
		String am = toParse.substring(0, toParse.indexOf("("));
		double amount = Double.parseDouble(am);
		return buildIngredientObject(ingredient, amount);
	}

}
