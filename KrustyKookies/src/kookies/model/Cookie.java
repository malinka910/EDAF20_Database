package kookies.model;

import java.util.ArrayList;
import java.util.List;

public class Cookie {
	
	private ArrayList<Ingredient> recipe;
	private String name;
	
	public Cookie(String name){
		 this.name = name;
	}
	
	public void addRecipe(List<Ingredient> recipeIngredients){
		 recipe = new ArrayList<Ingredient>();
		 recipe.addAll(recipeIngredients);
	}
	
	public String getName(){
		return name;
	}
	
	public List<Ingredient> getRecipe(){
		return recipe;
	}

}
