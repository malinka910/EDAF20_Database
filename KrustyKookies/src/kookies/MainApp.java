package kookies;


import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kookies.model.Cookie;
import kookies.model.Database;
import kookies.model.Ingredient;
import kookies.view.MenuController;
import kookies.view.OrderController;
import kookies.view.ProductionController;
import kookies.view.StorageController;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	private MenuController menuController;
	private ArrayList<Ingredient> list = new ArrayList<Ingredient>();//temp

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Krusty Kookies");
		
		initRootLayout();
		
		loadProductionScreen();
		Database db = new Database();
	}
	
	public void initRootLayout(){
		try{
			//FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/RootLayout.fxml"));
			
			System.out.println("root layout path");
			rootLayout = (BorderPane) loader.load();
			System.out.println("root layout loaded");
			
			menuController = loader.getController();
			menuController.setMainApp(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			System.out.println("scene made");
			primaryStage.show();
			System.out.println("scene shown");
		}catch(IOException e){
			System.out.println("ROOT LAYOUT EXCEPTION");
			//e.printStackTrace();
		}
	}
	
	public MainApp(){
		
	}
	
	public void loadProductionScreen(){
		try{
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ProductionScreen.fxml"));
			AnchorPane productionScreen = (AnchorPane) loader.load();
			rootLayout.setCenter(productionScreen);
			ProductionController controller = loader.getController();
			controller.setMainApp(this);
		}catch(IOException e){
			System.out.println("PRODUCTION SCREEN EXCEPTION");
		}
	}
	
	public void loadStorageScreen(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/StorageScreen.fxml"));
			AnchorPane StorageScreen = (AnchorPane) loader.load();
			rootLayout.setCenter(StorageScreen);
			StorageController controller = loader.getController();
			controller.setMainApp(this);
		}catch(IOException e){
			System.out.println("STORAGE SCREEN EXCEPTION");
		}
	}
	
	public void loadOrderScreen(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/OrderScreen.fxml"));
			AnchorPane OrderScreen = (AnchorPane) loader.load();
			rootLayout.setCenter(OrderScreen);
			OrderController controller = loader.getController();
			controller.setMainApp(this);
		}catch(IOException e){
			System.out.println("ORDER SCREEN EXCEPTION");
		}
	}
	
	
	
	
	public Stage getPrimaryStage() {
        return primaryStage;
    } 
    
	public static void main(String[] args) {
		launch(args);
	}
}
