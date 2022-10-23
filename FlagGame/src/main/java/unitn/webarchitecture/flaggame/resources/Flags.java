package unitn.webarchitecture.flaggame.resources;

public class Flags {
	private String country;
	private String capital;
	private int number;

	public Flags(String country, String capital, int number) {
		this.country = country;
		this.capital = capital;
		this.number = number;
	}
	
	public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
