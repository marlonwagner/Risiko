package ris.local.valueobjects;

public class Laender {

	private String name;
	private int belegt;
	private int einheiten;
	private int id;
	
	
	
	public Laender(String name, int belegt, int einheiten, int id) {
		super();
		this.name = name;
		this.belegt = belegt;
		this.einheiten = einheiten;
		this.id = id;
	}


	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBelegt() {
		return belegt;
	}
	public void setBelegt(int belegt) {
		this.belegt = belegt;
	}
	public int getEinheiten() {
		return einheiten;
	}
	public void setEinheiten(int einheiten) {
		this.einheiten = einheiten;
	}
	
	

	
}
