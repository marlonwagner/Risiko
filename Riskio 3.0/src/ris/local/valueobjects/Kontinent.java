package ris.local.valueobjects;

public class Kontinent {

	private Laender[] laenderArray;
	private String name;
	private int bonus;
	
	
	
	public Kontinent(Laender[] laenderArray, String name, int bonus) {
		super();
		this.laenderArray = laenderArray;
		this.name = name;
		this.bonus = bonus;
	}
	public Laender[] getLaenderArray() {
		return laenderArray;
	}
	public void setLaenderArray(Laender[] laenderArray) {
		this.laenderArray = laenderArray;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	
	
	
}
