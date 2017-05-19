package kookies.view;

import kookies.MainApp;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import kookies.MainApp;
import kookies.model.Database;
//import kookies.model.Storage;



public class StorageController {

	private Database db = new Database();
	private MainApp mainApp;
	
	
	
	@FXML
	private Button searchButton;
	@FXML
	private Button addButton;	
	@FXML
	private Button blockButton;	
	@FXML
	private Button sendButton;
	@FXML
	private Button deliveredButton;	
	@FXML
	private ListView<String> LoadNbrs;
	@FXML
	private ListView<String> ordersInLoadingNbrs;
	@FXML
	private ListView<String> palletsInOrder;
	@FXML
	private ListView<String> palletList;
	@FXML
	private CheckBox loadedBox;
	@FXML
	private CheckBox blockedBox;
	
	
	
	@FXML
	private TextField palletSearch;
	@FXML
	private ChoiceBox<String> CookieType;


	public StorageController(){
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}

}
