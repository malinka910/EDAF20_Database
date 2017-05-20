package kookies.view;



import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import kookies.MainApp;
import kookies.model.Customer;
import kookies.model.Database;
import kookies.model.Order;



public class OrderController {
	
	private Database db = new Database();
	private List<Order> orderList;
	private List<Order> orderInfoList; //utförlig info på order 
	private MainApp mainApp;
	private Customer currentCustomer;
	
	private ObservableList<String> observableOrder = FXCollections.observableArrayList();
	private ObservableList<String> observableOrderInfo = FXCollections.observableArrayList();
	
	
	
	@FXML
	private Button delivered;	
	@FXML
	private Button confirm;	
	@FXML
	private ListView<String> orders;
	@FXML
	private ListView<String> ordersInfo;
	@FXML
	private TextField date;
	@FXML
	private TextField alNbr;
	@FXML
	private TextField amNbr;
	@FXML
	private TextField berNbr;
	@FXML
	private TextField ncNbr;
	@FXML
	private TextField nrNbr;
	@FXML
	private TextField tanNbr;
	@FXML
	private ChoiceBox<String> choiceBox;
	@FXML
	private GridPane gridPane;

	public OrderController(){
		
	
	}
	
	@FXML
	public void initialize(){
		db.connect();
		
		orderList = db.getUndeliveredOrders();
		for(Order o: orderList){
			observableOrder.add(String.valueOf(o.getOrderNbr()));
		}
		updateOrderList();
		
		
	}
	
	
	
	private void orderSelected(String orderName){
		//clear orderinfo observablelist
		
		
	}
	//@FXML
	private void choiceBoxSelected(){
		
		//koppla customerName till Customer
	}
	
	@FXML	
	private void deliveredButtonClicked(){
		
		//på selectedOrder
	}
	
	@FXML
	private void confirmButtonClicked(){
		
		Order order = new Order(currentCustomer,date.getText());
		List<Integer> list = new ArrayList<Integer>();
		list.add(Integer.parseInt(alNbr.getText()));
		list.add(Integer.parseInt(amNbr.getText()));
		list.add(Integer.parseInt(berNbr.getText()));
		list.add(Integer.parseInt(ncNbr.getText()));
		list.add(Integer.parseInt(nrNbr.getText()));
		list.add(Integer.parseInt(tanNbr.getText()));
		order.setPalletTotals(db.getCookieList(),list);		
		
		db.placeOrder(order);
		alNbr.clear();
		amNbr.clear();
		berNbr.clear();
		date.clear();
		ncNbr.clear();
		nrNbr.clear();
		tanNbr.clear();
		observableOrder.clear();
		choiceBox.setValue(null);//??
		observableOrderInfo.clear();
		updateOrderList();
		updateOrderInfoList();
		
	}
	
	
	private void updateOrderList(){
		
		orderList = db.getUndeliveredOrders();
		observableOrder.clear();
		for(Order o: orderList){
			observableOrder.add(o.getOrderNbr()+ "  " + o.getExpectedDeliveryDate());
		
		}
		
		orders.setItems(observableOrder);
	}
	
	private void updateOrderInfoList(){
		
		orderInfoList = db.getUndeliveredOrders();
		observableOrderInfo.clear();
		for(Order o: orderList){
			observableOrderInfo.addAll(o.getOrderDetails());
		}
		ordersInfo.setItems(observableOrderInfo);
	}
	
	
	
	public void setMainApp(MainApp mainApp) {
	this.mainApp= mainApp;
	orders.setItems(observableOrder);
	}

}
