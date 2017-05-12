package kookies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kookies.model.Cookie;
import kookies.model.Database;

public class ProductionController {
	
	Database db = new Database();
	
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
		
//		cookieName.add(("Nut Ring"));
//		cookieName.add(("Nut Cookie"));
//		cookieName.add(("Tango"));
//		cookieName.add(("Amneris"));
//		cookieName.add(("Almond Delight"));
//		cookieName.add(("Berliner"));	
		
		/**updateCookieName*/
		db.connect();
		for(Cookie c : db.getCookieList()){
			cookieName.add(c.getName());
		}
		db.disconnect();
		
	}
	@FXML
	private void updateCookieName(){
	
		
	}
	
	public void setMainApp(MainApp mainApp){
		
		this.mainApp = mainApp;
		cookies.setItems(cookieName);
		
	}

}
