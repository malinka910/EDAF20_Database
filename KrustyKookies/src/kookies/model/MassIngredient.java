package kookies.model;

public class MassIngredient implements Ingredient {
	
	private String name;
	private double amount;
	private String unit = "g";
	
	public MassIngredient(String name, double amount){
		this.name = name;
		this.amount = amount;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public String getUnit() {
		return unit;
	}

}
