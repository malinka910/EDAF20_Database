package kookies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private ObservableList<String> cookieName = FXCollections.observableArrayList();//temp
	
	public ProductionController(){
		
	}
	
	@FXML
	private void initialize(){
		
		cookieName.add(("Nut Ring"));
		cookieName.add(("Nut Cookie"));
		cookieName.add(("Tango"));
		cookieName.add(("Amneris"));
		cookieName.add(("Almond Delight"));
		cookieName.add(("Berliner"));		
	}
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		cookies.setItems(cookieName);
		
	}

}
