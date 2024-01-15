package business.sporthallen;

public class Sporthalle {

	private String name;
	private int quadratmeter;
	private String bodenbelang;
	
	public Sporthalle(String name, int quadratmeter, String bodenbeglag) {
		this.name = name;
		this.quadratmeter = quadratmeter;
		this.bodenbelang = bodenbeglag;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuadratmeter() {
		return quadratmeter;
	}
	public void setQuadratmeter(int quadratmeter) {
		this.quadratmeter = quadratmeter;
	}
	public String getBodenbelang() {
		return bodenbelang;
	}
	public void setBodenbelang(String bodenbelang) {
		this.bodenbelang = bodenbelang;
	}
	
	
	public String gibSporthalleZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getQuadratmeter() + trenner
  		    + this.getBodenbelang() + trenner +"\n"
  		    ;
  	}
	
}
