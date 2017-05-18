package kookies.model;

public class Pallet {
	
	private int palletNbr;
	private Cookie cookie;
	private String productionTimeStamp;
	private int orderNbr;
	private boolean loaded;
	private boolean blocked;
	
	public Pallet(int palletNbr, Cookie cookieType, String productionTimeStamp){
		this.palletNbr = palletNbr;
		this.cookie = cookieType;
		this.productionTimeStamp = productionTimeStamp;
		orderNbr = 0;
		loaded = false;
		blocked = false;
	}
	
	public int getPalletNbr(){
		return palletNbr;
	}
	
	public Cookie getPalletType(){
		return cookie;
	}
	
	public String getProductionTimeStamp(){
		return productionTimeStamp.toString();
	}
	
	public void addToOrder(int orderNbr){
		this.orderNbr = orderNbr;
	}
	
	public void loadIntoTruck(){
		loaded = true;
	}
	
	public int blockDelivery(){
		blocked = true;
		return orderNbr;
	}
	
	public int getOrderNbr(){
		return orderNbr;
	}
	
	public boolean isLoaded(){
		return loaded;
	}
	
	public boolean isBlocked(){
		return blocked;
	}

}
