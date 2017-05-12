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

public class ProductionController {
	
	private Database db = new Database();
	private List<Cookie> cookieList;
	private String currentCookie;
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
		
		List<Ingredient> stock = db.getIngredientStock();
		for(Ingredient i : stock){
			ingredientStock.add(i.getAmount() + i.getUnit() +" " + i.getName());
		}
		
		db.disconnect();
		cookies.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        // Your action here
		        //System.out.println("Selected item: " + newValue);
		        cookieSelected(newValue);
		    }
		});
	}
	@FXML
	private void updateCookieName(){
	
		System.out.println("cookie update");
		
	}
	
	@FXML
	private void cookieSelected(String cookieName){
		currentCookie = cookieName;
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
		recipes.setItems(cookieRecipe);
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		cookies.setItems(cookieName);
		ingredients.setItems(ingredientStock);
	}

}
