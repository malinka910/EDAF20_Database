package kookies;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kookies.model.Cookie;

public class ProductionController {
	
	@FXML
	private Button add;
	@FXML
	private Button produce;	
	@FXML
	private ListView<String> ingredients;
	@FXML
	private ListView<String> cookies;
	@FXML
	private ListView<String> recieps;
	@FXML
	private TextField text;
	
	private MainApp mainApp;
	
	public ProductionController(){
		
	}
	
	@FXML
	private void initialize(){
		//lambdauttryck? sätt igång alla listviews 
		
	}
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
	}

}
