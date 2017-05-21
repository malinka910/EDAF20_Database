package kookies.view;

import kookies.MainApp;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import kookies.MainApp;
import kookies.model.Database;
import kookies.model.Load;
import kookies.model.Order;
//import kookies.model.Storage;
import kookies.model.Pallet;



public class StorageController {

	private Database db = new Database();
	private MainApp mainApp;
	
	private Pallet currentPallet;
	private Order currentOrder;
	private Load currentLoadingOrder;
	
	private ObservableList<String> obLocationsBox = FXCollections.observableArrayList();
	private ObservableList<String> obCookieTypeBox = FXCollections.observableArrayList();
	private ObservableList<String> obCustomerBox = FXCollections.observableArrayList();
	
	private ObservableList<String> observablePallets = FXCollections.observableArrayList();
	private ObservableList<String> observablePalletsInfo = FXCollections.observableArrayList();
	private ObservableList<String> observableOrders = FXCollections.observableArrayList();
	private ObservableList<String> observableLoadingOrders = FXCollections.observableArrayList();
	
	private List<Pallet> dbPalletList;
	private List<Order> dbOrderList;
	private List<Load> dbLoadingOrderList;
	
	@FXML
	private Button showPalletsButton;
	@FXML
	private Button blockPalletsButton;
	@FXML
	private Button addPalletsButton;
	@FXML
	private Button removePalletsButton;
	@FXML
	private Button showOrdersButton;
	@FXML
	private Button showPalletsFromOrderButton;
	@FXML
	private Button addOrdersButton;
	@FXML
	private Button newLoadingOrderButton;	
	@FXML
	private Button sendOutOrdersButton;		
	
	@FXML
	private ListView<String> palletList;
	@FXML
	private ListView<String> palletInfoList;
	@FXML
	private ListView<String> activeOrdersList;
	@FXML
	private ListView<String> loadingOrdersList;
	
	@FXML
	private CheckBox blockedCheckBox;
	@FXML
	private CheckBox palletLLCheckBox;
	@FXML
	private CheckBox palletULCheckBox;
	@FXML
	private CheckBox orderLLCheckBox;
	@FXML
	private CheckBox orderULCheckBox;
	
	
	@FXML
	private TextField palletLLField;
	@FXML
	private TextField palletULField;
	@FXML
	private TextField orderLLField;
	@FXML
	private TextField orderULField;
	@FXML
	private TextField palletNbrField;
	
	@FXML
	private ChoiceBox<String> locationChoiceBox;
	@FXML
	private ChoiceBox<String> cookieTypeChoiceBox;
	@FXML
	private ChoiceBox<String> customerChoiceBox;


	public StorageController(){
		
	}
	
	
	@FXML
	public void initialize(){
		db.connect();
		
		
		
	}
	
	
	public void initRootLayout(){
		
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}

}
