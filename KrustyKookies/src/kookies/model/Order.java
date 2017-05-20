package kookies.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
	
	private Customer customer;
	private int orderNbr;
	private String expectedDeliveryDate;
	private HashMap<Cookie,Pallet[]> pallets;
	
	public Order(Customer customer, String expectedDeliveryDate){
		this.customer = customer;
		this.expectedDeliveryDate = expectedDeliveryDate;
		pallets = new HashMap<Cookie,Pallet[]>();
	}
	
	public void setOrderNbr(int orderNbr){
		this.orderNbr = orderNbr;
	}
	
	public Customer getCustomer(){
		return customer;
	}
	
	public int getOrderNbr(){
		return orderNbr;
	}
	
	public String getExpectedDeliveryDate(){
		return expectedDeliveryDate.toString();
	}
	
	public int[] getPalletTotals(){
		int[] totals = new int[6];
		String[] cookies = {"Almond delight", "Amneris", "Berliner", "Nut cookie", "Nut ring", "Tango"};
		for(Cookie c : pallets.keySet()){
			for(int i = 0 ; i < 6 ; i++){
				if(cookies[i].equals(c.getName())){
					totals[i] = pallets.get(c).length;
					break;
				}
			}
		}
		return totals;
	}
	
	public void setPalletTotals(List<Cookie> typeOfCookie, List<Integer> number){
		for(int i = 0 ; i < typeOfCookie.size() ; i++){
			pallets.put(typeOfCookie.get(i), new Pallet[number.get(i)]);
		}
	}
	
	public void addPalletToOrder(Pallet pallet){
		Cookie palletType = pallet.getPalletType();
		if(pallets.containsKey(palletType)){
			Pallet[] palletArray = pallets.get(palletType);
			for(int i = 0 ; i < palletArray.length ; i++){
				if(palletArray[i] == null){
					palletArray[i] = pallet;
					break;
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
	
	public void removePallet(int palletNbr){
		for(Cookie c : pallets.keySet()){
			int i = 0;
			for(Pallet p : pallets.get(c)){
				if(p.getPalletNbr() == palletNbr){
					pallets.get(c)[i] = null;
					break;
				}else{
					i++;
				}
			}
		}
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
