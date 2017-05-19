package kookies.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
	
	private Customer customer;
	private int orderNbr;
	private String expectedDeliveryDate;
	private HashMap<Cookie,Pallet[]> pallets;
	private String deliveryTimeStamp;
	
	public Order(Customer customer, int orderNbr, String expectedDeliveryDate){
		this.customer = customer;
		this.orderNbr = orderNbr;
		this.expectedDeliveryDate = expectedDeliveryDate;
		pallets = new HashMap<Cookie,Pallet[]>();
	}
	
	public Customer getCustomer(){
		return customer;
	}
	
	public int gerOrderNbr(){
		return orderNbr;
	}
	
	public void orderPallets(Cookie typeOfCookie, int number){
		pallets.put(typeOfCookie, new Pallet[number]);
	}
	
	public void addPalletToOrder(Pallet pallet){
		Cookie palletType = pallet.getPalletType();
		if(pallets.containsKey(palletType)){
			Pallet[] palletArray = pallets.get(palletType);
			for(int i = 0 ; i < palletArray.length ; i++){
				if(palletArray[i] == null){
					palletArray[i] = pallet;
				}
			}
		}
	}
	
	public void removeBlockedPallets(){
		for(Cookie palletType : pallets.keySet()){
			Pallet[] palletArray = pallets.get(palletType);
			for(int i = 0 ; i < palletArray.length ; i++){
				if(palletArray[i].isBlocked()){
					palletArray[i] = null;
				}
			}
		}
	}
	
	public void setDeliveryTimeStamp(String timeStamp){
		this.deliveryTimeStamp = timeStamp;
	}
	
	public String getDeliveryTimeStamp(){
		return deliveryTimeStamp.toString();
	}
	
	public List<String> getOrderDetails(){
		ArrayList<String> orderDetails = new ArrayList<String>();
		orderDetails.add("Deliver to: " + customer.getName() + " in " + customer.getAddress() + " by " + expectedDeliveryDate);
		for(Cookie palletType : pallets.keySet()){
			Pallet[] palletArray = pallets.get(palletType);
			orderDetails.add(palletArray.length + " pallet(s) of " + palletType.getName());
			for(int i = 0 ; i < palletArray.length ; i++){
				if(palletArray[i] != null){
					orderDetails.add("Pallet Number: " + palletArray[i].getPalletNbr());
				}
			}
		}
		return orderDetails;
	}
	
	

}
