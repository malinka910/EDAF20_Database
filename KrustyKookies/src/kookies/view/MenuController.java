package kookies.view;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import kookies.MainApp;
import kookies.model.Database;

public class MenuController {
	
	private Database db = new Database();
	private MainApp mainApp;
	
	@FXML
	private MenuItem close;
	@FXML
	private MenuItem production;
	@FXML
	private MenuItem orders;
	@FXML
	private MenuItem storage;
	
	public MenuController(){
		
	}
	
	@FXML
	private void initialize(){
		db.connect();
		
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	
	@FXML
	private void close(){
		try {
			mainApp.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void productionScreen(){
		System.out.println("menu controller");
		mainApp.initRootLayout();
		mainApp.loadProductionScreen();
		System.out.println("menu controller");
	}
	
	@FXML
	private void ordersScreen(){
		System.out.println("menu controller");
		mainApp.initRootLayout();
		mainApp.loadOrderScreen();
		System.out.println("menu controller");
	}
	
	@FXML
	private void storageScreen(){
		System.out.println("menu controller");
		mainApp.initRootLayout();
		mainApp.loadStorageScreen();
		System.out.println("menu controller");
	}
	
	

}
