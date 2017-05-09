package kookies;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kookies.model.Database;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Krusty Kookies");
		
		initRootLayout();
		
		showProductionScreen();
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
	
	
	public void showProductionScreen(){
		try{
			//FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(MainApp.class.getResource("view/ProductionScreen.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ProductionScreen.fxml"));
			AnchorPane productionScreen = (AnchorPane) loader.load();
			
			rootLayout.setCenter(productionScreen);
			
		}catch(IOException e){
			System.out.println("PRODUCTION SCREEN EXCEPTION");
			//e.printStackTrace();
		}
	}
	
	
	public Stage getPrimaryStage() {
        return primaryStage;
    } 
    
	public static void main(String[] args) {
		launch(args);
	}
}
