package kookies.view;



import java.util.List;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import kookies.MainApp;
import kookies.model.Database;
import kookies.model.Order;



public class OrderController {
	
	private Database db = new Database();
	private List<Order> orderList;
	private MainApp mainApp;
	
	
	
	@FXML
	private Button Delete;
	@FXML
	private Button Delivered;	
	@FXML
	private Button Confirm;	
	@FXML
	private ListView<String> Orders;
	@FXML
	private ListView<String> OrdersInfo;
	@FXML
	private TextField date;
	@FXML
	private TextField AlNbr;
	@FXML
	private TextField AmNbr;
	@FXML
	private TextField BerNbr;
	@FXML
	private TextField NcNbr;
	@FXML
	private TextField NrNbr;
	@FXML
	private TextField TanNbr;
	@FXML
	private ChoiceBox<String> CustomerName;
	@FXML
	private GridPane gridPane;

	public OrderController(){
		
	
	}
	
	@FXML
	public void initialize(){
		db.connect();
		
		
		
	}
	
	/////x.kcjvhxlkcjhvxkjhvkjxhvkljdhf
	
	
	public void setMainApp(MainApp mainApp) {
	this.mainApp= mainApp;
		
	}

}
