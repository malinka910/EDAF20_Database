package kookies.view;

import javafx.fxml.FXML;
import kookies.MainApp;
import kookies.model.Database;

public class MenuController {
	
	private Database db = new Database();
	private MainApp mainApp;
	
	public MenuController(){
		
	}
	
	@FXML
	private void initialize(){
		db.connect();
		
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}

}
