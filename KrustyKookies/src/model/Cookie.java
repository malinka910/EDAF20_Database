package model;

import java.util.ArrayList;
import java.util.List;

public class Cookie {
	
	private ArrayList<Ingredient> recipe;
	private String name;
	
	public Cookie(String name, List<Ingredient> recipeIngredients){
		 recipe = new ArrayList<Ingredient>();
		 recipe.addAll(recipeIngredients);
		 this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public List<Ingredient> getRecipe(){
		return recipe;
	}

}
