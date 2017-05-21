package kookies.view;



import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	private List<Customer> customerList;
	private MainApp mainApp;
	private Customer currentCustomer;
	private Order currentOrder;
	
	private ObservableList<String> observableOrder = FXCollections.observableArrayList();
	private ObservableList<String> observableOrderInfo = FXCollections.observableArrayList();
	private ObservableList<String> observableCustomer = FXCollections.observableArrayList();
	
	
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
		
		choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        if(newValue == null){
		        	System.out.println("no selection");
		        }else{
		        	currentCustomer = setCurrentCustomer(newValue);
		        }
		    }
		});
		
		orders.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        if(newValue == null){
		        	System.out.println("no selection");
		        }else{
		        	int orderNbr = Integer.parseInt(newValue.substring(0,newValue.indexOf(" ")));
		        	currentOrder = setCurrentOrder(orderNbr);
		        	updateOrderInfoList();
		        }
		    }
		});
		
		customerList = db.getCustomerList();
		for(Customer c : customerList){
			observableCustomer.add(c.getName());
		}
		orderList = db.getUndeliveredOrders();
		for(Order o: orderList){
			observableOrder.add(String.valueOf(o.getOrderNbr()));
		}
		updateOrderList();
		choiceBox.setItems(observableCustomer);
		
	}
	
	@FXML	
	private void deliveredButtonClicked(){
		//TODO test
		db.orderDelivered(currentOrder);
		updateOrderList();
		updateOrderInfoList();
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
		
		int sum = 0;
		for(Integer i : list){
			sum = sum + i;
		}
		
		if(sum > 0){
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
		
	}
	
	private void updateOrderList(){
		orderList = db.getUndeliveredOrders();
		observableOrder.clear();
		for(Order o: orderList){
			observableOrder.add(o.getOrderNbr() + " : " + o.getExpectedDeliveryDate() + " " + o.getCustomer().getName());
		}
		orders.setItems(observableOrder);
	}
	
	private void updateOrderInfoList(){
		observableOrderInfo.clear();
		if(currentOrder != null){
			observableOrderInfo.addAll(currentOrder.getOrderDetails());
		}
		ordersInfo.setItems(observableOrderInfo);
		
	}
	
	private Customer setCurrentCustomer(String customerName){
		for(Customer c : customerList){
			if(c.getName().equals(customerName)){
				return c;
			}
		}
		return null;
	}
	
	private Order setCurrentOrder(int orderNbr){
		for(Order o : orderList){
			if(o.getOrderNbr() == orderNbr){
				return o;
			}
		}
		return null;
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp= mainApp;
		orders.setItems(observableOrder);
	}

}
