package kookies.view;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kookies.MainApp;
import kookies.model.Cookie;
import kookies.model.Database;
import kookies.model.Ingredient;
import kookies.model.IngredientFactory;

public class ProductionController {
	
	private Database db = new Database();
	private List<Cookie> cookieList;
	private List<Ingredient> ingredientStockList;
	private Cookie currentCookie;
	private String currentIngredient;
	private MainApp mainApp;
	private ObservableList<String> cookieName = FXCollections.observableArrayList();
	private ObservableList<String> cookieRecipe = FXCollections.observableArrayList();
	private ObservableList<String> ingredientStock = FXCollections.observableArrayList();
	
	@FXML
	private Button add;
	@FXML
	private Button produce;	
	@FXML
	private ListView<String> ingredients;
	@FXML
	private ListView<String> cookies;
	@FXML
	private ListView<String> recipes;
	@FXML
	private TextField text;
	

	public ProductionController(){
		
	}
	
	@FXML
	private void initialize(){
		
		db.connect();
		
		cookieList = db.getCookieList();
		for(Cookie c : cookieList){
			cookieName.add(c.getName());
		}
		
		updateIngredientList();
		
		db.disconnect();
		
		cookies.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        cookieSelected(newValue);
		    }
		});
		
		ingredients.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        if(newValue == null){
		        	//do nothing
		        }else{
		        	currentIngredient = newValue.substring(newValue.indexOf(" ")+1);
		        }
		    }
		});
		
	}
	
	private void cookieSelected(String cookieName){
		//currentCookie = cookieName;
		cookieRecipe.clear();
		Cookie cookie = null; 
		for(Cookie c : cookieList){
			if(c.getName().equals(cookieName)){
				cookie = c;
			}
		}
		for(Ingredient i : cookie.getRecipe()){
			cookieRecipe.add(i.getAmount() + i.getUnit() + " " + i.getName());
		}
		currentCookie = cookie;
		recipes.setItems(cookieRecipe);
	}
	
	@FXML
	private void addButtonClicked(){
		double amount = Double.parseDouble(text.getText());
		db.ingredientStockDelivery(amount, currentIngredient);
		updateIngredientList();
	}
	
	@FXML
	private void produceButtonClicked(){
		System.out.println("Produce Button");
		if(checkStock(currentCookie)){
			System.out.println(checkStock(currentCookie));
			db.palletProducetion(currentCookie);
			updateIngredientList();
		}else{
			System.out.println("Not enough ingredients in stock to produce a pallet of " + currentCookie.getName());
		}
	}
	
	private void updateIngredientList(){
		ingredientStockList = db.getIngredientStock();
		ingredientStock.clear();
		for(Ingredient i : ingredientStockList){
			ingredientStock.add(i.getAmount() + i.getUnit() +" " + i.getName());
		}
		ingredients.setItems(ingredientStock);
	}
	
	private boolean checkStock(Cookie cookie){
		for(Ingredient recipeIngredient: cookie.getRecipe()){
			for(Ingredient stockIngredient: ingredientStockList){
				if(recipeIngredient.getName().equals(stockIngredient.getName())){
					System.out.println(recipeIngredient.getName() + ": " + recipeIngredient.getAmount());
					System.out.println(stockIngredient.getName() + ": " + stockIngredient.getAmount());
					if(recipeIngredient.getAmount() > stockIngredient.getAmount()){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		cookies.setItems(cookieName);
		
	}

}
