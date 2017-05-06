package model;

public class VolumeIngredient implements Ingredient {
	
	private String name;
	private double amount;
	private String unit = "dl";
	
	public VolumeIngredient(String name, double amount){
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
